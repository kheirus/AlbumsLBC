package com.kdroid_consulting.domain.usecase

import com.kdroid_consulting.common.Result
import com.kdroid_consulting.domain.repository.AlbumsRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetAlbumsUseCaseTest {

    @MockK
    private lateinit var repository: AlbumsRepository

    @InjectMockKs
    private lateinit var useCase: GetAlbumsUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `should return the list of album when the call to the repository SUCCEEDS`() = runTest {
        coEvery { repository.getAlbums() } returns flowOf(Result.Success((fakeDomainAlbums)))
        val result = useCase.invoke().first()

        assert(result is Result.Success)
        assertEquals((result as Result.Success).data, fakeDomainAlbums)
    }

    @Test
    fun `should return FAILURE when the call to the repository FAILS`() = runTest {
        coEvery { repository.getAlbums() } returns flowOf(Result.Failure(Exception("Error")))
        val result = useCase.invoke().first()

        assert(result is Result.Failure)
    }
}

