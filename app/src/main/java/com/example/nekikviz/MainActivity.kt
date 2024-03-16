package com.example.nekikviz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nekikviz.ui.theme.NekikvizTheme


class MainActivity : ComponentActivity() {
    private lateinit var ttsCitacEkrana: CitacEkrana
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ttsCitacEkrana = CitacEkrana(this)
        enableEdgeToEdge()
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
    val tocni = "2"
    val netocni = "3"
    val bodovi = "5"

    NavHost(navController = navigiranjeEkrana, startDestination = "glavniEkran") {
        composable("ekranPitanja/{nacinrada}/{parametar}") { backStackEntry ->
            EkranPitanja(
                navigiranjeEkrana, ttsCitacEkrana,
                nacinrada = backStackEntry.arguments?.getString("nacinrada"),
                parametar = backStackEntry.arguments?.getString("parametar")
            )
        }
        composable("rezultati/{tocni}/{netocni}/{bodovi}") { backStackEntry ->
            EkranRezultata(navigiranjeEkrana, ttsCitacEkrana,
                tocni = backStackEntry.arguments?.getString("tocni"),
                netocni = backStackEntry.arguments?.getString("netocni"),
                bodovi = backStackEntry.arguments?.getString("bodovi")
            )
        }
        composable("glavniEkran") { GlavniEkran(navigiranjeEkrana, ttsCitacEkrana) }
        composable("ekranKodova") { EkranKodova(navigiranjeEkrana) }
        composable("predmetiEkran") { PredmetiEkran(navigiranjeEkrana, prosireno = false) }
    }
}