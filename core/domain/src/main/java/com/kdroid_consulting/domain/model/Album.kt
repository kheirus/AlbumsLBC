package com.kdroid_consulting.domain.model

data class Album (
    val albumId: Int,
    val songs: List<Song>
)

data class Song (
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)