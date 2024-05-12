package com.kdroid_consulting.model

import com.kdroid_consulting.domain.model.Album
import com.kdroid_consulting.domain.model.Song
import kotlinx.serialization.Serializable

@Serializable
data class AlbumData (
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)

fun List<AlbumData>.toDomainAlbums(): List<Album> {
    return this
        .groupBy { it.albumId }
        .map { (albumId, albumDataList) ->
            val songs = albumDataList.map { songData ->
                Song(
                    id = songData.id,
                    title = songData.title,
                    url = songData.url,
                    thumbnailUrl = songData.thumbnailUrl
                )
            }

            Album(albumId = albumId, songs = songs)
        }
}

fun AlbumData.toEntityAlbum(): AlbumsEntity {
    return AlbumsEntity(
        albumId = albumId,
        id = id,
        title = title,
        url = url,
        thumbnailUrl = thumbnailUrl
    )
}