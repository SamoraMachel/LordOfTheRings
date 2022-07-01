package com.lordoftherings.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.lordoftherings.data.remote.api.BookApi
import com.lordoftherings.data.remote.mappers.toDomain
import com.lordoftherings.data.remote.pagingsource.BookPagingData
import com.lordoftherings.domain.models.BookDomain
import com.lordoftherings.domain.models.ChapterDomain
import com.lordoftherings.domain.models.Resource
import com.lordoftherings.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import java.io.IOException
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val  api: BookApi
) : BookRepository {
    override suspend fun fetchBooks(page: Int): Resource<Flow<PagingData<BookDomain>>> {
        return try {
            val response = api.fetchBook(page)
            return when {
                response.isSuccessful -> {
                    val bookPagingData = BookPagingData(api)

                    return Resource.Success(data = Pager(
                        config = PagingConfig(1000),
                        pagingSourceFactory = {bookPagingData}
                    ).flow)
                }
                else -> {
                    Resource.Error(message = "Server Error")
                }
            }

        } catch (ioexception : IOException) {
            Resource.Error("Network Error: Kindly check your internet")
        } catch (exception: Exception) {
            Resource.Error(message = exception.message)
        }
    }

    override suspend fun fetchSpecificBook(id: Int): Resource<BookDomain> {
        return try {
            val response = api.fetchSpecificBook(id)
            return when {
                response.isSuccessful -> {
                    val bookData = response.body()!!
                    return Resource.Success(data = bookData.docs[0].toDomain())
                }
                else -> {
                    Resource.Error(message = "Server Error")
                }
            }

        } catch (ioexception: IOException) {
            Resource.Error("Network Error: Kindly check your internet")
        } catch (exception: Exception) {
            Resource.Error(message = exception.message)
        }
    }

    override suspend fun fetchBookChapters(page: Int, id: Int): Resource<Flow<PagingData<ChapterDomain>>> {
        TODO("Not yet implemented")
    }
}