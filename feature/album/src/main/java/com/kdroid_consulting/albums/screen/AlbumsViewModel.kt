package com.kdroid_consulting.albums.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kdroid_consulting.common.Result
import com.kdroid_consulting.domain.model.Album
import com.kdroid_consulting.domain.usecase.GetAlbumsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel @Inject constructor(
    private val getAlbumsUseCase: GetAlbumsUseCase
) : ViewModel() {

    private var _albumsState = MutableStateFlow<AlbumsUiState>(AlbumsUiState.Loading)
    val albumsState = _albumsState.asStateFlow()

    init {
        viewModelScope.launch {
            getAlbumsUseCase().collect { result ->
                _albumsState.update {
                    when (result) {
                        is Result.Failure -> AlbumsUiState.Failure
                        is Result.Success -> AlbumsUiState.Success(result.data)
                        is Result.Loading -> AlbumsUiState.Loading
                    }
                }
            }
        }
    }
}

sealed interface AlbumsUiState {
    data class Success(val albums: List<Album>) : AlbumsUiState
    data object Failure : AlbumsUiState
    data object Loading : AlbumsUiState
}