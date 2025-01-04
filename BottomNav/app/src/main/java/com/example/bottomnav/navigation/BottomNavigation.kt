package com.example.bottomnav.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bottomnav.data.bottomNavItems
import com.example.bottomnav.ui.screens.HomeScreen
import com.example.bottomnav.ui.screens.MyProfileScreen
import com.example.bottomnav.ui.screens.NotificationScreen
import com.example.bottomnav.ui.screens.PostScreen
import com.example.bottomnav.ui.screens.messages
import com.example.bottomnav.ui.theme.BottomNavTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyScreen() {
    val scrollBehaviour = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        },

        topBar = {
            TopAppBar(
                navController = navController,
                scrollBehavior = scrollBehaviour
            )
        }
    ) {
        val padding = it
        //NavHost
        NavHost(
            navController = navController,
            startDestination = ScreenNavigation.HomeScreen.route,
            modifier = Modifier
                .padding(padding)
                .nestedScroll(scrollBehaviour.nestedScrollConnection),
            enterTransition = { slideInHorizontally { it } },
            exitTransition = { slideOutHorizontally { -it } },
            popEnterTransition = { slideInHorizontally { -it } },
            popExitTransition = { slideOutHorizontally { it } }

        ) {
            composable(ScreenNavigation.HomeScreen.route) {
                HomeScreen()
            }
            composable(ScreenNavigation.PostScreen.route) {
                PostScreen()
            }
            composable(ScreenNavigation.NotificationScreen.route) {
                NotificationScreen(message = messages)
            }
            composable(ScreenNavigation.ProfileScreen.route) {
                MyProfileScreen()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    navController: NavController,
    scrollBehavior: TopAppBarScrollBehavior
) {

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    val screenTitle = when (currentRoute) {
        ScreenNavigation.HomeScreen.route -> ScreenNavigation.HomeScreen.title
        ScreenNavigation.PostScreen.route -> ScreenNavigation.PostScreen.title
        ScreenNavigation.NotificationScreen.route -> ScreenNavigation.NotificationScreen.title
        ScreenNavigation.ProfileScreen.route -> ScreenNavigation.ProfileScreen.title
        else -> "App Name"
    }

    val canNavigateBack = navController.previousBackStackEntry != null

    //Dropdown declaration variable
    var dropDownExpanded by remember {
        mutableStateOf(false)
    }

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(0.6f)

        ),
        navigationIcon = {
            if (canNavigateBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(start = 8.dp)
                        .clickable {
                            navController.popBackStack()
                        }
                )
            }
        },
        title = {
            Text(
                text = screenTitle
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .clickable { dropDownExpanded = !dropDownExpanded }
            )
            //DropDown Menu
            DropdownMenu(
                expanded = dropDownExpanded,
                onDismissRequest = { dropDownExpanded = false },
                modifier = Modifier
                    .width(200.dp)
                    .height(300.dp)
                    .padding(8.dp)
            ) {
                DropdownMenuItem(
                    text = { Text(text = "New Group") },
                    onClick = { /*TODO*/ }
                )
                DropdownMenuItem(
                    text = { Text(text = "New Broadcast") },
                    onClick = { /*TODO*/ }
                )
                DropdownMenuItem(
                    text = { Text(text = "Linked Devices") },
                    onClick = { /*TODO*/ }
                )
                DropdownMenuItem(
                    text = { Text(text = "Settings") },
                    onClick = { /*TODO*/ }
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    var selected by remember {
        mutableIntStateOf(0)
    }
    // Get the current route from the NavController
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    // Update selected index based on the current route
    selected = when (currentRoute) {
        ScreenNavigation.HomeScreen.route -> 0
        ScreenNavigation.PostScreen.route -> 1
        ScreenNavigation.NotificationScreen.route -> 2
        ScreenNavigation.ProfileScreen.route -> 3
        else -> selected
    }

    NavigationBar {
        bottomNavItems.forEachIndexed{ index, bottomNavItem ->
            NavigationBarItem(
                selected = index == selected,
                onClick = {
                    selected = index
                    /*TODO*/
                    when (index) {
                        0 -> navController.navigate(ScreenNavigation.HomeScreen.route){
                            popUpTo(ScreenNavigation.HomeScreen.route) { inclusive = true }
                        }
                        1 -> navController.navigate(ScreenNavigation.PostScreen.route)
                        2 -> navController.navigate(ScreenNavigation.NotificationScreen.route)
                        3 -> navController.navigate(ScreenNavigation.ProfileScreen.route)
                    }
                },
                icon = {
                    BadgedBox(
                        badge = {
                            if (bottomNavItem.badges != 0 ) {
                                Badge{
                                    Text(
                                        text = bottomNavItem.badges.toString()
                                    )
                                }
                            } else if (bottomNavItem.hasNews) {
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            imageVector =
                            if (index == selected) {
                                bottomNavItem.selectedIcon
                            } else {
                                bottomNavItem.unSelectedIcon
                            },
                            contentDescription = bottomNavItem.title
                        )
                    }
                },
                label = {
                    Text(
                        text = bottomNavItem.title
                    )
                }
            )
        }
    }
}



@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BottomNavTheme {
        MyScreen()
    }
}