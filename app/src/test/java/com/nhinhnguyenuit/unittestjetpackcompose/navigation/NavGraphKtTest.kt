package com.nhinhnguyenuit.unittestjetpackcompose.navigation

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import com.google.ar.core.Config
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test
class NavGraphKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testNavigationToDetailScreen() {
        composeTestRule.setContent {
            val navController = rememberNavController()
            NavGraph(navController = navController)
        }

        // Perform a click on an item to navigate to detail screen
        composeTestRule.onNodeWithText("Jamie's burgers").performClick()

        // Check if the detail screen is displayed
        composeTestRule.onNodeWithText("At Jamie's, we serve the best meat and vegan burgers!").assertExists()
    }
}