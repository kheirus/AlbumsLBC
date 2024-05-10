package com.kdroid_consulting.common

sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Failure(val exception: Throwable) : Result<Nothing>
    data object Loading : Result<Nothing>
}