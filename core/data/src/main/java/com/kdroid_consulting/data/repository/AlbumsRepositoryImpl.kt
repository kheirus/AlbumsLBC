package com.kdroid_consulting.data.repository

import com.kdroid_consulting.common.model.Album
import com.kdroid_consulting.data.api.AlbumsApi
import com.kdroid_consulting.domain.repository.AlbumsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class AlbumsRepositoryImpl (
    private val api: AlbumsApi
) : AlbumsRepository {
    override suspend fun getAlbums(): Flow<Result<List<Album>>> {
        val response = api.getAlbums()

        return flowOf(
            when {
                response.isSuccessful -> {
                    val albums = response.body().orEmpty()
                    Result.success(albums)
                }
                else -> {
                    Result.failure(Exception("Error to get albums for LBC test"))
                }
            }
        )
    }
}