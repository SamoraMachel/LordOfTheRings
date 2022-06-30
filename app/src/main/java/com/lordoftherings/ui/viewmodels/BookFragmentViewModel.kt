package com.lordoftherings.ui.viewmodels

import androidx.paging.PagingData
import com.lordoftherings.domain.models.BookDomain
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class BookFragmentViewModel {

    var mutableBookList : MutableStateFlow<BookState> = MutableStateFlow(BookState.StandBy)
    val bookList : StateFlow<BookState> get() = mutableBookList.asStateFlow()

    sealed class BookState {
        data class Success<T>(val data : T) : BookState()

        data class Empty<T>(val data: T) : BookState()

        data class Failure(val message: String) : BookState()

        object Loading : BookState()

        object StandBy : BookState()
    }
}