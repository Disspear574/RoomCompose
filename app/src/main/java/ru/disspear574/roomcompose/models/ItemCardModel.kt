package ru.disspear574.roomcompose.models

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.disspear574.roomcompose.data.UserEntity

@Composable
fun ItemCardModel(it: UserEntity, onClick: (UserEntity) -> Unit) {
    Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.outline),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick(it)
            }) {
        Text(
            text = "id:${it.id}, username:${it.username}, password:${it.password} ,createAt:${it.createdAt}",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.outlineVariant,
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
    Spacer(modifier = Modifier.height(5.dp))
}