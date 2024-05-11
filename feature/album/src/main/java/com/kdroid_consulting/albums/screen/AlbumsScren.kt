package com.kdroid_consulting.albums.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kdroid_consulting.albums.component.AlbumsCatalogComponent
import com.kdroid_consulting.albums.component.AlbumsErrorComponent
import com.kdroid_consulting.albums.component.AlbumsLoadingComponent

@Composable
fun AlbumsScreen(
    viewModel: AlbumsViewModel = hiltViewModel()
) {
    val state by viewModel.albumsState.collectAsStateWithLifecycle()

    when(state){
        AlbumsUiState.Failure -> AlbumsErrorComponent()
        AlbumsUiState.Loading -> AlbumsLoadingComponent()
        is AlbumsUiState.Success -> AlbumsCatalogComponent((state as AlbumsUiState.Success).albums)
    }
}







