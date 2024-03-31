package ru.disspear574.roomcompose.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.awaitAll
import ru.disspear574.roomcompose.HomeViewModel
import ru.disspear574.roomcompose.data.MainBD
import ru.disspear574.roomcompose.data.UserEntity
import ru.disspear574.roomcompose.models.ColumnModel
import ru.disspear574.roomcompose.models.ItemCardModel

class AccountsScreen {
    @Composable
    fun Content(navController: NavController) {
        Body(navController)
    }
}

@Composable
private fun Body(
    navController: NavController,
    homeViewModel: HomeViewModel = viewModel(factory = HomeViewModel.factory)
) {
    val usersList = homeViewModel.usersList.collectAsState(initial = emptyList())
    var passwordVisibility: Boolean by remember { mutableStateOf(false) }
    ColumnModel {
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(horizontal = 15.dp)
        ) {
            LazyColumn(
                Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 5.dp, horizontal = 5.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                items(usersList.value) { it ->
                    ItemCardModel(it = it) { userEntity ->
                        homeViewModel.userEntity = userEntity
                        homeViewModel.emailText.value = userEntity.email
                        homeViewModel.emailText.value = userEntity.username
                        homeViewModel.passwordText.value = userEntity.password.toString()
                        homeViewModel.createAtText.value = userEntity.createdAt.toString()
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = homeViewModel.emailText.value,
            onValueChange = { homeViewModel.emailText.value = it },
            label = { Text("Email") },
            singleLine = true,
            leadingIcon = { Icon(imageVector = Icons.Outlined.Email, contentDescription = null) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 50.dp)
                .shadow(elevation = 5.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = homeViewModel.usernameText.value,
            onValueChange = { homeViewModel.usernameText.value = it },
            label = { Text("Username") },
            singleLine = true,
            leadingIcon = { Icon(imageVector = Icons.Outlined.Person, contentDescription = null) },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 50.dp)
                .shadow(elevation = 5.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = homeViewModel.passwordText.value,
            onValueChange = { homeViewModel.passwordText.value = it },
            label = { Text("Password") },
            singleLine = true,
            leadingIcon = { Icon(imageVector = Icons.Outlined.Lock, contentDescription = null) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password, imeAction = ImeAction.Next
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = {

                    passwordVisibility = !passwordVisibility
                }) {
                    AnimatedContent(targetState = passwordVisibility, label = "") {
                        Icon(
                            imageVector = if (!it) {
                                Icons.Outlined.Edit
                            } else {
                                Icons.Outlined.Check
                            }, ""
                        )
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 50.dp)
                .shadow(elevation = 5.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = homeViewModel.createAtText.value,
            onValueChange = { homeViewModel.createAtText.value = it },
            label = { Text("Create_At") },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.DateRange, contentDescription = null
                )
            },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number, imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 50.dp)
                .shadow(elevation = 5.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                homeViewModel.insertUser()
            },
            elevation = ButtonDefaults.buttonElevation(10.dp),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 50.dp)
        ) {
            Text(text = "save table", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                homeViewModel.deleteUsers()
            },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary),
            elevation = ButtonDefaults.buttonElevation(10.dp),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 50.dp)
        ) {
            Text(text = "clear table", fontSize = 20.sp)
        }
    }
}
