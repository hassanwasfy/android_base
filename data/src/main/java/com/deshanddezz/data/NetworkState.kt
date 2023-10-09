package com.deshanddezz.data

sealed class NetworkState {
    data class Success<out T>(val data: T) : NetworkState()
    data class Error(val th: Throwable) : NetworkState()
    object Loading : NetworkState()
    object StopLoading : NetworkState()

}
