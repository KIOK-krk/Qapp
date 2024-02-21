package com.example.qgen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nekikviz.Lekcija
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PredmetiViewModel : ViewModel(){
    private val predmeti = MutableStateFlow<List<Predmet>>(emptyList())
    val sviPredmet: StateFlow<List<Predmet>> = predmeti

    private val lekcije = MutableStateFlow<List<Lekcija>>(emptyList())
    val sveLekcije: MutableStateFlow<List<Lekcija>> = lekcije

    private val razred = MutableStateFlow<String>("5")
    val trenutniRazred: StateFlow<String> = razred

    init{
        viewModelScope.launch {
            postaviRazred(razred.value)
        }
    }

    fun postaviRazred(noviRazred: String) {
        razred.value = noviRazred
        viewModelScope.launch {
            DataRepository.dohvatiPredmete().collect { predmetiList ->
                predmeti.value = predmetiList.filter { it.razred.contains(noviRazred) }
            }
            DataRepository.dohvatiLekcije().collect { lekcijeList ->
                lekcije.value = lekcijeList.filter { it.Razred.contains(noviRazred) }
            }
        }
    }

    fun dohvatiSveLekcije(){
        viewModelScope.launch {
            DataRepository.dohvatiLekcije().collect { lekcijeList ->
                lekcije.value = lekcijeList //.filter { it.predmetID == predmetID && it.razred == razred }
            }
            Log.d("Lekcije", lekcije.value.toString())
        }
    }
    fun togglePredmetProsiren(predmetID: String) {
        // Kreiranje privremene liste za ažurirane predmete
        val sviNoviPredmeti = mutableListOf<Predmet>()

        // Iteracija kroz listu trenutnih predmeta
        for (predmet in predmeti.value) {
            if (predmet.idPredmeta == predmetID) {
                // Ako je pronađen predmet s odgovarajućim ID-om, invertiramo njegovo prosireno stanje
                sviNoviPredmeti.add(predmet.copy(prosireno = !predmet.prosireno))
            } else {
                // Ako predmet nema odgovarajući ID, samo ga dodamo u listu
                sviNoviPredmeti.add(predmet)
            }
        }
        // Ažuriranje stanja predmeta s novom listom
        predmeti.value = sviNoviPredmeti
    }
}