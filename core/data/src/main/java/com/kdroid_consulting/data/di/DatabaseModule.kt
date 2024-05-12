package com.kdroid_consulting.data.di

import android.content.Context
import androidx.room.Room
import com.kdroid_consulting.data.dao.AlbumsDao
import com.kdroid_consulting.data.db.AppRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppRoomDatabase {
        return Room.databaseBuilder(
            appContext,
            AppRoomDatabase::class.java,
            "db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideAlbumsDao(appRoomDatabase: AppRoomDatabase): AlbumsDao {
        return appRoomDatabase.AlbumsDao()
    }

}