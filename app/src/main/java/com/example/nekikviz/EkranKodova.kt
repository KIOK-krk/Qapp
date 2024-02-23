package com.example.nekikviz

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun EkranKodova (navigiranjeEkrana: NavHostController) {
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
        Naslov()
        ListaGumbova(buttons = buttonList, buttonTexts = buttonTextList)
    }
}
@Composable
fun Naslov(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.povratak),
            contentDescription = "Left Icon",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(32.dp)
                .padding()
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Kodovi",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 40.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun ListaGumbova (buttons: List<String>, buttonTexts: List<String>) {
    require(buttons.size == buttonTexts.size)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(60.dp)
    ) {
        items(buttons.size) { index ->
            OutlinedButton(
                onClick = { },
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Black
                ),
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = buttonTexts[index])
            }
        }
    }
}
val buttonList = listOf("Button 1", "Button 2", "Button 3", "Button 4", "Button 5", "Button 6")
val buttonTextList = listOf("Predmet - Lekcija - Autor", "Predmet - Lekcija - Autor",
                            "Predmet - Lekcija - Autor", "Predmet - Lekcija - Autor",
                            "Predmet - Lekcija - Autor", "Predmet - Lekcija - Autor")
