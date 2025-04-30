package vn.telespacex.tspxnavigation.navigation

import androidx.compose.runtime.Stable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.rememberNavController


val navController = rememberNavController()

/**
 * Check the screen alive
 * Avoid duplicate navigate
 */
private fun NavBackStackEntry.lifeCircleResumed() =
    this.lifecycle.currentState == Lifecycle.State.RESUMED

@Stable
class TSPXNavController {

}
