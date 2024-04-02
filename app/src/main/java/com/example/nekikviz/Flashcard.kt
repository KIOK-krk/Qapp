package com.example.nekikviz

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.wajahatkarim.flippable.FlipAnimationType
import com.wajahatkarim.flippable.Flippable
import com.wajahatkarim.flippable.FlippableController
import com.wajahatkarim.flippable.rememberFlipController

@Composable
fun Flashcard(
    ttsCitacEkrana: CitacEkrana,
    navigiranjeEkrana: NavHostController,
    idLekcije: String?,
    viewModel: FlashcardViewModel = viewModel()
) {
    val controller = rememberFlipController()
    val pitanja: List<Pitanje> = viewModel.svaPitanja.collectAsState().value
    val ucitavanje by viewModel.ucitavanje.collectAsState()
    val prednjaStrana by viewModel.prednjaStrana.collectAsState()
    val context = LocalContext.current
    val trajanjeOkretanjaKartice: Int = viewModel.trajanjeOkretanjaKartice.collectAsState().value

    LaunchedEffect(idLekcije) {
        viewModel.ucitajPitanjaSkola(idLekcije)
    }

    LaunchedEffect(prednjaStrana) {
        if (prednjaStrana) {
            val textZaCitanje = if (pitanja.isNotEmpty()) pitanja.get(0).tekstPitanja else ""
            ttsCitacEkrana.citaj(textZaCitanje)
        } else {
            val textZaCitanje =
                if (pitanja.isNotEmpty()) pitanja.get(0).odgovori.get(pitanja.get(0).tocanOdgovor.toInt() - 1) else ""
            ttsCitacEkrana.citaj(textZaCitanje)
        }
    }

    DisposableEffect(
        key1 = context
    ) {
        (context as? Activity)?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        onDispose {
            (context as? Activity)?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
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
            .padding(28.dp)

    ) {
        Image(
            painter = painterResource(id = R.drawable.slikal),
            contentDescription = "Picture on the left",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                //  .fillMaxSize()
                .padding(end = 600.dp)
                .size(230.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        )
        {
            Image(
                painter = painterResource(id = R.drawable.povratak),
                contentDescription = "Left Icon",
                contentScale = ContentScale.Fit,
                alignment = Alignment.CenterEnd,
                modifier = Modifier
                    .size(32.dp)
                    .padding()
                    .clickable {
                        ttsCitacEkrana.shutDown()
                        navigiranjeEkrana.navigate("predmetiEkran")
                    }
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Predmeti",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 670.dp)
            )
        }
        // kako napraviti da sve bude na cijelom ekranu
        if (ucitavanje == false) {

            Flippable(
                frontSide = {
                    prednjaStranaFlashCarda(ttsCitacEkrana, pitanja, controller, viewModel)
                },

                backSide = {
                    zadnjaStranaFlashCarda(ttsCitacEkrana, pitanja, viewModel, controller)
                },
                flipController = controller,
                modifier = Modifier
                    .padding(top = 30.dp, bottom = 30.dp, start = 120.dp, end = 120.dp),
                flipDurationMs = trajanjeOkretanjaKartice,
                flipOnTouch = false,
                flipEnabled = true,
                contentAlignment = Alignment.TopCenter,
                autoFlip = false,
                autoFlipDurationMs = 1000,
                flipAnimationType = FlipAnimationType.HORIZONTAL_CLOCKWISE,
                cameraDistance = 30.0F,
            )
        }
    }
    Image(
        painter = painterResource(id = R.drawable.slikad),
        contentDescription = "Picture on the left",
        contentScale = ContentScale.Fit,
        alignment = Alignment.CenterEnd

    )
}

@Composable
fun prednjaStranaFlashCarda(
    ttsCitacEkrana: CitacEkrana,
    pitanja: List<Pitanje>,
    controller: FlippableController,
    viewModel: FlashcardViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.upitnici),
            contentDescription = "Question marks",
            modifier = Modifier
                .align(Alignment.Center)
                .size(250.dp)
        )

        val textZaCitanje = if (pitanja.isNotEmpty()) pitanja.get(0).tekstPitanja else ""
        ttsCitacEkrana.citaj(textZaCitanje)

        Text(
            text = if (pitanja.isNotEmpty()) pitanja.get(0).tekstPitanja
            else {
                "Završila/o si ponavljanje, bravo!"
            },
            fontSize = 32.sp,
            color = Color(0xff280a82),
            fontWeight = FontWeight.ExtraBold,
            lineHeight = 32.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 40.dp, start = 20.dp, end = 20.dp)
                .align(Alignment.Center)
                .offset(y = -13.dp)
        )

        if (pitanja.isNotEmpty()) {
            Text(
                text = "Vidi odgovor >",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                color = colorResource(id = R.color.green),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 14.dp, bottom = 10.dp)
                    .clickable {
                        controller.flip()
                        viewModel.okreniKarticu()
                    }
            )
        }
    }
}


@Composable
fun zadnjaStranaFlashCarda(
    ttsCitacEkrana: CitacEkrana,
    pitanja: List<Pitanje>,
    viewModel: FlashcardViewModel,
    controller: FlippableController,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        //citanje odgovora
        val prednjaStrana by viewModel.prednjaStrana.collectAsState()

        LaunchedEffect(prednjaStrana) {
            if (!prednjaStrana) {
                val textZaCitanje = if (pitanja.isNotEmpty()) pitanja.get(0).odgovori.get(
                    pitanja.get(0).tocanOdgovor.toInt() - 1
                ) else ""
                ttsCitacEkrana.citaj(textZaCitanje)
            }
        }

        Image(
            painter = painterResource(id = R.drawable.uskljicnici),
            contentDescription = "Question marks",
            modifier = Modifier
                .align(Alignment.Center)
                .size(170.dp)

        )

        val textZaCitanje = if (pitanja.isNotEmpty()) pitanja.get(0).odgovori.get(
            pitanja.get(0).tocanOdgovor.toInt() - 1
        ) else ""
        ttsCitacEkrana.citaj(textZaCitanje)

        if (!prednjaStrana) {
            Text(
                text = if (pitanja.isNotEmpty()) pitanja.get(0).odgovori.get(
                    pitanja.get(0).tocanOdgovor.toInt() - 1
                ) else "TEST",
                fontSize = 32.sp,
                color = Color(0xff280a82),
                fontWeight = FontWeight.ExtraBold,
                lineHeight = 32.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 40.dp, start = 20.dp, end = 20.dp)
                    .align(Alignment.Center)
                    .offset(y = -10.dp)
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {

            TextButton(
                onClick = {
                    controller.flipToFront()
                    viewModel.znaoSamPitanje(pitanja.first())
                    viewModel.sljedecePitanje()
                    viewModel.okreniKarticu()
                },
                enabled = !prednjaStrana,
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = Color(0xFF09CACA),
                        shape = RoundedCornerShape(bottomStart = 16.dp)
                    )
            )
            {
                Text(
                    text = "Znao sam",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
            }

            TextButton(
                onClick = {
                    controller.flipToFront()
                    viewModel.nisamZnaoPitanje(pitanja.first())
                    viewModel.sljedecePitanje()
                    viewModel.okreniKarticu()
                },
                enabled = !prednjaStrana,
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = Color(0xFFFF6D64),
                        shape = RoundedCornerShape(bottomEnd = 16.dp)
                    )
            ) {
                Text(
                    text = "Nisam znao",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}