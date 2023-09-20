package com.example.promobank.ui.navigation

import androidx.navigation.NavHostController

/**
 * @property navController helps us navigate by performing action.
 * @property routes destinations to navigate once action is triggered.
 */
class AppActions(
    private val navController: NavHostController,
    private val routes: AppDestinations
) {

    val navigateToSelectedPromoDetail: (Int) -> Unit = {promoId: Int ->
        navController.navigate("${routes.DETAIL_ROUTE}/$promoId")
    }



    // Navigates to previous screen from current screen.
    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
}