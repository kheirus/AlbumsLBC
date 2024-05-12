package com.kdroid_consulting.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kdroid_consulting.domain.model.Album
import com.kdroid_consulting.domain.model.Song

@Entity(tableName = "albums_table")
data class AlbumsEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    val albumId: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)

fun List<AlbumsEntity>.toDomainAlbums(): List<Album> {
    return this
        .groupBy { it.albumId }
        .map { (albumId, albumDataList) ->
            val songs = albumDataList.map { entity ->
                Song(
                    id = entity.id,
                    title = entity.title,
                    url = entity.url,
                    thumbnailUrl = entity.thumbnailUrl
                )
            }

            Album(albumId = albumId, songs = songs)
        }
}
