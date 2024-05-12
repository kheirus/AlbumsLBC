package com.kdroid_consulting.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kdroid_consulting.model.AlbumsEntity

@Dao
interface AlbumsDao {
    @Query("SELECT * FROM albums_table")
    fun getAll(): List<AlbumsEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(albumsEntity: AlbumsEntity)
}