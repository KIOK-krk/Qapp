package com.example.nekikviz

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qgen.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json


class EkranPitanjaViewModel : ViewModel() {
    private val _ucitavanje = MutableStateFlow(true)
    val ucitavanje: StateFlow<Boolean> = _ucitavanje

    private val _pitanja = MutableStateFlow<List<Pitanje>>(emptyList())
    val svaPitanja: StateFlow<List<Pitanje>> = _pitanja

    private val _bodovi = MutableStateFlow(0L)
    val bodovi : StateFlow<Long> = _bodovi

    private val _vrijeme = MutableStateFlow(20000L)
    val vrijeme : StateFlow<Long> = _vrijeme

    private val _prikaziZanimljivost = MutableStateFlow(false)
    val prikaziZanimljivost : StateFlow<Boolean> = _prikaziZanimljivost

    private val _trenutnoPitanjeIndex = MutableStateFlow(0)
    val trenutnoPitanjeIndex : StateFlow<Int> = _trenutnoPitanjeIndex

    private val _brojTocnihOdgovora = MutableStateFlow(0)
    val brojTocnihOdgovora : StateFlow<Int> = _brojTocnihOdgovora

    private val _brojNetocnihOdgovora = MutableStateFlow(0)
    val brojNetocnihOdgovora : StateFlow<Int> = _brojNetocnihOdgovora

    private val _stisnutGumb = MutableStateFlow(false)
    val stisnutGumb : StateFlow<Boolean> = _stisnutGumb

    init {

    }

    fun ucitajPitanjaZabava(context: Context) = viewModelScope.launch {
        _pitanja.value = emptyList()
        try {
            val jsonStr = withContext(Dispatchers.IO) {
                context.resources.openRawResource(R.raw.pitanja2000).bufferedReader()
                    .use { it.readText() }
            }
            val json = Json { ignoreUnknownKeys = true }
            _pitanja.value = json.decodeFromString(jsonStr)
            _ucitavanje.value = false
        } catch (e: Exception) {
            Log.e("EkranPitanjaViewModel", "Greska kod ucitavanja", e)
        }
        // uzimamo 10 nasumicnih pitanja
        _pitanja.value = _pitanja.value.shuffled().take(10)
    }

    fun odgovoriPitanje(brojOdgovora:Int){
        val trenutnoPitanje = _pitanja.value[_trenutnoPitanjeIndex.value]
        if(trenutnoPitanje.tocanOdgovor == brojOdgovora){
            // dodavanje bodova za tocan odgovor
            _bodovi.value = _bodovi.value + 1 + _vrijeme.value/1000
            _brojTocnihOdgovora.value = _brojTocnihOdgovora.value + 1
        } else {
            _brojNetocnihOdgovora.value = _brojNetocnihOdgovora.value + 1
        }
        _stisnutGumb.value = true
        tajmerJob?.cancel()
        // if zanimljivost nije prazan string
        // _prikaziZanimljivost.value = true
    }
    private var tajmerJob: Job? = null

    fun startajVrijeme() {
        tajmerJob?.cancel()
        tajmerJob = viewModelScope.launch {
            _vrijeme.value = 20000L
            while (_vrijeme.value > 0) {
                delay(1000)
                _vrijeme.value -= 1000
            }
            _stisnutGumb.value = true
        }

    }

    fun sljedecePitanje() {
        _trenutnoPitanjeIndex.value = (_trenutnoPitanjeIndex.value + 1) % _pitanja.value.size
        _stisnutGumb.value = false
        startajVrijeme()
    }

    fun ucitajPitanjaSkola(idLekcije: String?) = viewModelScope.launch {
        _pitanja.value = emptyList()
        DataRepository.dohvatiPitanja().collect { pitanjaList ->
            _pitanja.value = pitanjaList.filter { it.idLekcije == idLekcije }
            // za skolu uzimamo 3 pitanja
            _pitanja.value = _pitanja.value.shuffled().take(3)
            _ucitavanje.value = false
            if(_pitanja.value.isEmpty()){
                val praznoPitanje : Pitanje = Pitanje()
                praznoPitanje.idPitanja = "-1"
                praznoPitanje.tekstPitanja = "Nema pitanja za ovu lekciju"
                praznoPitanje.autor = "Nepoznato"
                praznoPitanje.idLekcije = "-1"
                praznoPitanje.odgovori = listOf("", "", "")
                praznoPitanje.tocanOdgovor = 1
                praznoPitanje.zanimljivost = "Nema zanimljivosti za ovu lekciju"
                _stisnutGumb.value = true
                _vrijeme.value=0
                _pitanja.value = listOf(praznoPitanje)
            }
        }
    }

    fun ucitajPitanjaOdUcitelja(kod: String?) = viewModelScope.launch {
        _pitanja.value = emptyList()
        DataRepository.dohvatiPitanja().collect { pitanjaList ->
            _pitanja.value = pitanjaList.filter { it.autor == kod }
            // za skolu ali od ucitelja uzimamo 3 pitanja
            _pitanja.value = _pitanja.value.shuffled().take(3)
            _ucitavanje.value = false
            if(_pitanja.value.isEmpty()){
                val praznoPitanje : Pitanje = Pitanje()
                praznoPitanje.idPitanja = "-1"
                praznoPitanje.tekstPitanja = "Nema pitanja za ovaj kod. Potrebno je najmanje 5 pitanja"
                praznoPitanje.autor = "Nepoznato"
                praznoPitanje.idLekcije = "-1"
                praznoPitanje.odgovori = listOf("", "", "")
                praznoPitanje.tocanOdgovor = 1
                praznoPitanje.zanimljivost = "Nema zanimljivosti za ovu lekciju"
                _stisnutGumb.value = true
                _vrijeme.value=0
                _pitanja.value = listOf(praznoPitanje)
            }
        }
    }
}
