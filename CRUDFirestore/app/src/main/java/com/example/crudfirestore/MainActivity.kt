package com.example.crudfirestore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.crudfirestore.model.SharedViewModel
import com.example.crudfirestore.navigation.NavGraph
import com.example.crudfirestore.ui.theme.CRUDFirestoreTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val sharedViewModel by viewModels<SharedViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CRUDFirestoreTheme(darkTheme = false) {
                Surface(modifier = Modifier.fillMaxSize()) {

                    navController = rememberNavController()

                    NavGraph(
                        navController = navController,
                        sharedViewModel = sharedViewModel
                    )

                }
            }
        }
    }
}
