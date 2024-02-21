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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Zanimljivost() {
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
            Text(
                modifier = Modifier
                    .padding(top = 42.dp),
                text = "Jeste li znali?",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Card(
                colors = CardDefaults.cardColors(Color.Transparent)
            ) {
                Card(
                    modifier = Modifier
                        .padding(top = 2.dp, start = 20.dp, end = 20.dp)
                        .size(width = 320.dp, height = 400.dp),

                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(Color.White),

                    ) {

                    Text(
                        text = "Procesor (engl. central processing unit − CPU) " +
                                "glavni je dio računala koji vođen zadanim programskim" +
                                " naredbama izvodi osnovne radnje nad podacima.",
                        color = Color(0xff280a82),
                        fontSize = 28.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.usklicnik),
                    contentDescription = "Uskličnik",
                    modifier = Modifier
                        .size(140.dp)
                        .padding(bottom = 90.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.gumbzadalje),
                    contentDescription = "Gumb za dalje",
                    modifier = Modifier
                        .size(140.dp)
                        .padding(bottom = 40.dp)

                )
            }
        }
    }
}