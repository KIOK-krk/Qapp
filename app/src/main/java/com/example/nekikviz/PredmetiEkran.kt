package com.example.nekikviz

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.nekikviz.R
import com.example.qgen.Predmet


@Composable
fun Pozadina() {
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
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PredmetiEkran(
    navigiranjeEkrana: NavHostController,
    viewModel: PredmetiViewModel = viewModel(),
    prosireno: Boolean

) {
    Pozadina()
    viewModel.dohvatiSveLekcije()
    val predmeti = viewModel.sviPredmet.collectAsState().value
    var razredprosiren by remember { mutableStateOf(false) }
    var razred = viewModel.trenutniRazred.collectAsState().value
    Column {
        Row(
            modifier = Modifier
                .padding(top = 40.dp, start = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.povratak),
                contentDescription = "Left Icon",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(top = 21.dp)
                    .size(30.dp)
                    .clickable {
                        navigiranjeEkrana.navigate("glavniEkran")
                    }


            )
            Text(
                text = "Predmeti",
                fontSize = 26.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 20.dp, start = 20.dp)
            )
            Spacer(modifier = Modifier.weight(1f))

            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "Razred:  ",
                    color = Color.White,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(start = 12.dp, top = 4.dp)
                )
                ExposedDropdownMenuBox(
                    expanded = razredprosiren,
                    onExpandedChange = { newValue ->
                        razredprosiren = newValue
                    }
                ) {
                    OutlinedTextField(
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Transparent,
                            unfocusedBorderColor = Transparent
                        ),
                        value = razred,
                        textStyle = TextStyle(
                            fontSize = 28.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.End
                        ),
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = razredprosiren)
                        },
                        placeholder = {
                            Text(
                                text = razred,
                                color = Color(0xFF634FDC),
                                fontSize = 48.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        },
                        modifier = Modifier
                            .menuAnchor()
                            .width(100.dp)
                            .height(60.dp)
                    )
                    ExposedDropdownMenu(
                        expanded = razredprosiren,
                        onDismissRequest = {
                            razredprosiren = false
                        }
                    ) {
                        DropdownMenuItem(
                            text = {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = "1",
                                        color = Color(0xFF7FA3FF),
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            },
                            onClick = {
                                razred = "1"
                                viewModel.postaviRazred("1")
                                razredprosiren = false
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        DropdownMenuItem(
                            text = {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(text = "2",
                                        color = Color(0xFF7FA3FF),
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            },
                            onClick = {
                                razred = "2"
                                viewModel.postaviRazred("2")
                                razredprosiren = false
                            }
                        )
                        DropdownMenuItem(
                            text = {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(text = "3",
                                        color = Color(0xFF7FA3FF),
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            },
                            onClick = {
                                razred = "3"
                                viewModel.postaviRazred("3")
                                razredprosiren = false
                            }
                        )
                        DropdownMenuItem(
                            text = {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(text = "4",
                                        color = Color(0xFF7FA3FF),
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            },
                            onClick = {
                                razred = "4"
                                viewModel.postaviRazred("4")
                                razredprosiren = false
                            }
                        )
                        DropdownMenuItem(
                            text = {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(text = "5",
                                        color = Color(0xFF7FA3FF),
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            },
                            onClick = {
                                razred = "5"
                                viewModel.postaviRazred("5")
                                razredprosiren = false
                            }
                        )
                        DropdownMenuItem(
                            text = {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(text = "6",
                                        color = Color(0xFF7FA3FF),
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            },
                            onClick = {
                                razred = "6"
                                viewModel.postaviRazred("6")
                                razredprosiren = false
                            }
                        )
                        DropdownMenuItem(
                            text = {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(text = "7",
                                        color = Color(0xFF7FA3FF),
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            },
                            onClick = {
                                razred = "7"
                                viewModel.postaviRazred("7")
                                razredprosiren = false
                            }
                        )
                        DropdownMenuItem(
                            text = {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(text = "8",
                                        color = Color(0xFF7FA3FF),
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            },
                            onClick = {
                                razred = "8"
                                viewModel.postaviRazred("8")
                                razredprosiren = false
                            }
                        )
                    }
                }
            }
        }

        LazyColumn() {
            items(predmeti) { predmet ->
                PredmetKartica(predmet, navigiranjeEkrana, razred, prosireno, viewModel)
            }
        }
    }
}


@Composable
fun PredmetKartica(
    predmet: Predmet,
    navigiranjeEkrana: NavHostController,
    razred: String,
    prosireno: Boolean,
    viewModel: PredmetiViewModel
) {
    // Pretpostavimo da viewModel već prati prosireno stanje za svaki predmet
    val lekcije = viewModel.sveLekcije.collectAsState().value
        .filter { it.PredmetID == predmet.idPredmeta && it.Razred.contains(razred) }
        .sortedBy { it.Naziv }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp)
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color.White),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF7375d9)
            ),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    viewModel.togglePredmetProsiren(predmet.idPredmeta)
                }) {
                Text(
                    text = predmet.nazivPredmeta,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(16.dp)
                )
                if (predmet.prosireno) {
                    lekcije.forEach { lekcija ->
                        karticaLekcija(
                            nazivLekcije = lekcija.Naziv,
                            navigiranjeEkrana = navigiranjeEkrana,
                            idLekcije = lekcija.idLekcije
                        )
                    }
                }
            }
        }
        Icon(
            imageVector = Icons.Default.KeyboardArrowUp,
            contentDescription = null
        )
    }
}

@Composable
fun karticaLekcija(
    nazivLekcije: String,
    navigiranjeEkrana: NavHostController,
    idLekcije: String
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.White),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF8587FF)
        ),
        modifier = Modifier
            .padding(bottom = 8.dp, start = 8.dp, end = 8.dp)
    ) {
        Text(
            text = nazivLekcije,
            color = Color.White,
            modifier = Modifier
                .clickable {
                    //navigiranjeEkrana.navigate("ekranPitanja/1/${idLekcije}")
                    navigiranjeEkrana.navigate("ekranFlashcards/${idLekcije}")
                }
                .padding(start = 32.dp, top = 16.dp, bottom = 16.dp)
                .fillMaxWidth()
        )
    }
}