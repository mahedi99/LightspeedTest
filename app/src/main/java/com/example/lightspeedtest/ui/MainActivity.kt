package com.example.lightspeedtest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.lightspeedtest.PhotoApplication
import com.example.lightspeedtest.viewModel.PhotoViewModel
import com.example.lightspeedtest.viewModel.PhotoViewModelFactory
import com.example.lightspeedtest.R

class MainActivity : AppCompatActivity() {
    private val photoViewModel: PhotoViewModel by viewModels {
        PhotoViewModelFactory((application as PhotoApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        photoViewModel.getPhotos(false).observe(this) { photos ->
            photos.data?.forEach {
                Log.d("All Photos ---->", it.author)
            }
        }
    }
}