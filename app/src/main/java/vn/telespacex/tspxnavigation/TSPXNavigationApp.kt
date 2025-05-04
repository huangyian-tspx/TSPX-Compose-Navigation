package vn.telespacex.tspxnavigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import vn.telespacex.tspxnavigation.navigation.Screen
import vn.telespacex.tspxnavigation.navigation.rememberTSPXNavController
import vn.telespacex.tspxnavigation.ui.presentation.chatAI.ChatTSPXAIScreen
import vn.telespacex.tspxnavigation.ui.presentation.component.TSPXBottomBar
import vn.telespacex.tspxnavigation.ui.presentation.friend.ListFriendScreen
import vn.telespacex.tspxnavigation.ui.presentation.listMessage.ConservationChatScreen
import vn.telespacex.tspxnavigation.ui.presentation.listMessage.ListMessageScreen
import vn.telespacex.tspxnavigation.ui.presentation.setting.DetailOptionsSettingScreen
import vn.telespacex.tspxnavigation.ui.presentation.setting.SettingOverviewScreen
import vn.telespacex.tspxnavigation.ui.theme.TSPXNavigationTheme

@Preview
@Composable
fun TSPXNavigationApp() {
    TSPXNavigationTheme {
        val tspxNavController = rememberTSPXNavController()
        NavHost(
            navController = tspxNavController.navController,
            startDestination = Screen.Main.route,
        ) {
            composable(Screen.Main.route) {
                TSPXMainContainer(
                    onNavigateToChat = tspxNavController::navigateToConservation,
                )
            }
            composable(
                route = Screen.ConservationChat.route,
                arguments = listOf(
                    navArgument(Screen.ARG_CHAT_ID) {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->
                val chatId = backStackEntry.arguments?.getString(Screen.ARG_CHAT_ID) ?: ""
                ConservationChatScreen(chatId, tspxNavController::upPress)
            }
        }
    }
}

@SuppressLint("RestrictedApi")
@Composable
fun TSPXMainContainer(
    onNavigateToChat: (String, NavBackStackEntry) -> Unit,
) {
    val tspxNavController = rememberTSPXNavController()
    val navController = tspxNavController.navController
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            TSPXBottomBar(
                currentRoute ?: Screen.Message.route,
                navigateToRoute = tspxNavController::navigateToTapInBottomBar
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Message.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            mainGraph(
                selectedChat = onNavigateToChat,
                onClickToDetailSetting = tspxNavController::navigateToDetailOption
            )
        }
    }
}



fun NavGraphBuilder.mainGraph(
    selectedChat: (String, NavBackStackEntry) -> Unit,
    onClickToDetailSetting: (NavBackStackEntry) -> Unit
) {
    composable(Screen.Message.route) { from ->
        ListMessageScreen(modifier = Modifier, navigateToConservationChatScreen = { id ->
            selectedChat(id, from)
        })
    }
    composable(Screen.Friend.route) {
        ListFriendScreen()
    }
    composable(Screen.ChatAI.route) {
        ChatTSPXAIScreen()
    }
    settingSubGraph(
        onClickToDetailSetting = onClickToDetailSetting
    )
}

fun NavGraphBuilder.settingSubGraph(
    onClickToDetailSetting: (NavBackStackEntry) -> Unit
) {
    navigation(
        route = Screen.SettingGraph.route,
        startDestination = Screen.Setting.route
    ) {
        composable(Screen.Setting.route) { from ->
            SettingOverviewScreen(onClickSettingOption = { onClickToDetailSetting(from) })
        }
        composable(Screen.DetailSetting.route) {
            DetailOptionsSettingScreen()
        }
    }
}




