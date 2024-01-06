package com.example.nekikviz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun pitanja() {
    Card(
        colors = CardDefaults.cardColors(colorResource(R.color.blue)),
        modifier = Modifier
            .padding(25.dp)
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(28.dp),
            text = "1. Koja je sada godina?",
            color = Color.White,
            fontSize = 22.sp,
            fontFamily = FontFamily.Monospace,

            )
    }
}

@Composable
fun odgovori() {
    Column (
        verticalArrangement = Arrangement.SpaceEvenly,

    ){
        FilledTonalButton(
            modifier = Modifier
                .width(width = 400.dp)
                .padding(horizontal = 20.dp),
            onClick = { /*TODO*/ }

        ) {
            Text(
                text = "2023.",
                fontSize = 20.sp
            )
        }
        FilledTonalButton(
            modifier = Modifier
                .width(width = 400.dp)
                .padding(horizontal = 20.dp),
            onClick = { /*TODO*/ }

        ) {
            Text(
                text = "2024.",
                fontSize = 20.sp
            )
        }
        FilledTonalButton(
            modifier = Modifier
                .width(width = 400.dp)
                .padding(horizontal = 20.dp),
            onClick = { /*TODO*/ }

        ) {
            Text(
                text = "2025.",
                fontSize = 20.sp
            )
        }
    }
}
