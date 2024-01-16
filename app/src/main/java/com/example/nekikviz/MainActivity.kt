package com.example.nekikviz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.nekikviz.ui.theme.NekikvizTheme

class MainActivity : ComponentActivity() {
    private lateinit var ttsCitacEkrana: CitacEkrana
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ttsCitacEkrana = CitacEkrana(this)
        setContent {
            NekikvizTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(R.color.lightblue)
                ) {
                    rezultati(ttsCitacEkrana)
                }
            }
        }
    }
}


