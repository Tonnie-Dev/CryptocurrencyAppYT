package com.plcoding.cryptocurrencyappyt.common

import java.math.BigDecimal

sealed class Resource<T>(val data: T? = null, val message: String?= null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String , data: T? = null ) : Resource<T>(data, message)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}

enum class Planet(val planetName:String, val radius:Int){

    JUPITER("Jupiter", 123),SATURN("Saturn", 90);
}