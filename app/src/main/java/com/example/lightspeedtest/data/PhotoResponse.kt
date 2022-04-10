package com.example.lightspeedtest.data

sealed class PhotoResponse<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : PhotoResponse<T>(data)
    class Error<T>(message: String, data: T? = null) : PhotoResponse<T>(data, message)
    class Loading<T> : PhotoResponse<T>()
}