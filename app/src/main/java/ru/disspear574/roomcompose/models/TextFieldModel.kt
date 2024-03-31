package ru.disspear574.roomcompose.models

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldModel(value: MutableState<String>, label:String, icon: ImageVector) {
    TextField(
        value = value.value,
        onValueChange = { value.value = it },
        label = { Text(text = label) },
        singleLine = true,
        leadingIcon = { Icon(imageVector = icon, contentDescription = null) },
//        keyboardOptions = KeyboardOptions(
//            keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
//        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 50.dp)
            .shadow(elevation = 5.dp)
    )
}