package com.example.lightspeedtest.data.databse

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lightspeedtest.data.model.Photo
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Photo::class], version = 1)
abstract class PhotoDatabase : RoomDatabase() {

    abstract fun photoDao(): PhotoDao

    companion object {
        @Volatile
        private var INSTANCE: PhotoDatabase? = null
        private const val DATABASE_NAME = "v1.db"

        fun getDatabase(context: Context, scope: CoroutineScope): PhotoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PhotoDatabase::class.java,
                    DATABASE_NAME
                ).build()

                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}