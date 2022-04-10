package com.example.lightspeedtest.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "photo_table")
data class Photo(
    @PrimaryKey
    @SerializedName("id") var id: String,
    @SerializedName("author") var author: String,
    @SerializedName("width") var width: Int,
    @SerializedName("height") var height: Int,
    @SerializedName("url") var url: String,
    @SerializedName("download_url") var download_url: String
)
