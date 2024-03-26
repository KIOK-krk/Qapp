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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController


@Composable
fun EkranKodova(
    navigiranjeEkrana: NavHostController,
    viewModel: EkranKodovaViewModel = viewModel()
) {


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
            ListaGumbova(navigiranjeEkrana, viewModel)
            UpisivanjeKoda(viewModel)

        }
    }
}

@Composable
fun Naslov(navigiranjeEkrana: NavHostController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.padding(top = 50.dp, bottom = 8.dp, start = 20.dp)
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
fun ListaGumbova(navigiranjeEkrana: NavHostController, viewModel: EkranKodovaViewModel) {
    viewModel.ucitajListuKodova(LocalContext.current)
    var listaKodova = viewModel.listaKodova.collectAsState()
    viewModel.ucitajListuKorisnika(LocalContext.current)
    var listaKorisnika = viewModel.listaKodova.collectAsState()

    LazyColumn(
        modifier = Modifier
            .padding(top = 70.dp, bottom = 16.dp)
    ) {
        items(listaKodova.value.size) { index ->
            OutlinedButton(
                onClick = {
                    navigiranjeEkrana.navigate("ekranPitanja/2/${listaKodova.value[index]}")
                },
                border = BorderStroke(width = 1.dp, color = Color.White),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White,

                    ),
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth()
            ) {
                Row {
                    Text(
                        text = listaKodova.value[index].toString(),
                        fontSize = 18.sp
                    )
                    Text(
                        text = listaKorisnika.value[index].toString(),
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpisivanjeKoda(viewModel: EkranKodovaViewModel) {
    var showDialog by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }
    val kontekst = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = {
                showDialog = true
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
        if (showDialog) {
            Dialog(onDismissRequest = { showDialog = false })
            {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(230.dp)
                        .width(300.dp)
                        .padding(16.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Unesi kod",
                            modifier = Modifier
                                .padding(top = 20.dp, start = 15.dp)
                        )

                        TextField(
                            value = text,
                            onValueChange = { text = it },
                            label = { Text("") },
                            modifier = Modifier
                                .padding(top = 25.dp, start = 10.dp, end = 10.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color.Transparent
                            )
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.End,
                        ) {
                            TextButton(
                                onClick = {LocalStorageManager.dodajKod(kontekst,text)
                                    viewModel.ucitajListuKodova(kontekst)},
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Text(
                                    text = "Potvrdi",
                                    fontWeight = FontWeight.ExtraBold,
                                    color = colorResource(id = R.color.green)
                                )
                            }
                            TextButton(
                                onClick = {showDialog = false},
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Text(
                                    text = "Otkaži",
                                    fontWeight = FontWeight.ExtraBold,
                                    color = colorResource(id = R.color.red)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}