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
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext

class AlbumsRepositoryImpl (
    private val api: AlbumsApi,
    private val albumsDao: AlbumsDao
) : AlbumsRepository {
    override suspend fun getAlbums(): Flow<Result<List<Album>>> {
        //todo: should introduce a timer (or another parameter) to force update cache
        if (getCachedData().isEmpty()) {
            val response = api.getAlbums()
            when {
                response.isSuccessful -> {
                    val albums = response.body().orEmpty()
                    insertToDatabase(albums)
                    Result.Success(albums.toDomainAlbums())
                }
                else -> {
                    Result.Failure(Exception("Error to get albums for LBC test"))
                }
            }
        }
        // Return the data from the cache after updating the data base
        return flowOf(
            Result.Success(
                getCachedData().toDomainAlbums()
            )
        )
    }

    private suspend fun getCachedData(): List<AlbumsEntity> =
        withContext(Dispatchers.IO){
            albumsDao.getAll()
        }

    private suspend fun insertToDatabase(albums: List<AlbumData>) {
        withContext(Dispatchers.IO){
            albums.map {
                albumsDao.insert(it.toEntityAlbum())
            }
        }
    }
}