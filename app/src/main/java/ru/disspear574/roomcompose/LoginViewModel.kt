package ru.disspear574.roomcompose

import android.accounts.AuthenticatorException
import android.media.AudioRecord
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.launch
import ru.disspear574.roomcompose.data.MainBD
import ru.disspear574.roomcompose.data.UserEntity

class LoginViewModel(val database: MainBD): ViewModel() {

    val usersList = database.dao.getAllUsers()
    var textText = mutableIntStateOf(0)
    var emailText = mutableStateOf("")
    var passwordText = mutableStateOf("")
    var texttexttext = mutableStateOf("")
//    fun authvalid(): Throwable {
//        texttexttext.value = "Not Found Email"
//    }
     fun loginValidation() = viewModelScope.launch{
        val answer = database.dao.findByEmail(emailText.value) ?: throw AuthenticatorException()
            if (answer.password != passwordText.value.toInt()) throw AuthenticatorException()
         textText.intValue = answer.id
    }
    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val database = (checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]) as App).database
                return LoginViewModel(database = database) as T
            }
        }
    }
}