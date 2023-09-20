package com.example.promobank.ui.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.promobank.model.PromosResponseItem

@Composable
fun DetailContent(
    data: PromosResponseItem
) {

    Column(Modifier.padding(10.dp)) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center,
            text = data.nama.toString()
        )
        Text(
            text = data.desc.toString(),
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            textAlign = TextAlign.Justify
        )
    }


}