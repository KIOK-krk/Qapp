package com.example.nekikviz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.NavHost
import com.example.nekikviz.ui.theme.NekikvizTheme
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.qgen.PredmetiEkran

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
                    Pocetak(ttsCitacEkrana)
                }
            }
        }
    }
}

@Composable
fun Pocetak(ttsCitacEkrana: CitacEkrana) {

    val navigiranjeEkrana = rememberNavController()

    NavHost(navController = navigiranjeEkrana, startDestination = "glavni ekran") {
        composable("pitanjaIodgovori") { pitanjaIodgovori(navigiranjeEkrana, ttsCitacEkrana) }
        composable("zanimljivost") { Zanimljivost() }
        composable("rezultati") { rezultati(ttsCitacEkrana) }
        composable("PredmetiEkran") { PredmetiEkran(navigiranjeEkrana, prosireno = false) }
        composable("glavni ekran") { glavniEkran(navigiranjeEkrana) }
    }
}


