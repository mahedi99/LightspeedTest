package com.example.lightspeedtest.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lightspeedtest.data.PhotoRepository

class PhotoViewModelFactory(private val repository: PhotoRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PhotoViewModel::class.java)) {
            return PhotoViewModel(
                photoRepository = repository
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}