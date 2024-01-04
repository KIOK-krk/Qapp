package com.example.nekikviz

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun screenzapitanja() {
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
            text = "Koja je sada godina?",
            color = Color.White,
            fontSize = 22.sp,
            fontFamily = FontFamily.Monospace,

            )
    }
}

@Composable
fun odgovori() {
    Button(
        onClick = { /*TODO*/ })
    {

    }
}
