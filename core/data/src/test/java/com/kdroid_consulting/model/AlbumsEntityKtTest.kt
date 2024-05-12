package com.kdroid_consulting.model

import com.kdroid_consulting.domain.model.Album
import com.kdroid_consulting.domain.model.Song
import org.junit.Assert.assertEquals
import org.junit.Test

class AlbumsMappingTest {

    private val songs = listOf(
        Song(
            id = 1,
            title = "accusamus beatae ad facilis cum similique qui sunt",
            url = "https://via.placeholder.com/600/92c952",
            thumbnailUrl =  "https://via.placeholder.com/150/92c952"
        ),
        Song(
            id = 2,
            title = "reprehenderit est deserunt velit ipsam",
            url = "https://via.placeholder.com/600/771796",
            thumbnailUrl =  "https://via.placeholder.com/600/771796"
        )
    )
    private val albumsDomain = listOf(
        Album(albumId = 10,
            songs = songs
        ),
        Album(albumId = 20,
            songs = songs
        )
    )

    private val albumsEntity = listOf(
        AlbumsEntity(
            id = 1,
            albumId = 10,
            title = "accusamus beatae ad facilis cum similique qui sunt",
            url = "https://via.placeholder.com/600/92c952",
            thumbnailUrl =  "https://via.placeholder.com/150/92c952"
        ),
        AlbumsEntity(
            id = 2,
            albumId = 10,
            title = "reprehenderit est deserunt velit ipsam",
            url = "https://via.placeholder.com/600/771796",
            thumbnailUrl =  "https://via.placeholder.com/600/771796"
        ),
        AlbumsEntity(
            id = 1,
            albumId = 20,
            title = "accusamus beatae ad facilis cum similique qui sunt",
            url = "https://via.placeholder.com/600/92c952",
            thumbnailUrl =  "https://via.placeholder.com/150/92c952"
        ),
        AlbumsEntity(
            id = 2,
            albumId = 20,
            title = "reprehenderit est deserunt velit ipsam",
            url = "https://via.placeholder.com/600/771796",
            thumbnailUrl =  "https://via.placeholder.com/600/771796"
        ),
    )

    private val albumData = AlbumData(
        albumId = 45,
        id = 123,
        title = "culpa odio esse rerum omnis laboriosam voluptate repudiandae",
        url = "https://via.placeholder.com/600/d32776",
        thumbnailUrl =  "https://via.placeholder.com/150/d32776"
    )

    private val albumEntity = AlbumsEntity(
        id = 123,
        albumId = 45,
        title = "culpa odio esse rerum omnis laboriosam voluptate repudiandae",
        url = "https://via.placeholder.com/600/d32776",
        thumbnailUrl =  "https://via.placeholder.com/150/d32776"
    )

    @Test
    fun `toDomainAlbums should map correctly the model from entity to domain`() {
        assertEquals(albumsEntity.toDomainAlbums(), albumsDomain)
    }

    @Test
    fun `toEntityAlbum should map correctly the model from data to entity`() {
        assertEquals(albumData.toEntityAlbum(), albumEntity)
    }

}