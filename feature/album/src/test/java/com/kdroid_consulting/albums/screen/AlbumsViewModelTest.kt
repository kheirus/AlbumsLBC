package com.kdroid_consulting.albums.screen

import com.kdroid_consulting.common.Result
import com.kdroid_consulting.domain.model.Album
import com.kdroid_consulting.domain.model.Song
import com.kdroid_consulting.domain.usecase.GetAlbumsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class AlbumsViewModelTest {
    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private var useCase: GetAlbumsUseCase = mockk()

    private lateinit var viewModel: AlbumsViewModel

    private val albumsResult = listOf(
        Album(
            albumId = 10,
            songs = listOf(
                Song(
                    id = 89,
                    title = "accusamus beatae ad facilis cum similique qui sunt",
                    url = "https://via.placeholder.com/600/92c952",
                    thumbnailUrl =  "https://via.placeholder.com/150/92c952"
                )
            ),
        )
    )

    private fun initViewModel() {
        viewModel = AlbumsViewModel(useCase)
    }

    @Test
    fun `should return Loading state`() = runTest {
        coEvery { useCase.invoke() } returns flowOf(Result.Loading)

        initViewModel()

        assertEquals(viewModel.albumsState.value, AlbumsUiState.Loading)
    }

    @Test
    fun `should return Failure state`() = runTest {
        coEvery { useCase.invoke() } returns flowOf(Result.Failure(Exception("Error")))

        initViewModel()

        assertEquals(viewModel.albumsState.value, AlbumsUiState.Failure)
    }

    @Test
    fun `should return Success state`() = runTest {
        coEvery { useCase.invoke() } returns flowOf(Result.Success(albumsResult))

        initViewModel()

        assert(viewModel.albumsState.value is AlbumsUiState.Success)
        assertEquals(viewModel.albumsState.value, AlbumsUiState.Success(albumsResult))
    }
}

