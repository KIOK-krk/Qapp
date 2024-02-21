package com.example.nekikviz

data class Pitanje(
    val tekstPitanja: String = "",
    val odgovori: List<String> = emptyList(),
    val tocanOdgovor: Int = 0,
    val zanimljivost: String = "",
    val autor: String = "",
    var idPitanja: String = "",
    val idLekcije: String = ""
)