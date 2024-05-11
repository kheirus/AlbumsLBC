package com.kdroid_consulting.data.di

import com.kdroid_consulting.data.api.AlbumsApi
import com.kdroid_consulting.data.repository.AlbumsRepositoryImpl
import com.kdroid_consulting.domain.repository.AlbumsRepository
import com.kdroid_consulting.domain.usecase.GetAlbumsUseCase
import com.kdroid_consulting.network.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AlbumsModule {

    @Provides
    @Singleton
    fun provideAlbumsRepository(client: ApiClient): AlbumsRepository {
        val api = client.createService(AlbumsApi::class.java)
        return AlbumsRepositoryImpl(api)
    }

    @Provides
    fun provideGetAlbumsUseCase(repository: AlbumsRepository) = GetAlbumsUseCase(repository)

}