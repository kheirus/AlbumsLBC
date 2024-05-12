package com.kdroid_consulting.albums.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.kdroid_consulting.domain.model.Song
import com.kdroid_consulting.feature.album.R
import com.kdroid_consulting.ui.theme.AlbumsLBCTheme
import com.kdroid_consulting.ui.toUrlWithHeader

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SongComponent(
    song: Song,
    modifier: Modifier = Modifier
) {
    Column(modifier
        .padding(8.dp),
    ) {
        GlideImage(
            model = song.url.toUrlWithHeader(),
            modifier = Modifier
                .height(120.dp)
                .width(120.dp),
            failure = placeholder(R.drawable.placeholder),
            contentDescription = song.title
        )
        Text(
            text = song.title,
            maxLines = 2,
            modifier = Modifier
                .width(120.dp),
            overflow = TextOverflow.Ellipsis
        )
    }
}


@Preview
@Composable
private fun SongComponentPreview() {
    AlbumsLBCTheme {
        val song = Song(
            id = 3,
            title = "culpa odio esse rerum omnis laboriosam voluptate repudiandae",
            url = "https://via.placeholder.com/600/d32776",
            thumbnailUrl =  "https://via.placeholder.com/150/d32776"
        )
        SongComponent(song)
    }
}