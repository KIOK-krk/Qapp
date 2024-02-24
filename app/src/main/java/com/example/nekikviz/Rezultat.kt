package com.example.nekikviz

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun EkranRezultata(navigiranjeEkrana: NavHostController, ttsCitacEkrana: CitacEkrana) {
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
        DobarRezultat()
    }
}

@Composable
fun DobarRezultat() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
        ) {

            Image(
                painter = painterResource(id = R.drawable.dobarrezultat),
                contentDescription = "Slika dobrog rezultata",
                alignment = Alignment.TopCenter,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 30.dp)
            )
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "TOČNI ODGOVORI:",
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 19.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier
                .padding(top = 470.dp, start = 40.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.dobrirezultati),
            contentDescription = "Dobri rezultati",
            modifier = Modifier
                .size(160.dp)
                .offset(x = 33.dp, y = 250.dp)


        )
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "NETOČNI ODGOVORI:",
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 19.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier
                .padding(top = 580.dp, start = 40.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.losirezultati),
            contentDescription = "Losi rezultati",
            modifier = Modifier
                .size(160.dp)
                .offset(x = 8.dp, y = 310.dp)


        )
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.ponoviigru),
            contentDescription = "Gumb za ponoviti igru",
            alignment = Alignment.BottomCenter,
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 10.dp)
        )
    }
}


@Composable
fun LosRezultat() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
        ) {

            Image(
                painter = painterResource(id = R.drawable.losrezultat),
                contentDescription = "Slika dobrog rezultata",
                alignment = Alignment.TopCenter,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 30.dp)
            )
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "TOČNI ODGOVORI:",
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 19.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier
                .padding(top = 470.dp, start = 40.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.dobrirezultati),
            contentDescription = "Dobri rezultati",
            modifier = Modifier
                .size(160.dp)
                .offset(x = 33.dp, y = 250.dp)


        )
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "NETOČNI ODGOVORI:",
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 19.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier
                .padding(top = 580.dp, start = 40.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.losirezultati),
            contentDescription = "Losi rezultati",
            modifier = Modifier
                .size(160.dp)
                .offset(x = 8.dp, y = 310.dp)


        )
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.ponoviigru),
            contentDescription = "Gumb za ponoviti igru",
            alignment = Alignment.BottomCenter,
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 10.dp)
        )
    }
}
