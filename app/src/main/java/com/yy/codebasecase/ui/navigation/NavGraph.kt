package com.yy.codebasecase.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yy.codebasecase.ui.screens.propertydetail.PropertyDetailScreen
import com.yy.codebasecase.ui.screens.PropertySharedViewModel
import com.yy.codebasecase.ui.screens.propertylist.PropertyListScreen

@Composable
fun NavGraph(navController: NavHostController) {
    val viewModel: PropertySharedViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = Screen.PropertyList.route
    ) {
        composable(route = Screen.PropertyList.route) {
            PropertyListScreen(navController = navController, sharedViewModel = viewModel)
        }
        composable(
            route = Screen.PropertyDetail.route,
        ) {
            PropertyDetailScreen(
                navController = navController, sharedViewModel = viewModel
            )
        }
    }
}