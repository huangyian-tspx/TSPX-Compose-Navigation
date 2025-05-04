package vn.telespacex.tspxnavigation.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberTSPXNavController(navHostController: NavHostController = rememberNavController()): TSPXNavController =
    remember(navHostController) {
        TSPXNavController(navHostController)
    }


class TSPXNavController(val navController: NavHostController) {
    fun upPress() {
        navController.navigateUp()
    }

    fun navigateToTapInBottomBar(route: String) {
        if (route != Screen.Main.route) {
            navController.navigate(route) {
                launchSingleTop = true
                restoreState = true
                popUpTo(findStartDestination(navController.graph).id) {
                    saveState = true
                }
            }
        }
    }

//    fun navigateToTapInBottomBar(route: String) {
//        val navController = this.navController
//        val isSelectedTab = navController.currentDestination?.route?.startsWith(route) == true
//
//        if (isSelectedTab) {
//            // Quay lại màn hình đầu tiên của tab
//            navController.popBackStack(route, inclusive = false)
//        } else {
//            navController.navigate(route) {
//                popUpTo(navController.graph.startDestinationId) { saveState = true }
//                restoreState = true
//                launchSingleTop = true
//            }
//        }
//    }


    fun navigateToConservation(chatID: String, from: NavBackStackEntry) {
        if (from.lifeCircleResumed()) {
            navController.navigate(Screen.ConservationChat.createRoute(chatID))
        }
    }

    fun navigateToDetailOption(from: NavBackStackEntry) {
        if (from.lifeCircleResumed()) {
            navController.navigate(Screen.DetailSetting.route)
        }
    }
}




