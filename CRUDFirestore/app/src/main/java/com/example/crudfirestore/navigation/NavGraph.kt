package com.example.crudfirestore.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.crudfirestore.data.ScreenNavigation
import com.example.crudfirestore.model.SharedViewModel
import com.example.crudfirestore.screen.AddDataScreen
import com.example.crudfirestore.screen.GetDataScreen
import com.example.crudfirestore.screen.MainScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {

    NavHost(
        navController = navController,
        startDestination = ScreenNavigation.MainScreen.route
    ) {
        //Main Screen
        composable(ScreenNavigation.MainScreen.route) {
            MainScreen(
                navController = navController,
                sharedViewModel = sharedViewModel
            )
        }
        //Add Data Screen
        composable(ScreenNavigation.AddDataScreen.route) {
            AddDataScreen(
                navController = navController,
                sharedViewModel = sharedViewModel
            )
        }
        //Get Data Screen
        composable(ScreenNavigation.GetDataScreen.route) {
            GetDataScreen(
                navController = navController,
                sharedViewModel = sharedViewModel
            )
        }


    }
}