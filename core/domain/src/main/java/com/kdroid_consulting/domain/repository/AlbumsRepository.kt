package com.kdroid_consulting.domain.repository

import com.kdroid_consulting.common.Result
import com.kdroid_consulting.domain.model.Album
import kotlinx.coroutines.flow.Flow

interface AlbumsRepository {
    suspend fun getAlbums(): Flow<Result<List<Album>>>
}