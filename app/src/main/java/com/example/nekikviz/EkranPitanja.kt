package com.example.nekikviz

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay


@Composable
fun EkranPitanja(
    navigiranjeEkrana: NavHostController,
    ttsCitacEkrana: CitacEkrana,
    nacinRada: Int,
    viewModel: EkranPitanjaViewModel = viewModel(),
) {
    // nacinRada:
    // 0 - zabava
    // 1 - skola
    // 2 - uciteljski kodovi

    val context = LocalContext.current
    val ucitavanje by viewModel.ucitavanje.collectAsState()

    LaunchedEffect(Unit) {
        when (nacinRada) {
            0 -> viewModel.ucitajPitanjaZabava(context)
            //1 -> viewModel.ucitajPitanjaSkola(context)
            //2 -> viewModel.ucitajPitanjaUcitelj(context)
        }
    }

    val trenutnoPitanjeIndex by viewModel.trenutnoPitanjeIndex.collectAsState()
    val pitanja: List<Pitanje> = viewModel.svaPitanja.collectAsState().value
    val trenutnoPitanje: Pitanje


    if (ucitavanje == true) {
        CircularProgressIndicator()
    } else {

        trenutnoPitanje = pitanja[trenutnoPitanjeIndex]
        viewModel.startajVrijeme()

        LaunchedEffect(Unit) {
            ttsCitacEkrana.citaj(
                trenutnoPitanje.tekstPitanja + "? " +
                        "odgovor pod brojem jedan " + trenutnoPitanje.odgovori[0] + " " +
                        "odgovor pod brojem dva " + trenutnoPitanje.odgovori[1] + " " +
                        "odgovor pod brojem tri  " + trenutnoPitanje.odgovori[2]
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF7FA3FF),
                            Color(0xFF634FDC)
                        )
                    )
                )
                .padding(top = 28.dp)
        ) {
            Text(text = viewModel.bodovi.collectAsState().value.toString())
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                NaslovEkrana((trenutnoPitanjeIndex + 1).toString(), navigiranjeEkrana)
                VrijemeProgressBar(vrijeme = viewModel.vrijeme.collectAsState().value / 20000f)
                TekstPitanja(trenutnoPitanje.tekstPitanja)
                GumbZaOdgovor(
                    trenutnoPitanje.odgovori[0],
                    trenutnoPitanje.tocanOdgovor,
                    1,
                    viewModel,
                    trenutnoPitanjeIndex
                )
                GumbZaOdgovor(
                    trenutnoPitanje.odgovori[1],
                    trenutnoPitanje.tocanOdgovor,
                    2,
                    viewModel,
                    trenutnoPitanjeIndex
                )
                GumbZaOdgovor(
                    trenutnoPitanje.odgovori[2],
                    trenutnoPitanje.tocanOdgovor,
                    3,
                    viewModel,
                    trenutnoPitanjeIndex
                )
            }
            IkonaZaDalje(
                R.drawable.gumbzadalje,
                Modifier.align(Alignment.BottomEnd),
                navigiranjeEkrana,
                viewModel
            )
        }
    }
}


@Composable
fun NaslovEkrana(brojPitanja: String,navigiranjeEkrana:NavHostController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.povratak),
            contentDescription = "Left Icon",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(32.dp)
                .padding()
                .clickable {
                    navigiranjeEkrana.navigate("glavniEkran")
                }
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = brojPitanja + ". Pitanje",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 40.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}


@Composable
fun VrijemeProgressBar(vrijeme: Float) {
    val ukupnoVrijeme = 5000L
    val trenutnoVrijeme = remember { mutableStateOf(ukupnoVrijeme) }

    val progress = animateFloatAsState(
        targetValue = trenutnoVrijeme.value.toFloat() / ukupnoVrijeme,
        animationSpec = TweenSpec(
            durationMillis = ukupnoVrijeme.toInt(),
            easing = LinearEasing
        ),
        finishedListener = {
            //  kod sto kad istkne vrijeme
        }
    )

    LaunchedEffect(key1 = true){
        val pocetnoVrijeme = System.currentTimeMillis()
        while(trenutnoVrijeme.value > 0){
            val protekloVrijeme = System.currentTimeMillis() - pocetnoVrijeme
            trenutnoVrijeme.value = ukupnoVrijeme - protekloVrijeme
            if(trenutnoVrijeme.value <= 0){
                trenutnoVrijeme.value = 0
            }
            delay(100L)
        }

    }



    LinearProgressIndicator(
        progress = progress.value,
        trackColor = Color(0xFF7646FE),
        color = Color(0xFFFF9051),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(8.dp)
    )
}


@Composable
fun TekstPitanja(pitanjeTekst: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 64.dp, bottom = 16.dp)
    ) {
        BasicTextField(
            value = pitanjeTekst,
            onValueChange = {},
            enabled = false,
            textStyle = TextStyle(
                color = Color(0xff280a82),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .defaultMinSize(minHeight = 200.dp)
                .background(Color.White, RoundedCornerShape(40.dp))
                .padding(start = 16.dp, end = 16.dp, top = 64.dp, bottom = 16.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.upitnik),
            contentDescription = "Decorative Image",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(100.dp)
                .offset(y = -50.dp)
        )
    }
}


@Composable
fun GumbZaOdgovor(
    text: String,
    tocan: Int,
    poredak: Int,
    viewModel: EkranPitanjaViewModel,
    trenutnoPitanjeIndex: Int
) {
    var bojaGumba by remember { mutableStateOf(Color.Transparent) }
    var stisnutGumb = viewModel.stisnutGumb.collectAsState().value
    var iconRes by remember { mutableStateOf(0) }

    LaunchedEffect(trenutnoPitanjeIndex) {
        bojaGumba = Color.Transparent
        iconRes = 0
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .border(1.dp, Color.White, RoundedCornerShape(12.dp))
            .background(
                bojaGumba,
                RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 16.dp, vertical = 20.dp)
            .clickable {
                if (stisnutGumb == false) {
                    if (tocan == poredak) {
                        bojaGumba = Color(0xff08c9c9)
                        iconRes = R.drawable.tocno
                    } else {
                        bojaGumba = Color(0xbaff372a)
                        iconRes = R.drawable.krivo
                    }
                    stisnutGumb = true
                    viewModel.odgovoriPitanje(poredak)
                }
            }
    ) {
//        if (stisnutGumb == true) {
//            Image(
//                painter = painterResource(id = iconRes),
//                contentDescription = "Answer Icon",
//                modifier = Modifier.size(32.dp)
//            )
//            Spacer(modifier = Modifier.width(8.dp))
//        } else {
        Spacer(modifier = Modifier.width(40.dp))
//        }
        Text(
            text = text, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun IkonaZaDalje(
    iconRes: Int,
    modifier: Modifier = Modifier,
    navigiranjeEkrana: NavHostController,
    viewModel: EkranPitanjaViewModel
) {
    Image(
        painter = painterResource(id = iconRes),
        contentDescription = "Navigation Icon",
        modifier = modifier
            .size(150.dp)
            .padding(16.dp)
            .clickable {
                viewModel.sljedecePitanje()
                //navigiranjeEkrana.navigate("zanimljivost")
            }
    )
}