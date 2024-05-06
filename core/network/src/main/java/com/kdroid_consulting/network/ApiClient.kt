package com.kdroid_consulting.network

import android.app.Application
import android.util.Log
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

interface ApiClient {
    fun <S> createService(serviceClass: Class<S>): S
}

class ApiClientImpl(private val appContext: Application): ApiClient {

    override fun <S> createService(serviceClass: Class<S>): S {
        return retrofitBuilder.client(provideOkHttpClient())
            .build()
            .create(serviceClass)
    }

    private val retrofitBuilder: Retrofit.Builder by lazy {
        val json = Json {
            isLenient = true
            ignoreUnknownKeys = true
            encodeDefaults = true
            coerceInputValues = true
        }
        Retrofit.Builder()
            .baseUrl("https://static.leboncoin.fr/img/shared/technical-test.json")
            .addConverterFactory(
                json.asConverterFactory("application/json".toMediaType()),
            )

    }

    private fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor { message -> Log.w("OkHttp", message) }

        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .addNetworkInterceptor(logging)
            .build()
    }
}

class AuthInterceptor : Interceptor {

    private val cacheControl = CacheControl.Builder().maxAge(8, TimeUnit.HOURS).build() // 8 hours

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .cacheControl(cacheControl)
            .addHeader("User-Agent", "Android")

        return chain.proceed(request.build())
    }
}
