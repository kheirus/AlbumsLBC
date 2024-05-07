package com.kdroid_consulting.albums

import androidx.lifecycle.ViewModel
import com.kdroid_consulting.domain.repository.usecase.GetAlbumsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel @Inject constructor(
    private val getAlbumsUseCase: GetAlbumsUseCase
) : ViewModel() {
}