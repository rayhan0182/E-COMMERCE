package com.example.trendtrove.core

sealed class DataState<T>(

    var massage: String? = null,

    var udata:T? = null

    )  {


    class Loading<T>(): DataState<T>()

    class Success<T>(jdata:T?): DataState<T>(udata = jdata)

    class Error<T>(massag: String?): DataState<T>(massag)


}