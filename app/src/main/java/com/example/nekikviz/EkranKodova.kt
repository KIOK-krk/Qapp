package com.example.nekikviz

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController


@Composable
fun EkranKodova(navigiranjeEkrana: NavHostController) {
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
        Column {
            Naslov(navigiranjeEkrana)
            ListaGumbova(buttons = buttonList, buttonTexts = buttonTextList)
            GumbZaKod()
        }
    }
}

@Composable
fun Naslov(navigiranjeEkrana: NavHostController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.padding(top = 40.dp, bottom = 8.dp, start = 20.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.povratak),
            contentDescription = "Left Icon",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(32.dp)
                .clickable {
                    navigiranjeEkrana.navigate("glavniEkran")
                }
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
fun ListaGumbova(buttons: List<String>, buttonTexts: List<String>) {
    require(buttons.size == buttonTexts.size)
    var listaKodova = LocalStorageManager.getList(LocalContext.current)
    // LocalStorageManager.addItemToList(LocalContext.current, "Kod2")

    LazyColumn(
        modifier = Modifier
            .padding(top = 90.dp, bottom = 16.dp),


        ) {
        items(listaKodova.size) { index ->
            OutlinedButton(
                onClick = { },
                border = BorderStroke(width = 1.dp, color = Color.White),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White,

                    ),
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = listaKodova[index].toString(),
                    fontSize = 18.sp
                )
            }
        }
    }
}


val buttonList = listOf("Button 1", "Button 2", "Button 3", "Button 4", "Button 5", "Button 6")
val buttonTextList = listOf(
    "Predmet - Lekcija - Autor", "Predmet - Lekcija - Autor",
    "Predmet - Lekcija - Autor", "Predmet - Lekcija - Autor",
    "Predmet - Lekcija - Autor", "Predmet - Lekcija - Autor"
)

@Composable
fun GumbZaKod() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = {

            },
            contentColor = Color.White,
            containerColor = colorResource(R.color.orange),
            modifier = Modifier
                .padding(32.dp)
                .size(56.dp)
        ) {
            Icon(
                Icons.Filled.Add, "Floating action button.",
            )
        }
    }
}

@Composable
fun UpisivanjeKoda(onDismissRequest: () -> Unit) {
    Dialog(
        onDismissRequest = {onDismissRequest()})
    {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Text(
                text = "Upisi kod",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                textAlign = TextAlign.Center,
            )

        }
    }
}