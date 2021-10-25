package com.plcoding.cryptocurrencyappyt.domain.use_case.get_coins

import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import javax.inject.Inject


/*This use-case will use the CoinRepository to access out API and
* basically forward that info to the ViewModels*/

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
}