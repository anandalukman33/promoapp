package com.example.promobank.ui.screen.detail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.promobank.R
import com.example.promobank.model.PromosResponseItem
import com.example.promobank.ui.screen.detail.util.DrawableWrapper
import com.example.promobank.ui.theme.light_blue
import com.example.promobank.ui.theme.light_onPrimary
import com.example.promobank.ui.theme.orange

@Composable
fun DestinationAndDateAttribute(data: PromosResponseItem) {

    val context = LocalContext.current

    Column {
        Row {
            val paddingModifier = Modifier.padding(10.dp)
            Card(elevation = 10.dp, modifier = paddingModifier) {
                if (data.lokasi != null) {
                    Text(
                        text = data.lokasi,
                        modifier = paddingModifier
                    )
                }
            }
            if (data.latitude != null && data.longitude != null) {
                Card(
                    elevation = 10.dp,
                    backgroundColor = orange,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            val gmmIntentUri =
                                Uri.parse("google.navigation:q=" + data.latitude + "," + data.longitude + "&mode=b")
                            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                            mapIntent.setPackage("com.google.android.apps.maps")
                            context.startActivity(mapIntent)
                        }) {

                    Row {
                        DrawableWrapper(
                            drawableStart = R.drawable.ic_location,
                            modifier = paddingModifier
                        ) {
                            Text(color = light_onPrimary, text = "Lokasi")
                        }
                    }
                }
            }

            Card(elevation = 10.dp, modifier = paddingModifier, backgroundColor = light_blue) {
                if (data.createdAt != null) {
                    Text(
                        text = data.createdAt,
                        modifier = paddingModifier,
                        color = light_onPrimary
                    )
                }
            }
        }
    }
}