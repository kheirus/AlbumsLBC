package com.kdroid_consulting.domain.repository

import com.kdroid_consulting.common.model.Album
import kotlinx.coroutines.flow.Flow

interface AlbumsRepository {
    suspend fun getAlbums(): Flow<Result<List<Album>>>
}