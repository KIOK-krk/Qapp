package com.example.nekikviz

import android.content.Context
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EkranKodovaViewModel : ViewModel(){
    private val _listaKodova = MutableStateFlow<List<String>>(emptyList())
    val listaKodova: StateFlow<List<String>> = _listaKodova

    fun ucitajListuKodova(context: Context){
        CoroutineScope(Dispatchers.Default).launch {
            _listaKodova.emit(LocalStorageManager.dohvatiListu(context))
        }
    }
}

