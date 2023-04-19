package com.example.messager.Screen



import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.messager.R
import com.example.messager.data.User
import java.time.format.TextStyle


@Composable
fun UserList(modifier: Modifier,users: List<User>, onClick: (User) -> Unit) {
    LazyColumn(
        modifier=modifier
    ) {
        items(users) { user ->
            UserListItem(user = user, onClick = onClick)
            Divider()

        }
    }
}

@Composable
fun UserListItem(user: User, onClick: (User) -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = { onClick(user) })
            //.padding(0.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.avatar_hombre_1 ),
            contentDescription = "Imagen de usuario",
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
        )
        Column{
            Text(
                text = user.name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 0.dp,
                                            top =10.dp,
                                            end = 0.dp,
                                            bottom = 0.dp),

                )
            Text(
                text = "Aca se va a mostrar el ultimo mensaje escrito por el usuario solamente se mostrara una parte",
                fontSize = 13.sp,
                maxLines=1,
                overflow = TextOverflow.Ellipsis
                //style = MaterialTheme.typography.overline,
                //modifier = Modifier.weight(1f)

                )
        }

        // You can add additional information about the user here, such as their profile picture or online status
    }
}