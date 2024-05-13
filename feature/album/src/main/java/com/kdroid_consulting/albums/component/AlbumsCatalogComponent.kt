package com.kdroid_consulting.albums.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kdroid_consulting.domain.model.Album
import com.kdroid_consulting.domain.model.Song
import com.kdroid_consulting.ds.theme.AlbumsLBCTheme

/**
 * A Catalog is a list of Album.
 */
@Composable
fun AlbumsCatalogComponent(
    albums: List<Album>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(vertical = 4.dp),
        contentPadding = PaddingValues(horizontal = 4.dp),
    ) {

        itemsIndexed(
            items = albums,
            key = { index, album -> "${album.albumId}$index" }
        ) { _, album ->
            AlbumComponent(album)
        }
    }
}

@Preview
@Composable
private fun AlbumCatalogComponentPreview() {
    AlbumsLBCTheme {
        val songs = listOf(
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
            ),
            Song(
                id = 3,
                title = "culpa odio esse rerum omnis laboriosam voluptate repudiandae",
                url = "https://via.placeholder.com/600/d32776",
                thumbnailUrl =  "https://via.placeholder.com/150/d32776"
            )
        )
        AlbumsCatalogComponent(
            listOf(
                Album(albumId = 0, songs = songs),
                Album(albumId = 1, songs = songs),
                Album(albumId = 2, songs = songs)
            )
        )
    }
}