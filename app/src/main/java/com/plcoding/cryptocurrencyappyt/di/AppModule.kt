package com.plcoding.cryptocurrencyappyt.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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

}