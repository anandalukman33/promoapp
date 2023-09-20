package com.example.promobank.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.promobank.R
import com.example.promobank.ui.components.LoadNetworkImage
import com.example.promobank.ui.theme.light_primary

@Composable
fun HomeScreenUIContent(
    uiState: HomeUiState,
    navigateToDetailView: (Int) -> Unit
) {
    LazyVerticalGrid(
        GridCells.Fixed(1),
        Modifier
            .padding(top = 20.dp, bottom = 50.dp, start = 5.dp, end = 5.dp)
            .testTag("List Promo")
    ) {
        itemsIndexed(uiState.tempPromoList) { _, item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .clip(shape = MaterialTheme.shapes.large)
                    .clickable(onClick = { navigateToDetailView(item.id ?: 0) })
                    .padding(5.dp),
                backgroundColor = light_primary
            ) {
                Column {
                    LoadNetworkImage(
                        imageUrl = item.img?.formats?.small?.url,
                        contentDescription = stringResource(R.string.app_name),
                        shape = RectangleShape,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                    )

                    Spacer(modifier = Modifier.padding(vertical = 5.dp))

                    Text(
                        text = item.nama.toString(),
                        style = MaterialTheme.typography.subtitle1,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp)
                    )

                    Spacer(modifier = Modifier.padding(vertical = 12.dp))
                }
            }
        }
    }
}