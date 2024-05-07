package com.kdroid_consulting.domain.repository.usecase

import com.kdroid_consulting.domain.repository.AlbumsRepository

class GetAlbumsUseCase (
    private val repository: AlbumsRepository
) {
    suspend operator fun invoke() = repository.getAlbums()
}