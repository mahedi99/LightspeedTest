package com.example.lightspeedtest.ui

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lightspeedtest.PhotoApplication
import com.example.lightspeedtest.R
import com.example.lightspeedtest.viewModel.PhotoViewModel
import com.example.lightspeedtest.viewModel.PhotoViewModelFactory

class PhotoActivity : AppCompatActivity() {
    private lateinit var photoAdapter: PhotoAdapter
    private val photoViewModel: PhotoViewModel by viewModels {
        PhotoViewModelFactory((application as PhotoApplication).repository)
    }
    private lateinit var recyclerView: RecyclerView
    private lateinit var newItemButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        initView()

        photoViewModel.getPhotos(false).observe(this) { photos ->
            photos.data?.let {
                photoAdapter.addItems(it)
            }
        }
    }

    private fun initView() {
        newItemButton = findViewById(R.id.addNewBtn)
        newItemButton.setOnClickListener {
            photoViewModel.getPhotos(true).observe(this) { photos ->
                photos.data?.let { photos ->
                    photoAdapter.addItems(photos)
                    photoAdapter.notifyDataSetChanged()
                }
            }
        }

        recyclerView = findViewById(R.id.recyclerview)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        photoAdapter = PhotoAdapter(photoViewModel)
        recyclerView.adapter = photoAdapter
    }
}