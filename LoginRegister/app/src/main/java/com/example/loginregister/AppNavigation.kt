package com.example.loginregister

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginregister.pages.HomePage
import com.example.loginregister.pages.LoginPage
import com.example.loginregister.pages.SignUpPage


@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login") {
            LoginPage(
                modifier,
                navController,
                authViewModel
            )
        }

        composable("signup") {
            SignUpPage(
                modifier,
                navController,
                authViewModel
            )
        }

        composable("homepage") {
            HomePage(
                modifier,
                navController,
                authViewModel
            )
        }
    })

}