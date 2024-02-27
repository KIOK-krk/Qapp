package com.example.nekikviz

import kotlinx.serialization.Serializable

@Serializable
data class Pitanje(
    var tekstPitanja: String = "",
    var odgovori: List<String> = emptyList(),
    var tocanOdgovor: Int = 0,
    var zanimljivost: String = "",
    var autor: String = "",
    var idPitanja: String = "",
    var idLekcije: String = ""
)