package com.plcoding.cryptocurrencyappyt.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaAPI {

    @GET("/v1/coins")
    suspend fun getCoins()

    @GET("/v1/coins/{coidID}")
    suspend fun getCoinById(@Path("coinId"), coinId:String)
}