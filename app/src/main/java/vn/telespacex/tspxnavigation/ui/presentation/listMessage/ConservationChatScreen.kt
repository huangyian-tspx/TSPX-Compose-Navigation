package vn.telespacex.tspxnavigation.ui.presentation.listMessage

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ConservationChatScreen(
    chatID : String,
    onBackPress: () -> Unit
) {
    val name = object{}.javaClass.enclosingMethod.name
    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Red)
            .padding(horizontal = 20.dp))  {
            IconButton(
                onClick = onBackPress,
            ) {
                Icon(Icons.Default.Build, contentDescription = "")
            }
        }

        Text("$chatID")
    }
}