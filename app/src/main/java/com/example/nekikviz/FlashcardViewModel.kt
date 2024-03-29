package com.example.nekikviz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qgen.DataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FlashcardViewModel : ViewModel() {
private val _ucitavanje = MutableStateFlow<Boolean>(true)
val ucitavanje: StateFlow<Boolean> = _ucitavanje

    private val _pitanja = MutableStateFlow<List<Pitanje>>(emptyList())
    val svaPitanja: StateFlow<List<Pitanje>> = _pitanja


    fun ucitajPitanjaSkola(idLekcije: String?) = viewModelScope.launch {
        _pitanja.value = emptyList()
        DataRepository.dohvatiPitanja().collect { pitanjaList ->
            _pitanja.value = pitanjaList.filter { it.idLekcije == idLekcije }
            // za skolu uzimamo 3 pitanja
            _pitanja.value = _pitanja.value.shuffled().take(3)
            _ucitavanje.value = false
            if (_pitanja.value.isEmpty()) {
                val praznoPitanje: Pitanje = Pitanje()
                praznoPitanje.idPitanja = "-1"
                praznoPitanje.tekstPitanja = "Nema pitanja za ovu lekciju"
                praznoPitanje.autor = "Nepoznato"
                praznoPitanje.idLekcije = "-1"
                praznoPitanje.odgovori = listOf(
                    "Treba najmanje 5 pitanja?",
                    "Imate li internet vezu?",
                    "Pokušajte drugu lekciju"
                )
                praznoPitanje.tocanOdgovor = 1
                praznoPitanje.zanimljivost = "Nema zanimljivosti za ovu lekciju"
                _pitanja.value = listOf(praznoPitanje)
            }
        }
    }
}

