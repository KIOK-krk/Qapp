package com.example.nekikviz

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.qgen.Predmet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PredmetiEkran(
    navigiranjeEkrana: NavHostController,
    viewModel: PredmetiViewModel = viewModel()
) {

    viewModel.dohvatiSveLekcije()
    val predmeti = viewModel.sviPredmet.collectAsState().value
    var razredprosiren by remember { mutableStateOf(false) }
    var razred = viewModel.trenutniRazred.collectAsState().value
    Column {
        Row {
            Text(
                text = "Predmeti",
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(all = 25.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "Razred:  ",
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
                            color = Color(0xff280a82),
                            fontSize = 28.sp,
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
                                fontSize = 48.sp,
                                fontWeight = FontWeight.Bold
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
                                    Text(text = "1",
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
                PredmetKartica(predmet, navigiranjeEkrana, razred, viewModel)
            }
        }
    }
}


@Composable
fun PredmetKartica(predmet: Predmet, navigiranjeEkrana:NavHostController, razred : String, viewModel: PredmetiViewModel) {
    // Pretpostavimo da viewModel već prati prosireno stanje za svaki predmet
    val lekcije = viewModel.sveLekcije.collectAsState().value
        .filter { it.PredmetID == predmet.idPredmeta && it.Razred.contains(razred) }

    Card(
        shape = RoundedCornerShape(8.dp),
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
                modifier = Modifier.padding(16.dp)
            )
            if (predmet.prosireno) {
                lekcije.forEach { lekcija ->
                    karticaLekcija(nazivLekcije = lekcija.Naziv, navigiranjeEkrana = navigiranjeEkrana,idLekcije = lekcija.idLekcije)
                }
            }
        }
    }
}

@Composable
fun karticaLekcija(
    nazivLekcije: String,
    navigiranjeEkrana: NavHostController,
    idLekcije: String
) {
    Text(
        text = nazivLekcije,
        modifier = Modifier
            .clickable {
                navigiranjeEkrana.navigate("ListaPitanja/${nazivLekcije}/${idLekcije}")
            }
            .padding(start = 32.dp, top = 16.dp, bottom = 16.dp)
            .fillMaxWidth()
    )
}