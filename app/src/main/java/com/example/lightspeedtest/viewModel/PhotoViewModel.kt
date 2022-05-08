package com.example.lightspeedtest.viewModel

import androidx.lifecycle.*
import com.example.lightspeedtest.data.PhotoResponse
import com.example.lightspeedtest.data.PhotoRepository
import com.example.lightspeedtest.data.model.Photo
import kotlinx.coroutines.launch

class PhotoViewModel(
    private val photoRepository: PhotoRepository
): ViewModel() {

    private val photos: MutableLiveData<PhotoResponse<List<Photo>>> by lazy {
        MutableLiveData<PhotoResponse<List<Photo>>>().also {
            loadLocalPhoto()
        }
    }

    fun getPhotos(loadNew: Boolean): LiveData<PhotoResponse<List<Photo>>> {
        if (loadNew) {
            loadNewPhotos()
        }
        return photos
    }

    fun deleteItemById(id: String) {
        viewModelScope.launch {
            photoRepository.deleteItem(id)
        }
    }

    private fun loadLocalPhoto() {
        viewModelScope.launch {
            photoRepository.getLocalPhotos().collect{
                photos.value = it
            }
        }
    }

    private fun loadNewPhotos() {
        viewModelScope.launch {
            photoRepository.getNewPhotos().collect{
                photos.value = it
            }
        }
    }
}