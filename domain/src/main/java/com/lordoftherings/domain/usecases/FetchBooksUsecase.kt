package com.lordoftherings.domain.usecases

import androidx.paging.PagingData
import com.lordoftherings.domain.models.BookDomain
import com.lordoftherings.domain.models.Resource
import com.lordoftherings.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchBooksUsecase @Inject constructor(private val bookRepository: BookRepository) {
    suspend operator fun invoke(params: Int): Resource<Flow<PagingData<BookDomain>>> {
        return bookRepository.fetchBooks(params)
    }
}