package com.example.nekikviz

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.wajahatkarim.flippable.FlipAnimationType
import com.wajahatkarim.flippable.Flippable
import com.wajahatkarim.flippable.rememberFlipController

@Composable
fun Flashcard(
    ttsCitacEkrana: CitacEkrana,
    navigiranjeEkrana: NavHostController,
    idLekcije: String?,
    viewModel: FlashcardViewModel = viewModel()

) {
    val controller = rememberFlipController()
    val pitanja: List<Pitanje> = viewModel.svaPitanja.collectAsState().value
    val ucitavanje by viewModel.ucitavanje.collectAsState()

    LaunchedEffect(idLekcije) {
        viewModel.ucitajPitanjaSkola(idLekcije)
    }
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
            .padding(28.dp)
    ) {
        if (ucitavanje == false) {

            Flippable(
                frontSide = {
                    prednjaStranaFlashCarda(ttsCitacEkrana, pitanja)
                },

                backSide = {
                    zadnjaStranaFlashCarda(ttsCitacEkrana, pitanja)
                },
                flipController = controller,
                modifier = Modifier
                    .padding(top = 30.dp, bottom = 30.dp, start = 120.dp, end = 120.dp),
                flipDurationMs = 400,
                flipOnTouch = true,
                flipEnabled = true,
                contentAlignment = Alignment.TopCenter,
                autoFlip = false,
                autoFlipDurationMs = 1000,
                flipAnimationType = FlipAnimationType.HORIZONTAL_CLOCKWISE,
                cameraDistance = 30.0F,
            )
        }
    }
}

@Composable
fun prednjaStranaFlashCarda(ttsCitacEkrana: CitacEkrana, pitanja: List<Pitanje>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Top

            ) {

            Text(
                text = pitanja.get(0).tekstPitanja,
                fontSize = 32.sp,
                color = Color(0xff280a82),
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                       // .align(Alignment.Center)
                    .padding(top = 40.dp,start = 20.dp, end = 20.dp)
                    .offset(x = 10.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.upitnici),
                contentDescription = "Question marks",
                modifier = Modifier
                    //  .align(Alignment.TopCenter)
                    .size(150.dp)
                    .padding(end = 80.dp)
                    .offset(y = 40.dp, x = 150.dp)
            )
            TextButton(
                onClick = {}

            ) {
                Text(
                    modifier = Modifier
                        .offset(y = 10.dp, x = 110.dp),
                    text = "Vidi odgovor",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End,
                    color = colorResource(id = R.color.green)
                )
            }
        }
    }
}

@Composable
fun zadnjaStranaFlashCarda(ttsCitacEkrana: CitacEkrana, pitanja: List<Pitanje>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))

    ) {
        Text(
            text = pitanja.get(0).odgovori.get(
                pitanja.get(0).tocanOdgovor.toInt() - 1
            )
        )
    }
}