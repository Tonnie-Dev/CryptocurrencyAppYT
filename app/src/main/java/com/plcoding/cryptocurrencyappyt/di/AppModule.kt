package com.plcoding.cryptocurrencyappyt.di


import com.plcoding.cryptocurrencyappyt.common.Constants.BASE_URL
import com.plcoding.cryptocurrencyappyt.data.remote.CoinPaprikaAPI
import com.plcoding.cryptocurrencyappyt.data.repository.CoinRepositoryImpl
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*Here we define the dependencies that we have to tell Hilt
* the way to created the dependencies*/

/*annotate with SingletonComponent to imply this needs to live
* as long as our application lives - this implies that all the
* dependencies in this module live as long as the application*/
@Module
@InstallIn(SingletonComponent::class)


object AppModule {

    //inside the object class we create fxns that create the dependencies

    /*Mark fxn with @Provides annotation to imply the fxn provides something
    * @Singleton - ensures that we only hace a single instance of whatever
    * the functions provides*/

    @Provides
    @Singleton
    fun providesPaprikaApi(): CoinPaprikaAPI {

        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(CoinPaprikaAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api:CoinPaprikaAPI):CoinRepository{

        return CoinRepositoryImpl(api = api)
    }

}