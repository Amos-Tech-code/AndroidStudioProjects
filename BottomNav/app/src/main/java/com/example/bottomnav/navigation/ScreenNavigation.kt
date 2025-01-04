package com.example.bottomnav.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class ScreenNavigation(val route: String, val title: String) {

    @Serializable
    data object HomeScreen : ScreenNavigation("home_screen", "Affirmations")

    @Serializable
    data object PostScreen : ScreenNavigation("post_screen", "Posts")

    @Serializable
    data object NotificationScreen : ScreenNavigation("notification_screen", "Notification")

    @Serializable
    data object ProfileScreen : ScreenNavigation("profile_screen", "Profile")
}


