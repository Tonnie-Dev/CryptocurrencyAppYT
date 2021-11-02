package com.plcoding.cryptocurrencyappyt.presentation.theme.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.cryptocurrencyappyt.presentation.Screen
import com.plcoding.cryptocurrencyappyt.presentation.coin_detail.CoinDetailsScreen
import com.plcoding.cryptocurrencyappyt.presentation.coin_list.CoinListScreen
import com.plcoding.cryptocurrencyappyt.presentation.theme.CryptocurrencyAppYTTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppYTTheme {
                Surface(color = MaterialTheme.colors.background) {


                    //create NavController directly in the top hierarchy

                    val navController = rememberNavController()

                    //call NavHost Composable
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {

                        //First Screen - OverView
                        composable(route = Screen.CoinListScreen.route) {

                            //call the Screen Content
                            CoinListScreen(navController = navController)
                        }

                        //Second Screen - Detail Screen

                        composable(route = Screen.CoinDetailsScreen.route){

                            CoinDetailsScreen()
                        }
                    }


                }
            }
        }
    }
}