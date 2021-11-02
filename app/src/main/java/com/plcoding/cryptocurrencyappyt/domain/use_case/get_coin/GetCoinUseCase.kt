package com.plcoding.cryptocurrencyappyt.domain.use_case.get_coin


import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoinDetails
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetails
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.NullPointerException
import javax.inject.Inject


/*This use-case will use the CoinRepository to access out API and
* basically forward that info to the ViewModels*/

/*We Inject the CoinRepository interface instead of the implementation
* which is easily be replaced*/

/*This use case doesn't really care which repo it gets as long as it
* provides interface with 2 methods getCoin and getCoins*/

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {


    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> = flow {


        try {

            emit(Resource.Loading())

            val coin = repository.getCoinsById(coinId = coinId).toCoinDetails()

            emit(Resource.Success(coin))

        }

        //thrown when something goes wrong while processing any HTTP request.
        catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An expected error occurred"))

        }

        /* thrown when there is a failure during reading, writing, and searching
         file or directory operations - in this case when there is failure
         to communicate with the server due to lack of internet connection or
         Servers are offline*/
        catch (e: IOException) {

            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }


    }
}