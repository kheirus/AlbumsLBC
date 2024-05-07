package com.kdroid_consulting.data.api

import com.kdroid_consulting.common.model.Album
import retrofit2.Response
import retrofit2.http.GET


interface AlbumsApi {
    @GET("technical-test.json")
    suspend fun getAlbums(): Response<List<Album>>
}