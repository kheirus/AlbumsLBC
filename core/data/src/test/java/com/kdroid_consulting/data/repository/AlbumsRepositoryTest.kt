package com.kdroid_consulting.data.repository

import com.kdroid_consulting.common.Result
import com.kdroid_consulting.data.api.AlbumsApi
import com.kdroid_consulting.data.dao.AlbumsDao
import com.kdroid_consulting.model.toDomainAlbums
import com.kdroid_consulting.model.toEntityAlbum
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class AlbumsRepositoryTest {

    @MockK
    private lateinit var api: AlbumsApi
    @MockK
    private lateinit var dao: AlbumsDao

    @InjectMockKs
    private lateinit var repository: AlbumsRepositoryImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `getAlbums should return list of album from API when cache is EMPTY`() = runTest{
        coEvery { dao.getAll() } returns emptyList()
        coEvery { api.getAlbums() } returns Response.success(fakeDataAlbums)
        coEvery {
            fakeDataAlbums.map {
                dao.insert(  it.toEntityAlbum() )
            }
        }
        coEvery { dao.getAll() } returns fakeDataAlbums.map { it.toEntityAlbum()}

        val result = repository
            .getAlbums()
            .first()

        assert(result is Result.Success)
        assertEquals(
            (result as Result.Success).data,
            fakeDataAlbums.toDomainAlbums()
        )
    }

    @Test
    fun `getAlbums should return list of album from cache when cache is NOT EMPTY`() = runTest{
        coEvery { dao.getAll() } returns fakeDataAlbums.map { it.toEntityAlbum()}

        val result = repository
            .getAlbums()
            .first()
        assert(result is Result.Success)
        assertEquals(
            (result as Result.Success).data,
            fakeDataAlbums.toDomainAlbums()
        )
    }

    @Test
    fun `getAlbums should return Failure when cache is EMPTY and API call FAILS`() = runTest{
        coEvery { dao.getAll() } returns emptyList()
        coEvery { api.getAlbums() } returns Response.error(errorCode, "Error".toResponseBody())

        val result = repository
            .getAlbums()
            .first()

        assert((result is Result.Failure))
    }
}