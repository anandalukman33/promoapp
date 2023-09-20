package com.example.promobank.ui.components

import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun LaunchSnackBar(
    scaffoldState: ScaffoldState,
    snackBarMessage: String,
    scope: CoroutineScope = rememberCoroutineScope()
) {
    LaunchedEffect(scope) {
        scope.launch {
            scaffoldState.snackbarHostState.showSnackbar(
                message = snackBarMessage,
                duration = SnackbarDuration.Indefinite
            )
        }
    }
}