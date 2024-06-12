package com.nhinhnguyenuit.unittestjetpackcompose.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.nhinhnguyenuit.unittestjetpackcompose.ui.view.ItemDetailScreen
import com.nhinhnguyenuit.unittestjetpackcompose.ui.view.ItemListScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.ListScreen.route) {
        composable(Screen.ListScreen.route) {
            ItemListScreen(navController = navController)
        }
        composable(
            Screen.DetailScreen.route,
            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("itemId") ?: 0
            ItemDetailScreen(id = id)
        }
    }
}