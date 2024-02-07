package com.example.nekikviz

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun PocetniMeni(){
    Column (
        modifier = Modifier
    ){
        Image(
            painter = painterResource(id = R.drawable.pocetnaslika),
            contentDescription = "Slika na pocetku",
            contentScale = ContentScale.Fit,
            )
        Image(
            painter = painterResource(id = R.drawable.learnleague),
            contentDescription = "Ime aplikacije",
            contentScale = ContentScale.Fit,
        )
    }
}
