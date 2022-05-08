package com.example.lightspeedtest.data

import android.util.Log
import com.example.lightspeedtest.data.databse.PhotoDao
import com.example.lightspeedtest.data.model.Photo
import com.example.lightspeedtest.data.netword.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class PhotoRepository(
    private val photoDao: PhotoDao,
    private val apiService: ApiService
) {
    suspend fun getNewPhotos(): Flow<PhotoResponse<List<Photo>>> {
        return flow {
            emit(PhotoResponse.Loading())
            val results = apiService.getPhotos()
            if (results.isSuccessful) {
                results.body()?.let {
                    val randomPhoto = it.random()
                    photoDao.insert(randomPhoto)
                }
            }
            emit(PhotoResponse.Success(photoDao.getPhotos()))
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getLocalPhotos(): Flow<PhotoResponse<List<Photo>>> {
        return flow<PhotoResponse<List<Photo>>> {
            emit(PhotoResponse.Success(photoDao.getPhotos()))
        }.flowOn(Dispatchers.IO)
    }

    suspend fun deleteItem(id: String){
        return photoDao.deleteItemById(id)
    }
}