package com.example.lightspeedtest.data.netword

import com.example.lightspeedtest.data.model.Photo
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("list")
    suspend fun getPhotos(): Response<List<Photo>>
}