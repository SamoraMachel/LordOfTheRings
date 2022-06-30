package com.lordoftherings.domain.repository

import androidx.paging.PagingData
import com.lordoftherings.domain.models.BookDomain
import com.lordoftherings.domain.models.ChapterDomain
import com.lordoftherings.domain.models.Resource
import kotlinx.coroutines.flow.Flow


interface BookRepository {
    suspend fun fetchBooks(page: Int) : Resource<Flow<PagingData<BookDomain>>>

    suspend fun fetchSpecificBook(id: Int) : Resource<BookDomain>

    suspend fun fetchBookChapters(page: Int, id: Int) :Resource<Flow<PagingData<ChapterDomain>>>
}