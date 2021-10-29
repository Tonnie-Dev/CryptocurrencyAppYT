package com.plcoding.cryptocurrencyappyt.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.plcoding.cryptocurrencyappyt.domain.model.Coin

@Composable
fun CoinListItem( coin: Coin, onItemClick: (Coin)-> Unit) {


    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemClick }) {

    }

}

@Preview(name = "CoinListItemPreview")
@Composable
fun CoinListItemPreview() {

    val coin = Coin(id = "ssds", isActive = false, name = "Bit", rank = 0, symbol = "B")
    CoinListItem(coin = coin, onItemClick = {})
}