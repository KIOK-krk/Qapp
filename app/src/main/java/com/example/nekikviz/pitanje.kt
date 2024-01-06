package com.example.nekikviz

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
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
fun pitanjaIodgovori() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
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
        FilledTonalButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            colors = ButtonDefaults.buttonColors(colorResource(R.color.blue)),
            onClick = { /*TODO*/ }

        ) {
            Text(
                text = "CPU (procesor)",
                color = Color.White,
                fontSize = 20.sp
            )
        }
        FilledTonalButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            colors = ButtonDefaults.buttonColors(colorResource(R.color.blue)),
            onClick = { /*TODO*/ }

        ) {
            Text(
                text = "MBO (matična ploča)",
                color = Color.White,
                fontSize = 20.sp
            )
        }
        FilledTonalButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            colors = ButtonDefaults.buttonColors(colorResource(R.color.blue)),
            onClick = { /*TODO*/ }

        ) {
            Text(
                text = "OS (operacijski sustav)",
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
}



