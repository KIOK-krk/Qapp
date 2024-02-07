package com.example.nekikviz

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
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun EkranPitanja() {
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
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            NaslovEkrana()
            VrijemeProgressBar(vrijeme = 0.75f)
            TekstPitanja()
            GumbZaOdgovor("MBO (matična ploča)", R.drawable.tocno, 2)
            GumbZaOdgovor("OS(operacijski sustav)", R.drawable.tocno, 0)
            GumbZaOdgovor("CPU (procesor)", R.drawable.krivo, 1)
        }
        IkonaZaDalje(R.drawable.strelicadalje, Modifier.align(Alignment.BottomEnd))
    }
}


@Composable
fun NaslovEkrana() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.povratak),
            contentDescription = "Left Icon",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "1. Pitanje",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.weight(1f)) // Dodaje se još jedan Spacer da zadrži simetričnost
    }
}


@Composable
fun VrijemeProgressBar(vrijeme: Float) {
    LinearProgressIndicator(
        progress = vrijeme,
        trackColor = Color(0xFF7646FE),
        color = Color(0xFFFF9051),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(8.dp)
    )
}


@Composable
fun TekstPitanja() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 64.dp, bottom = 16.dp)
    ) {
        BasicTextField(
            value = "Koji je najbitniji dio kompjutera?",
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
                .offset(y = -50.dp) // Pomiče sliku prema gore za polovicu njene visine
        )
    }
}


@Composable
fun GumbZaOdgovor(text: String, iconRes: Int, stisnutGumb: Int) {
    // stisnutGumb = 0 -> nije odgovoreno
    // stisnutGumb = 1 -> točno
    // stisnutGumb = 2 -> krivo
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .border(1.dp, Color.White, RoundedCornerShape(12.dp))
            .background(
                if (stisnutGumb == 1) Color(0xbaff372a)
                else if (stisnutGumb == 2) Color(0xff08c9c9)
                else Color.Transparent,
                // ovaj if gore mozemo napisati i ovako
                // sa naredbom when:
                //                 when (stisnutGumb) {
                //                    1 -> Color(0xbaff372a)
                //                    2 -> Color(0xff08c9c9)
                //                    else -> Color.Transparent
                //                },
                RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 16.dp, vertical = 20.dp)
            .clickable {
                // ovdje radimo on Click kod
            }
    ) {
        if (stisnutGumb != 0) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = "Answer Icon",
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
        } else {
            Spacer(modifier = Modifier.width(40.dp))
        }
        Text(
            text = text, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun IkonaZaDalje(iconRes: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = iconRes),
        contentDescription = "Navigation Icon",
        modifier = modifier
            .size(128.dp)
            .padding(16.dp)
    )
}