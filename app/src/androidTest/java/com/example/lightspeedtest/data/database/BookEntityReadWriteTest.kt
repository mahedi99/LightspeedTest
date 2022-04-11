package com.example.lightspeedtest.data.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.lightspeedtest.data.databse.PhotoDao
import com.example.lightspeedtest.data.databse.PhotoDatabase
import com.example.lightspeedtest.data.model.Photo
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.hamcrest.Matchers.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class BookEntityReadWriteTest {

    private lateinit var photoDao: PhotoDao
    private lateinit var db: PhotoDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, PhotoDatabase::class.java).build()
        photoDao = db.photoDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
        val photo = Photo(
            "100",
            "Test Author",
            100,
            100,
            "test_url",
            "test_url"
        )

        runBlocking {
            launch {
                photoDao.insert(photo)
            }
        }
        val byName = photoDao.getPhotos()
        assertThat(byName[0], equalTo(photo))
    }
}