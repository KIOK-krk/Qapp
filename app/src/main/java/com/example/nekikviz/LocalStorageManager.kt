package com.example.nekikviz

import android.content.Context
import android.content.SharedPreferences

object LocalStorageManager {
    private const val PREF_NAME = "spremanje podataka"
    private const val PREF_KEY_LIST = "lista kodova"

    fun snimiListu(context: Context, list: List<String>) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
            PREF_NAME, Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putStringSet(PREF_KEY_LIST, list.toSet())
        editor.apply()
    }

    fun dohvatiListu(context: Context): List<String> {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
            PREF_NAME, Context.MODE_PRIVATE
        )
        val savedList = sharedPreferences.getStringSet(PREF_KEY_LIST, setOf()) ?: setOf()
        return savedList.toList()
    }

    fun dodajKod(context: Context, item: String) {
        val currentList = dohvatiListu(context).toMutableList()
        currentList.add(item)
        snimiListu(context, currentList)

    }

    fun izbrisiKod(context: Context, item: String) {
        val currentList = dohvatiListu(context).toMutableList()
        currentList.remove(item)
        snimiListu(context, currentList)
    }
}