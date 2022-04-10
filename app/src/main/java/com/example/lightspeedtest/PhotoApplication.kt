package com.example.lightspeedtest

import android.app.Application
import com.example.lightspeedtest.data.PhotoRepository
import com.example.lightspeedtest.data.netword.RetrofitBuilder
import com.example.lightspeedtest.data.databse.PhotoDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class PhotoApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    private val applicationScope = CoroutineScope(SupervisorJob())
    private val database by lazy { PhotoDatabase.getDatabase(this, applicationScope) }
    private val apiService by lazy { RetrofitBuilder.apiService }
    val repository by lazy { PhotoRepository(database.photoDao(), apiService) }
}