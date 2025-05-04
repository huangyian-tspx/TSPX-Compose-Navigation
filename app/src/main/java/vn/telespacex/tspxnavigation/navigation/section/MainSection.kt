package vn.telespacex.tspxnavigation.navigation.section

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class MainSection (
    val title: String,
    val icon : ImageVector,
) {
    LIST_MESSAGE("Message", Icons.Outlined.List),
    LIST_FRIEND("Friend", Icons.Outlined.Face),
    CHAT_AI("AI", Icons.Outlined.Build),
    SETTING("Setting", Icons.Outlined.Settings),
}