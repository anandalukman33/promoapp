package com.example.promobank.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.promobank.ui.screen.detail.DetailScreen
import com.example.promobank.ui.screen.home.HomeScreen

@Composable
fun AppNavigation(
    startDestination: String =  AppDestinations.HOME_ROUTE,
    route: AppDestinations = AppDestinations
) {

    val navController = rememberNavController()
    val actions = remember(navController) {
        AppActions(navController, route)
    }

    NavHost(navController = navController, startDestination = startDestination) {

        composable(AppDestinations.HOME_ROUTE) {
            HomeScreen(navigateToDetailView = actions.navigateToSelectedPromoDetail)
        }

        composable(
                route = "${AppDestinations.DETAIL_ROUTE}/{${route.PROMO_ID}}",
            arguments = listOf(
                navArgument(route.PROMO_ID) { type = NavType.IntType }
            )
        ) {
            DetailScreen()
        }

    }

}