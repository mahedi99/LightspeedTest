package com.example.lightspeedtest.data.databse

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.lightspeedtest.data.model.Photo

@Dao
interface PhotoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(photo: Photo)

    @Query("SELECT * FROM photo_table")
    fun getPhotos(): List<Photo>

    @Query("DELETE FROM photo_table")
    suspend fun deleteAll()
}