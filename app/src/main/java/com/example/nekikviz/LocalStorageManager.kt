package com.example.nekikviz

import android.content.Context
import android.content.SharedPreferences

object LocalStorageManager {
    private const val PREF_NAME = "MyAppPreferences"
    private const val PREF_KEY_LIST = "myList"

    fun saveList(context: Context, list: List<String>) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
            PREF_NAME, Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putStringSet(PREF_KEY_LIST, list.toSet())
        editor.apply()
    }

    fun getList(context: Context): List<String> {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
            PREF_NAME, Context.MODE_PRIVATE
        )
        val savedList = sharedPreferences.getStringSet(PREF_KEY_LIST, setOf()) ?: setOf()
        return savedList.toList()
    }

    fun addItemToList(context: Context, item: String) {
        val currentList = getList(context).toMutableList()
        currentList.add(item)
        saveList(context, currentList)
    }

    fun removeItemFromList(context: Context, item: String) {
        val currentList = getList(context).toMutableList()
        currentList.remove(item)
        saveList(context, currentList)
    }
}