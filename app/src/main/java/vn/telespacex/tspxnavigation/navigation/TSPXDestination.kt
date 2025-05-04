package vn.telespacex.tspxnavigation.navigation

sealed class Screen(val route: String) {
    // Main Graph
    object Main : Screen("main")

    //Setting Graph
    object SettingGraph : Screen("main/setting_graph")
    object Setting : Screen("main/setting_graph/setting")
    object DetailSetting : Screen("main/setting_graph/detail_setting")

    //Message Graph
    object Message : Screen("main/message")
    object ConservationChat : Screen("conservation/{$ARG_CHAT_ID}") {
        fun createRoute(chatID: String) = "conservation/$chatID"
    }

    object Friend : Screen("main/friend")

    object ChatAI : Screen("main/chat_ai")

    companion object {
        const val ARG_CHAT_ID = "chatID"
    }
}