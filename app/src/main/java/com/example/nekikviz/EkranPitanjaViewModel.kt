package com.example.nekikviz

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
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

    fun ucitajPitanjaZabava(context: Context) = viewModelScope.launch {
        try {
            val jsonStr = withContext(Dispatchers.IO) {
                context.resources.openRawResource(R.raw.pitanja2000).bufferedReader()
                    .use { it.readText() }
            }
            val json = Json { ignoreUnknownKeys = true }
            _pitanja.value = json.decodeFromString(jsonStr)
            Log.d("EkranPitanjaViewModel", "Broj ucitanih pitanja: ${_pitanja.value.size}")
            _ucitavanje.value = false
        } catch (e: Exception) {
            Log.e("EkranPitanjaViewModel", "Greska kod ucitavanja", e)
        }
    }
}
