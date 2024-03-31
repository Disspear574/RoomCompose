package ru.disspear574.roomcompose.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import ru.disspear574.roomcompose.models.ColumnModel

class SettingsScreen {
    @Composable
    fun Content(navController: NavController, ) {
        Body(navController)
    }
}
@Composable
private fun Body(navController: NavController) {
    ColumnModel{

    }
}