package com.plcoding.cryptocurrencyappyt.presentation.coin_detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_coins.GetCoinsUseCase
import com.plcoding.cryptocurrencyappyt.presentation.coin_list.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/*We inject use case as a dependency
* the constructor is private as it is only for this class own consumption*/



/*The main purpose of the ViewModel is to just maintain our state
*
* ViewModels keep the UI state even when we rotate the screen,
* change the language
*
* that is still their job but here the ViewModel contains less
* Business Logic*/
@HiltViewModel
class CoinListViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase) :
    ViewModel() {


    //we introduce the class that holds the state which we will then expose to the composables

    //this state variable will be the one to be exposed to the composables
    var state = mutableStateOf(CoinListState())
        //restrict writes to only inside the ViewModel
        private set


//inside the init we call the getCoins method to start altering the state and observation
    init {
        getCoins()
    }

    private fun getCoins(){


        // use the injected GetCoinUseCase Class which calls invoke implicitly

        //this returns a flow of Resource Objects


        /*we call ON-each to iterate on each element this flow emits*/
        getCoinsUseCase().onEach { result ->


            when(result){


                is Resource.Success -> {


                    //if null just return an empty list
                    state.value = CoinListState(coins = result.data?: emptyList())
                }
                is Resource.Error -> {


                    state.value = CoinListState(error = result.message ?: "An expected error occurred")
                }
                is Resource.Loading -> {


                    state.value = CoinListState(isLoading = true)
                }
            }
        }

      /*  last we need to launchthe flow inside a Coroutine because flows
       are asynchronous. We call launchIn to launch this inside the
       ViewModelScope*/

            .launchIn(viewModelScope)
    }

}