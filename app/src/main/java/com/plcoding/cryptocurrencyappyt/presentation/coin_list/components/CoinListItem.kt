package com.plcoding.cryptocurrencyappyt.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.presentation.theme.CryptocurrencyAppYTTheme

@Composable
fun CoinListItem(coin: Coin, onItemClick: (Coin) -> Unit) {


    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemClick(coin) }
        .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${coin.rank} ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.body1,

            //cut off text with ... if too long
            overflow = TextOverflow.Ellipsis
        )


        Text(
            text = if (coin.isActive) "Active" else "Inactive",
            color = if (coin.isActive) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            textAlign =  TextAlign.End,
            style = MaterialTheme.typography.body2,
            modifier = Modifier
                .align(CenterVertically)



        )

    }

}

@Preview(name = "CoinListItemPreview")
@Composable
fun CoinListItemPreview() {
    CryptocurrencyAppYTTheme {
        Surface(color = MaterialTheme.colors.background) {

            val coin = Coin(id = "ssds", isActive = false, name = "Bit", rank = 0, symbol = "B")
            CoinListItem(coin = coin, onItemClick = {})

        }}

}