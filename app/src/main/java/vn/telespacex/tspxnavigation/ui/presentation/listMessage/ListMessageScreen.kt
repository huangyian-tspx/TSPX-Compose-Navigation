package vn.telespacex.tspxnavigation.ui.presentation.listMessage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ListMessageScreen(modifier: Modifier, navigateToConservationChatScreen: (String) -> Unit) {
    val name = object {}.javaClass.enclosingMethod.name
    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text("$name", modifier = Modifier.clickable {
            navigateToConservationChatScreen("tert_id")
        })
    }
}