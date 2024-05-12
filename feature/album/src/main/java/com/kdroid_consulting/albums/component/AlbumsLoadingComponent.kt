package com.kdroid_consulting.albums.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kdroid_consulting.ds.theme.AlbumsLBCTheme

@Composable
fun AlbumsLoadingComponent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()
    }
}

@Preview
@Composable
private fun AlbumsLoadingComponentPreview() {
    AlbumsLBCTheme{
        AlbumsLoadingComponent(Modifier)
    }
}