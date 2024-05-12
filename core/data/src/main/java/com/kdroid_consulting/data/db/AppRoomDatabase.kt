package com.kdroid_consulting.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kdroid_consulting.data.dao.AlbumsDao
import com.kdroid_consulting.model.AlbumsEntity

@Database(entities = [AlbumsEntity::class], version = 1, exportSchema = false)
abstract class AppRoomDatabase : RoomDatabase(){
    abstract fun AlbumsDao() : AlbumsDao
}