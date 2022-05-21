package com.plcoding.cryptocurrencyappyt.data.repository

import com.plcoding.cryptocurrencyappyt.data.remote.CoinPaprikaAPI
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDTO
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailDTO
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import timber.log.Timber
import javax.inject.Inject

//this is the real implementation

//It injects the API dependency into the repo's constructor

//It implements the domain's repo which has the use-cases


class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaAPI) : CoinRepository {

    //this suspend method just returns api's getCoins()
    override suspend fun getCoins(): List<CoinDTO> {
        return api.getCoins()
    }

    //this suspend method just returns api's getCoinById()
    override suspend fun getCoinsById(coinId: String): CoinDetailDTO {

        Timber.i("The passedId is $coinId")
        return api.getCoinById(coinId)
    }
}

/*This the implementation of our repo because the actual implementation
* also contains the direct access to the data
*
* The interface inside the domain package don't have much to do with
* getting data from API or the Database, it is main fxn is Testing
* purposes*/