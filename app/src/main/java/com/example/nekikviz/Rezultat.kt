package com.example.nekikviz

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun EkranRezultata(){
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
   ){
       DobarRezultat()
   }
}
@Composable
fun DobarRezultat(){
    Column (
    ){
        Image(
            painter = painterResource(id = R.drawable.dobarrezultat),
            contentDescription = "Slika dobrog rezultata",
            alignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp)

        )
        Image(
            painter = painterResource(id = R.drawable.ponoviigru) ,
            contentDescription = "Gumb za ponoviti igru",
            alignment = Alignment.Center
        )
    }
}

@Composable
fun LosRezultat() {

    Column {

        Image(
            painter = painterResource(id = R.drawable.losrezultat),
            contentDescription = "Slika dobrog rezultata",
            alignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp)
        )
    }
}