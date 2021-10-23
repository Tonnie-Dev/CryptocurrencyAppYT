package com.plcoding.cryptocurrencyappyt.data.remote

import retrofit2.http.GET

interface CoinPaprikaAPI {

    @GET("/v1/coins")
    suspend fun getCoins()
}