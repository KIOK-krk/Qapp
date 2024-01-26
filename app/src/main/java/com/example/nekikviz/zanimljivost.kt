package com.example.nekikviz

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun zanimljivost(navigiranjeEkrana: NavHostController, ttsCitacEkrana: CitacEkrana) {
    LaunchedEffect(Unit) {
        ttsCitacEkrana.citaj( "Jeste li znali?" + "\n\n\n Procesor (engl. central processing unit − CPU, hrv.središnja jedinica za obradbu,\n" +
                "glavni je dio računala koji vođen zadanim programskim naredbama izvodi osnovne\" " +
                "\n radnje nad podacima.",
        )
    }
    Column(
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(16.dp)
                    .clickable {
                        navigiranjeEkrana.navigate("rezultati")
                    }
            ) {
                Column ( modifier = Modifier
                        .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = "Jeste li znali?" +
                                "\n\n\nProcesor (engl. central processing unit − CPU, hrv.središnja jedinica za obradbu," +
                                " glavni je dio računala koji vođen zadanim programskim naredbama izvodi osnovne" +
                                " radnje nad podacima.",
                        fontSize = 22.sp,
                        color = Color.White,
                        fontFamily = FontFamily.Monospace

                    )
                }
            }
        }
    }
}