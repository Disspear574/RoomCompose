package ru.disspear574.roomcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.launch
import ru.disspear574.roomcompose.data.MainBD
import ru.disspear574.roomcompose.data.UserEntity

class HomeViewModel(val database: MainBD): ViewModel() {
    val usersList = database.dao.getAllUsers()
    var emailText = mutableStateOf("")
    var usernameText = mutableStateOf("")
    var passwordText = mutableStateOf("")
    var createAtText = mutableStateOf("")
    var userEntity: UserEntity? = null
    fun insertUser() = viewModelScope.launch {
        val nameUser = userEntity?.copy(
            email = emailText.value,
            username = usernameText.value,
            password = passwordText.value.toInt(),
            createdAt = createAtText.value.toInt()
        )
            ?: UserEntity(
                email = emailText.value,
                username = usernameText.value,
                password = passwordText.value.toInt(),
                createdAt = createAtText.value.toInt()
            )
        database.dao.insertUser(nameUser)
        userEntity = null
        emailText.value = ""
        usernameText.value = ""
        passwordText.value = ""
        createAtText.value = ""
    }
    fun deleteUsers() = viewModelScope.launch {
        database.dao.deleteAllUsers()
    }
    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras): T {
                val database = (checkNotNull(extras[APPLICATION_KEY]) as App).database
                return HomeViewModel(database = database) as T
            }
        }
    }
}