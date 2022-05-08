package com.plcoding.cryptocurrencyappyt.data.remote

import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDTO
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaAPI {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDTO>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDTO


    @GET("group/{id}/users")
    fun groupList(@Path("id") groupId: Int): Call<List<User>>


    data class User(val name: String)

//https://api.coinpaprika.com/v1/coins/
    // Coin(id=btc-bitcoin
    //Coin(id=solnet-solana-network
    //Coin(id=ada-cardano
}