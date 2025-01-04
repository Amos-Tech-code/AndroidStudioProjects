package com.example.crudfirestore.data

sealed class ScreenNavigation(val route: String) {

    data object MainScreen: ScreenNavigation("main_screen")

    data object AddDataScreen: ScreenNavigation("add_data_screen")

    data object GetDataScreen: ScreenNavigation("get_data_screen")
}