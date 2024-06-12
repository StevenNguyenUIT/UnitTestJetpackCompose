package com.nhinhnguyenuit.unittestjetpackcompose

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.rememberNavController
import com.nhinhnguyenuit.unittestjetpackcompose.navigation.NavGraph
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowBuild

@Config(sdk = [28]) // Specify the SDK version to emulate
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        // Set up a default value for Build.FINGERPRINT
        ShadowBuild.setFingerprint("robolectric")
    }

    @Test
    fun testMainActivityDisplaysItemListScreen() {
        composeTestRule.setContent {
            val navController = rememberNavController()
            NavGraph(navController = navController)
        }

        // Check if the item list screen is displayed
        composeTestRule.onNodeWithText("Item 1").assertExists()
    }
}