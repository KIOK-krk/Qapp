package com.example.nekikviz

data class PitanjeFirebase(
    val tekstPitanja: String = "",
    val odgovori: List<String> = emptyList(),
    val tocanOdgovor: Int = 0,
    val zanimljivost: String = "",
    val autor: String = "",
    var idPitanja: String = "",
    val idLekcije: String = ""
)