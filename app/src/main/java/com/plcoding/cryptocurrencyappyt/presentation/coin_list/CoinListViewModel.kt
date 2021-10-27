package com.plcoding.cryptocurrencyappyt.presentation.coin_list

import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
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
class CoinListViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase) {
}