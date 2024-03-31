package ru.disspear574.roomcompose.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.disspear574.roomcompose.presentation.AccountsScreen
import ru.disspear574.roomcompose.presentation.BoxesScreen
import ru.disspear574.roomcompose.presentation.LoginScreen
import ru.disspear574.roomcompose.presentation.SettingsScreen

@Composable
fun navHost(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = "home"
    ) {
        composable(
            "home",
            exitTransition = {
                fadeOut(tween(200))
            },
            content = {
                Home().Content(navController = navController)
            },
        )
        composable(
            "accounts_screen",
            enterTransition = {
                slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.End)
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Start)
            },
            content = {
                AccountsScreen().Content(navController = navController)
            },
        )
        composable(
            "settings_screen",
            enterTransition = {
                slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Up)
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Down)
            },
            content = {
                SettingsScreen().Content(navController = navController)
            },
        )
        composable(
            "boxes_screen",
            enterTransition = {
                slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Start)
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.End)
            },
            content = {
                BoxesScreen().Content(navController = navController)
            },
        )
        composable(
            "login_screen",
            enterTransition = {
                slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Start)
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.End)
            },
            content = {
                LoginScreen().Content(navController = navController)
            },
        )

    }
}