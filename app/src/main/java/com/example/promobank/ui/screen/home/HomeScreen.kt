package com.example.promobank.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.promobank.ui.components.LaunchSnackBar

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToDetailView: (Int) -> Unit
) {
    val scaffoldState = rememberScaffoldState()

    val state = viewModel.uiState
    if (state.isFetching) {
        Surface (
            color = MaterialTheme.colors.background,
            modifier = Modifier
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(Modifier.size(150.dp))
            }
        }

    } else {
        if (state.isSuccess) {
            Surface (
                color = MaterialTheme.colors.background,
                modifier = Modifier
            ) {
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "Promo BNI",
                                    style = TextStyle(
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 24.sp
                                    ),
                                    modifier = Modifier.testTag("Header Promo")
                                )
                            }
                        )
                    },
                    snackbarHost = { HomeSnackBar(it) }
                ) { paddingValues ->
                    Box(
                        modifier = Modifier.padding(paddingValues = paddingValues)
                    ) {
                        HomeScreenUIContent(viewModel.uiState, navigateToDetailView)
                    }
                }
            }
        } else {
            LaunchSnackBar(scaffoldState = scaffoldState, snackBarMessage = state.errorMessage.toString())
        }
    }


}