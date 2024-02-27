package com.example.nekikviz

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun EkranRezultata(
    navigiranjeEkrana: NavHostController,
    ttsCitacEkrana: CitacEkrana,
    tocni: String?,
    netocni: String?,
    bodovi: String?
) {
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
        DobarRezultat(navigiranjeEkrana,bodovi)
    }
}

@Composable
fun DobarRezultat(navigiranjeEkrana: NavHostController,bodovi: Int?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .padding(top = 30.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.povratak),
                contentDescription = "Left Icon",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(56.dp)
                    .padding(start = 15.dp, top = 29.dp)
                    .clickable {
                        navigiranjeEkrana.navigate("glavniEkran")
                    }
            )

            if (bodovi != null) {
                Image(
                    painter = if(bodovi>=3) painterResource(id = R.drawable.dobarrezultat)
                    else painterResource(id = R.drawable.losrezultat),
                    contentDescription = "Slika dobrog rezultata",
                    alignment = Alignment.TopCenter,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 35.dp)
                )
            }
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
                .padding(top = 450.dp, start = 40.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.dobrirezultati),
            contentDescription = "Dobri rezultati",
            modifier = Modifier
                .size(160.dp)
                .offset(x = 33.dp, y = 240.dp)

        )
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "NETOČNI ODGOVORI:",
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 19.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier
                .padding(top = 550.dp, start = 40.dp)
        )


        Image(
            painter = painterResource(id = R.drawable.losirezultati),
            contentDescription = "Losi rezultati",
            modifier = Modifier
                .size(160.dp)
                .offset(x = 8.dp, y = 300.dp)
        )
    }
    Row (){
        Text(
            text = "UKUPAN REZULTAT:",
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 19.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier
                .padding(top = 650.dp, start = 40.dp)
        )
        Text(
            text = "170",
            textAlign = TextAlign.End,
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier
                .padding(top = 650.dp, start = 83.dp)
        )
    }
    Text(
        text = "9",
        textAlign = TextAlign.Center,
        color = Color.White,
        fontSize = 22.sp,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily.Monospace,
        maxLines = 1,
        modifier = Modifier
            .width(240.dp)
            .offset(x = (192).dp, y = 445.dp)

    )

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
                .clickable { navigiranjeEkrana.navigate("ekranPitanja") }
        )
    }
}


@Composable
fun LosRezultat(navigiranjeEkrana: NavHostController, bodovi: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .padding(top = 30.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.povratak),
                contentDescription = "Left Icon",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(56.dp)
                    .padding(start = 15.dp, top = 29.dp)
                    .clickable {
                        navigiranjeEkrana.navigate("glavniEkran")
                    }
            )

            if (bodovi != null) {
                Image(
                    painter = if(bodovi.toInt()>=3) painterResource(id = R.drawable.dobarrezultat)
                    else painterResource(id = R.drawable.losrezultat),
                    contentDescription = "Slika loseg rezultata",
                    alignment = Alignment.TopCenter,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 35.dp)
                )
            }
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
                .padding(top = 450.dp, start = 40.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.dobrirezultati),
            contentDescription = "Dobri rezultati",
            modifier = Modifier
                .size(160.dp)
                .offset(x = 33.dp, y = 240.dp)
        )
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "NETOČNI ODGOVORI:",
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 19.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier
                .padding(top = 550.dp, start = 40.dp)
        )


        Image(
            painter = painterResource(id = R.drawable.losirezultati),
            contentDescription = "Losi rezultati",
            modifier = Modifier
                .size(160.dp)
                .offset(x = 8.dp, y = 300.dp)
        )
    }
    Row (){
        Text(
            text = "UKUPAN REZULTAT:",
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 19.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier
                .padding(top = 650.dp, start = 40.dp)
        )
        Text(
            text = "170",
            textAlign = TextAlign.End,
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier
                .padding(top = 650.dp, start = 83.dp)
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
                .clickable { navigiranjeEkrana.navigate("ekranPitanja") }
        )
    }
}