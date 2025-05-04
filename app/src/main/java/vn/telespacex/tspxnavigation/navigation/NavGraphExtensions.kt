package vn.telespacex.tspxnavigation.navigation

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph

val NavGraph.startDestination: NavDestination? get() = findNode(startDestinationId)

tailrec fun findStartDestination(navDestination: NavDestination) : NavDestination {
    return if (navDestination is NavGraph) findStartDestination(navDestination = navDestination.startDestination!!) else navDestination
}

/**
 * Check the screen alive
 * Avoid duplicate navigate
 */
fun NavBackStackEntry.lifeCircleResumed() =
    this.lifecycle.currentState == Lifecycle.State.RESUMED

