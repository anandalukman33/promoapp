package com.example.promobank.ui.screen.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.promobank.R
import com.example.promobank.model.Formats
import com.example.promobank.model.Img
import com.example.promobank.model.PromosResponseItem
import com.example.promobank.model.Small
import com.example.promobank.ui.components.LaunchSnackBar
import com.example.promobank.ui.components.LoadNetworkImage
import com.example.promobank.ui.screen.home.HomeSnackBar

@Composable
fun DetailScreen(
 viewModel: DetailViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val state = viewModel.uiState

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
                        Column {
                            val paddingModifier  = Modifier.padding(10.dp)
                            Card(elevation = 10.dp, modifier = paddingModifier) {
                                LoadNetworkImage(
                                    imageUrl = state.smallImgEntity?.smallUrlImg,
                                    contentDescription = stringResource(R.string.app_name),
                                    shape = RectangleShape,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(
                                            state.smallImgEntity?.height?.dp
                                                ?: 180.dp
                                        )
                                )
                            }
                            val small = Small(
                                url = state.smallImgEntity?.smallUrlImg,
                                width = state.smallImgEntity?.width,
                                height = state.smallImgEntity?.height
                            )
                            val format = Formats(small = small)
                            val img = Img(
                                width = state.imgEntity?.baseWidth,
                                height = state.imgEntity?.baseHeight,
                                url = state.imgEntity?.baseUrl,
                                formats = format
                            )

                            val promosResponseItem = PromosResponseItem(
                                img = img,
                                id = state.promoDetail?.idPromo,
                                nama = state.promoDetail?.titlePromo,
                                desc = state.promoDetail?.descPromo,
                                latitude = state.promoDetail?.latitudePromo,
                                longitude = state.promoDetail?.longitudePromo,
                                createdAt = state.promoDetail?.createdAtFormatted,
                                lokasi = state.promoDetail?.lokasi,
                                count = state.promoDetail?.count
                            )
                            DetailContent(promosResponseItem)
                            DestinationAndDateAttribute(promosResponseItem)
                        }
                    }
                }
            }
        } else {
            LaunchSnackBar(scaffoldState = scaffoldState, snackBarMessage = state.errorMessage.toString())
        }

}

@Preview
@Composable
fun PreviewDetail() {
    DetailScreen()
}