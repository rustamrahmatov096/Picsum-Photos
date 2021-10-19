package com.example.picsumphotos.room

import androidx.room.*


@Dao
interface PhotoDao {
    @Insert
    fun addPhoto(photo: Photo)

    @Query("select * from photos")
    fun getPhotos():List<Photo>

    @Update
    fun updatePhoto(photo: Photo)

    @Delete
    fun deletePhoto(photo: Photo)

}