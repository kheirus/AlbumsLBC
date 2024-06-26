package com.kdroid_consulting.data.repository

import com.kdroid_consulting.model.AlbumData

val fakeDataAlbums = listOf(
    AlbumData(
        albumId = 1,
        id = 1,
        title = "accusamus beatae ad facilis cum similique qui sunt",
        url = "https://via.placeholder.com/600/92c952",
        thumbnailUrl =  "https://via.placeholder.com/150/92c952"
    ),
    AlbumData(
        albumId = 1,
        id = 2,
        title = "reprehenderit est deserunt velit ipsam",
        url = "https://via.placeholder.com/600/771796",
        thumbnailUrl =  "https://via.placeholder.com/600/771796"
    ),
    AlbumData(
        albumId = 1,
        id = 3,
        title = "culpa odio esse rerum omnis laboriosam voluptate repudiandae",
        url = "https://via.placeholder.com/600/d32776",
        thumbnailUrl =  "https://via.placeholder.com/150/d32776"
    )
)

val errorCode = listOf(400..499, 500..599).flatMap { it.toList() }.random()