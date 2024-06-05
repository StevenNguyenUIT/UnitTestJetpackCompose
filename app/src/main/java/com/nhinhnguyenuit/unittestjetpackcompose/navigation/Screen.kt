package com.nhinhnguyenuit.unittestjetpackcompose.navigation

sealed class Screen(val route: String) {
    object ListScreen  : Screen("item_list")
    object DetailScreen : Screen("item_detail/{itemId}")
}