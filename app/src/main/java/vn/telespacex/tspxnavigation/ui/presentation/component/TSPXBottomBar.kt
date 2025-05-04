package vn.telespacex.tspxnavigation.ui.presentation.component

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import vn.telespacex.tspxnavigation.navigation.Screen
import vn.telespacex.tspxnavigation.navigation.section.MainSection

@Composable
fun TSPXBottomBar(
    currentRoute: String,
    navigateToRoute: (String) -> Unit
) {
    NavigationBar {
        NavigationBarItem(
            selected = currentRoute == Screen.Message.route,
            onClick = { navigateToRoute(Screen.Message.route) },
            icon = { Icon(MainSection.LIST_MESSAGE.icon, contentDescription = "") },
            label = { Text(MainSection.LIST_MESSAGE.title) }
        )
        NavigationBarItem(
            selected = currentRoute == Screen.Friend.route,
            onClick = { navigateToRoute(Screen.Friend.route) },
            icon = { Icon(MainSection.LIST_FRIEND.icon, contentDescription = "") },
            label = { Text(MainSection.LIST_FRIEND.title) }
        )
        NavigationBarItem(
            selected = currentRoute == Screen.ChatAI.route,
            onClick = { navigateToRoute(Screen.ChatAI.route) },
            icon = { Icon(MainSection.CHAT_AI.icon, contentDescription = "") },
            label = { Text(MainSection.CHAT_AI.title) }
        )
        NavigationBarItem(
            selected = currentRoute == Screen.Setting.route,
            onClick = { navigateToRoute(Screen.Setting.route) },
            icon = { Icon(MainSection.SETTING.icon, contentDescription = "") },
            label = { Text(MainSection.SETTING.title) }
        )
    }
}