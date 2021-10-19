package com.example.picsumphotos.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Photos")
data class Photo(
    @PrimaryKey
    val id: String,



)
