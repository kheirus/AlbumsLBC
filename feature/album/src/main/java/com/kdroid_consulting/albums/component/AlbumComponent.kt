package com.kdroid_consulting.albums.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kdroid_consulting.domain.model.Album
import com.kdroid_consulting.domain.model.Song
import com.kdroid_consulting.feature.album.R
import com.kdroid_consulting.ds.theme.AlbumsLBCTheme

/**
 * An Album is a list of songs with the same albumId.
 */
@Composable
fun AlbumComponent(
    album: Album,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(
            text = stringResource(R.string.album_title, album.albumId),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
        LazyRow {
            itemsIndexed(
                items = album.songs,
                key = { index, song -> "${song.id}$index" }
            ) { _, song ->
                SongComponent(song)
            }
        }
    }
}

@Preview
@Composable
private fun AlbumComponentPreview() {
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
        val album = Album(albumId = 1, songs = songs)
        AlbumComponent(album)
    }
}