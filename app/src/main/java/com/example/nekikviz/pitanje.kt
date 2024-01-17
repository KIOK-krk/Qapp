package com.example.nekikviz

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun pitanjaIodgovori(prolazakEkranima: NavHostController, ttsCitacEkrana: CitacEkrana) {
    val colorGreen = colorResource(R.color.green)
    val lightBlueColor = colorResource(R.color.lightblue)
    var obrubButton by remember { mutableStateOf(lightBlueColor) }
    var obrubButton2 by remember { mutableStateOf(lightBlueColor) }
    var obrubButton3 by remember { mutableStateOf(lightBlueColor) }


    LaunchedEffect(Unit) {
        ttsCitacEkrana.citaj(
            "1. Koji je najbitniji dio kompjutera? "
                    + "A) CPU (procesor)"
                    + "B) MBO (matična ploča)"
                    + "C) OS (operacijski sustav)"
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 30.dp)
            .defaultMinSize(minHeight = 64.dp),
    ) {
        Card(
            colors = CardDefaults.cardColors(colorResource(R.color.darkblue)),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier
                    .padding(28.dp),
                text = "1. Koji je najbitniji dio kompjutera?",
                color = Color.White,
                fontSize = 22.sp,
                fontFamily = FontFamily.Monospace
            )
        }
        Column {
            FilledTonalButton(
                modifier = Modifier
                    .padding(start = 35.dp, end = 10.dp, top = 10.dp, bottom = 10.dp)
                    .defaultMinSize(minHeight = 64.dp, minWidth = 280.dp)
                    .border(4.dp, obrubButton, shape = RoundedCornerShape(24.dp)),
                colors = ButtonDefaults.buttonColors(colorResource(R.color.blue)),
                onClick = {
                    obrubButton = colorGreen
                    prolazakEkranima.navigate("zanimljivost")
                }

            ) {
                Text(
                    text = "CPU (procesor)",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
            FilledTonalButton(
                modifier = Modifier
                    .padding(start = 35.dp, end = 10.dp, top = 10.dp, bottom = 10.dp)
                    .defaultMinSize(minHeight = 64.dp, minWidth = 280.dp)
                    .border(4.dp, obrubButton2, shape = RoundedCornerShape(24.dp)),
                colors = ButtonDefaults.buttonColors(colorResource(R.color.blue)),
                onClick = {
                    obrubButton2 = Color.Red
                }

            ) {
                Text(
                    text = "MBO (matična ploča)",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
            FilledTonalButton(
                modifier = Modifier
                    .padding(start = 35.dp, end = 10.dp, top = 10.dp, bottom = 10.dp)
                    .defaultMinSize(minHeight = 64.dp, minWidth = 280.dp)
                    .border(4.dp, obrubButton3, shape = RoundedCornerShape(24.dp)),
                colors = ButtonDefaults.buttonColors(colorResource(R.color.blue)),
                onClick = {
                    obrubButton3 = Color.Red

                }

            ) {
                Text(
                    text = "OS (operacijski sustav)",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
        }
        AnimacijaUpitnik()
    }
}

@Composable
fun AnimacijaUpitnik() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animacijaupitnik))
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        contentScale = ContentScale.FillWidth,
    )
}











