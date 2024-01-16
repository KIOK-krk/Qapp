package com.example.nekikviz

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun rezultati(ttsCitacEkrana: CitacEkrana) {
    LaunchedEffect(Unit) {
        ttsCitacEkrana.citaj(
            "Imas 4/5 točnih odgovora. Bravo!"
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .wrapContentSize()
        ) {
            Column ( modifier = Modifier
                .padding(16.dp)
            ){
                Text(
                    text = "Imas 4/5 točnih odgovora. Bravo!",
                    fontSize = 22.sp,
                    color = Color.White,
                    fontFamily = FontFamily.Monospace

                )
            }
        }
    }
}
