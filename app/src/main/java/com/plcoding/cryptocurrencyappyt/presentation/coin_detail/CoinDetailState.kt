package com.plcoding.cryptocurrencyappyt.presentation.coin_detail

import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetails

/*
* We create one state object that contains all the
* info that we need for the state
* */
data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin:CoinDetails? = null,
    val error: String = ""
)


/*We don't have the default values for CoinDetails so we make it nullable*/