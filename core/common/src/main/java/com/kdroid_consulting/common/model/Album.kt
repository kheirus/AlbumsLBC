package com.kdroid_consulting.common.model

import kotlinx.serialization.Serializable

@Serializable
data class Album (
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)