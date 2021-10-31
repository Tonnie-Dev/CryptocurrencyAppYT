package com.plcoding.cryptocurrencyappyt.presentation.coin_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.plcoding.cryptocurrencyappyt.presentation.Screen
import com.plcoding.cryptocurrencyappyt.presentation.coin_list.CoinListState
import com.plcoding.cryptocurrencyappyt.presentation.coin_list.CoinListViewModel
import com.plcoding.cryptocurrencyappyt.presentation.coin_list.components.CoinListItem


//we get the viewModel from hilt instead of

@Composable
fun CoinListScreen(viewModel: CoinDetailsViewModel = hiltViewModel()) {

    //we get the coin details state and unbox it using by

    val state by viewModel.state

    /*
    * state success -> show list
    * state loading -> show progress
    * state error  -> show Text with an error
    * */

    Box(modifier = Modifier.fillMaxSize()) {


        //check null on the coin
        state.coin?.let { coin ->
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(20.dp)
            ) {


                item {

                    //Header
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {

                        Text(
                            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                            style = MaterialTheme.typography.h2,
                            modifier = Modifier.weight(8f)
                        )


                        Text(
                            text = if (coin.isActive) "Active" else "Inactive",
                            color = if (coin.isActive) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic, textAlign = TextAlign.End,
                            modifier = Modifier
                                .align(CenterVertically)
                                .weight(2f)
                        )

                    }
                    
                    Spacer(modifier = Modifier.height(15.dp))

                    //Coin Description

                    Text(
                        text = coin.description,
                        style = MaterialTheme.typography.body2
                        //modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(text = "Tags", style = MaterialTheme.typography.h3 )
                    Spacer(modifier = Modifier.height(15.dp))
                }

            }
        }





        if (state.error.isNotBlank()) {


            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(
                        Alignment.TopCenter
                    )
            )
        }


        if (state.isLoading) {


            //progress bar
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }

}