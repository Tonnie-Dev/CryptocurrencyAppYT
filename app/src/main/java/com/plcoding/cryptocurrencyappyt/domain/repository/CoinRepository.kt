package com.plcoding.cryptocurrencyappyt.domain.repository

import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDTO
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailDTO


/*The reason we have this Interface is that it is helpful for test case
* If we need to test the use-case later that uses this repository, then
*  you don't want to run this test case for the use-case with your actual
* repository implementation that uses the API because that would just
* take way too long, you use your API quota and maybe the Firebase quota.
*
* Instead you create a fake repo that implements this very interface
* to simulate the behaviour of getting some data from the API*/


/*If you had a database for local caching this repo would also contain
* functions for inserting data into database*/

interface CoinRepository {

    suspend fun getCoins():List<CoinDTO>
    suspend fun getCoinsById(coinId:String):CoinDetailDTO
}