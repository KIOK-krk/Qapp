package com.example.nekikviz

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.*

class CitacEkrana(context: Context) {
    // tts = Text To Speech
    var tts: TextToSpeech? = null

    init {
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val result = tts?.setLanguage(Locale.forLanguageTag("hr-HR"))
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("CitacEkrana", "Hrvatski nije podrzan")
                } else {
                    tts?.setSpeechRate(1.5f) // 1.0 = 100%, 1.5 = 150%
                }
            } else {
                Log.e("CitacEkrana", "Ajoj, nesto je poslo po zlu!")
            }
        }
    }

    fun citaj(tekst: String) {
        tts?.speak(tekst, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    fun zaustavi() {
        tts?.stop()
    }

    fun shutDown() {
        tts?.stop()
        tts?.shutdown()
    }
}