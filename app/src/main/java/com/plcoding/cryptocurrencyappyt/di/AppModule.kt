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


/*@InstallIn tells Hilt the containers where the bindings are
available by specifying a Hilt component.

You can think of a Hilt component as a container. */




@Module
@InstallIn(SingletonComponent::class)
object AppModule {
/*inside the object class we create fxns that create the dependencies
*
* */


/*Hilt Module is meant for class that cannot be constructor-injected*/


/*Mark fxn with @Provides annotation to imply the fxn provides something.

/*We annotate a function with @Provides in Hilt modules to tell
Hilt how to provide types that cannot be constructor injected.*/

 @Singleton - ensures that we only have a single instance of whatever
* the functions provides*/

    //API Dependency to be returned
    @Provides
    @Singleton
    fun providesPaprikaApi(): CoinPaprikaAPI {

        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaAPI::class.java)
    }
   /*REPO Interface Dependency to be returned - because you can't return
    the actual interface an implementation is returned*/

    @Provides //tell hilt to provide dependency that cannot be
              //constructor-injected

    @Singleton // in this case ensures that we only have a single instance
              // of whatever the functions provides

    /*the fxn parameter will be dependencies of CoinRepositoryImpl
    i.e CoinPaprikaAPI*/

    fun provideCoinRepository(api:CoinPaprikaAPI):CoinRepository{

        return CoinRepositoryImpl(api = api)
    }

}




