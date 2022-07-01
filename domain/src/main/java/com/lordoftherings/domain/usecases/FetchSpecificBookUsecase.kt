package com.lordoftherings.domain.usecases

import com.lordoftherings.domain.models.BookDomain
import com.lordoftherings.domain.models.Resource
import com.lordoftherings.domain.repository.BookRepository
import javax.inject.Inject

class FetchSpecificBookUsecase @Inject constructor(private val bookRepository: BookRepository) {
    suspend operator fun invoke(params: Int): Resource<BookDomain> {
        return bookRepository.fetchSpecificBook(params)
    }
}