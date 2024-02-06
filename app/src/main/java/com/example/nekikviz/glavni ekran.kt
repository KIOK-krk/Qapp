package com.example.nekikviz


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource


@Composable
fun glavniEkran() {
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
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            //Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.slikapocetak),
                contentDescription = "Veliki Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(ratio = 1f)
            )
            Image(
                painter = painterResource(id = R.drawable.learnleague),
                contentDescription = "Naslov",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(ratio = 1f)
            )
            //Spacer(modifier = Modifier.weight(1f))

        }
        Column {
            Button(
                modifier = Modifier,
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(colorResource(R.color.orange))
            )
            {
                Text(
                    text = "Škola",
                    color = Color.White
                )
            }
            Button(
                modifier = Modifier,
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(colorResource(R.color.cyanblue))
            )
            {
                Text(
                    text = "Zabava",
                    color = Color.White
                )
            }
            OutlinedButton(
                modifier = Modifier,
                onClick = { /*TODO*/ }
            )
            {
                Text(
                    text = "Kodovi",
                    color = Color.White
                )
            }
        }
    }
}
