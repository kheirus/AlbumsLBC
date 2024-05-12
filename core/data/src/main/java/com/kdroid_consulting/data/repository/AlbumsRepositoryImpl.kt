package com.kdroid_consulting.data.repository

import com.kdroid_consulting.common.Result
import com.kdroid_consulting.data.api.AlbumsApi
import com.kdroid_consulting.data.dao.AlbumsDao
import com.kdroid_consulting.domain.model.Album
import com.kdroid_consulting.domain.repository.AlbumsRepository
import com.kdroid_consulting.model.AlbumData
import com.kdroid_consulting.model.AlbumsEntity
import com.kdroid_consulting.model.toDomainAlbums
import com.kdroid_consulting.model.toEntityAlbum
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class AlbumsRepositoryImpl (
    private val api: AlbumsApi,
    private val albumsDao: AlbumsDao
) : AlbumsRepository {
    override suspend fun getAlbums(): Flow<Result<List<Album>>> {
        return flow {
            // If the cache is empty, fetch data from API and fill the database
            if (getCachedData().isEmpty()) {
                val response = api.getAlbums()
                when {
                    response.isSuccessful -> {
                        val albums = response.body().orEmpty()
                        insertToDatabase(albums)
                        emit(Result.Success(getCachedData()))
                    }
                    else -> {
                        emit(Result.Failure(Exception("Error to get albums for LBC test")))
                    }
                }
                // If the cache is not empty, return the cached data
            } else {
                emit(Result.Success(getCachedData()))
            }
        }.flowOn(Dispatchers.IO)
    }

    private suspend fun getCachedData(): List<Album> =
        withContext(Dispatchers.IO){
            albumsDao.getAll().toDomainAlbums()
        }

    private suspend fun insertToDatabase(albums: List<AlbumData>) {
        withContext(Dispatchers.IO){
            albums.map {
                albumsDao.insert(it.toEntityAlbum())
            }
        }
    }
}