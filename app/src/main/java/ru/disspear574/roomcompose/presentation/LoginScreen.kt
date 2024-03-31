package ru.disspear574.roomcompose.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ru.disspear574.roomcompose.HomeViewModel
import ru.disspear574.roomcompose.LoginViewModel
import ru.disspear574.roomcompose.models.ButtonModel
import ru.disspear574.roomcompose.models.ColumnModel
import ru.disspear574.roomcompose.models.TextFieldModel

class LoginScreen {
    @Composable
    fun Content(navController: NavController) {
        Body()
    }
}
@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
private fun Body(loginViewModel: LoginViewModel = viewModel(factory = LoginViewModel.factory)) {
    ColumnModel {
        Text(text =
            "id: ${ loginViewModel.textText.value.toString() }"
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldModel(value = loginViewModel.emailText, label = "Email", icon = Icons.Outlined.Email)
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldModel(value = loginViewModel.passwordText, label = "Password", icon = Icons.Outlined.Lock)
        Spacer(modifier = Modifier.height(20.dp))
        ButtonModel(label = "Check Email And Password", color = MaterialTheme.colorScheme.primary) {
            loginViewModel.loginValidation()
        }
    }
}