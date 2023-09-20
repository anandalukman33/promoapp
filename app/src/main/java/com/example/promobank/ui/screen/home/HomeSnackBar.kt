package com.example.promobank.ui.screen.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeSnackBar(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier
) {
    SnackbarHost(hostState) { data ->
        Snackbar(
            snackbarData = data,
            // To avoid colliding with navigation bar.
            modifier = modifier.padding(bottom = 48.dp)
        )
    }
}