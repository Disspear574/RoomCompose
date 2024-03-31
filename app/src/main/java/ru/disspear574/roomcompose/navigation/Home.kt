package ru.disspear574.roomcompose.navigation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.disspear574.roomcompose.models.ButtonModel
import ru.disspear574.roomcompose.models.ColumnModel

class Home() {
    @Composable
    fun Content(navController: NavHostController) {
        Body(navController)
    }
}
@Composable
private fun Body(navController: NavHostController) {
    ColumnModel {
        ButtonModel(label = "To Accounts Screen", color = MaterialTheme.colorScheme.primary) {
            navController.navigate("accounts_screen")
        }
        Spacer(modifier = Modifier.height(20.dp))
        ButtonModel(label = "To Settings Screen", color = MaterialTheme.colorScheme.secondary) {
            navController.navigate("settings_screen")
        }
        Spacer(modifier = Modifier.height(20.dp))
        ButtonModel(label = "To Boxes Screen", color = MaterialTheme.colorScheme.tertiary) {
            navController.navigate("boxes_screen")
        }
        Spacer(modifier = Modifier.height(20.dp))
        ButtonModel(label = "To Login Screen", color = MaterialTheme.colorScheme.tertiary) {
            navController.navigate("login_screen")
        }
    }
}