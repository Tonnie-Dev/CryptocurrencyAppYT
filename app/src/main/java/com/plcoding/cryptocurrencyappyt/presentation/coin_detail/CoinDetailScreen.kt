package com.plcoding.cryptocurrencyappyt.presentation.coin_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.plcoding.cryptocurrencyappyt.presentation.Screen
import com.plcoding.cryptocurrencyappyt.presentation.coin_list.CoinListState
import com.plcoding.cryptocurrencyappyt.presentation.coin_list.CoinListViewModel
import com.plcoding.cryptocurrencyappyt.presentation.coin_list.components.CoinListItem


//we get the viewModel from hilt instead of

@Composable
fun CoinListScreen(viewModel: CoinDetailsViewModel = hiltViewModel()) {

    //we get the coin details state and unbox it using by

    val state by viewModel.state
    
    /*
    * state success -> show list
    * state loading -> show progress
    * state error  -> show Text with an error
    * */

   Box(modifier = Modifier.fillMaxSize()) {



       //check null on the coin
       state.coin?.let {

           coin ->
           LazyColumn(modifier = Modifier.fillMaxWidth()){



           }
       }





       if (state.error.isNotBlank()){


           Text(
               text = state.error,
               color = MaterialTheme.colors.error,
               textAlign = TextAlign.Center,
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(20.dp)
                   .align(
                       Alignment.TopCenter
                   )
           )
       }


       if (state.isLoading){


           //progress bar
           CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
       }

   }
    
}