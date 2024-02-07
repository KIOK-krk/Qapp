package com.example.nekikviz


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


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
                alignment = Alignment.TopCenter,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 5.dp)
                    .aspectRatio(ratio = 1f)
            )

            Image(
                painter = painterResource(id = R.drawable.learnleague),
                contentDescription = "Naslov",
                alignment = Alignment.TopCenter,
                modifier = Modifier
                    .padding(bottom = 100.dp)
                    .fillMaxWidth()
                    .aspectRatio(ratio = 1f)
            )
            //Spacer(modifier = Modifier.weight(1f))
        }
    }
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp)
                .defaultMinSize(minHeight = 64.dp, minWidth = 280.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(colorResource(R.color.orange)),
            border = BorderStroke(width = 1.dp, color = Color.White)
        )
        {
            Text(
                text = "Zabava",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Button(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp)
                .defaultMinSize(minHeight = 64.dp, minWidth = 280.dp),
            onClick = { },
            colors = ButtonDefaults.buttonColors(colorResource(R.color.cyanblue)),
            border = BorderStroke(width = 1.dp, color = Color.White)
        )
        {
            Text(
                text = "Škola",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        OutlinedButton(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 60.dp)
                .defaultMinSize(minHeight = 64.dp, minWidth = 280.dp),
            onClick = { /*TODO*/ },
            border = BorderStroke(width = 1.dp, color = Color.White)
        )
        {
            Text(
                text = "Kodovi",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}








