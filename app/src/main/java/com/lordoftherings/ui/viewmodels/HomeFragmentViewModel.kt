package com.lordoftherings.ui.viewmodels

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class HomeFragmentViewModel {

    private var mutableBookList : MutableStateFlow<BookState> = MutableStateFlow(BookState.StandBy)
    val bookList : StateFlow<BookState> get() = mutableBookList.asStateFlow()

    private fun getBookList() {

    }



    sealed class BookState {
        data class Success<T>(val data : T) : BookState()

        data class Empty<T>(val data: T) : BookState()

        data class Failure(val message: String) : BookState()

        object Loading : BookState()

        object StandBy : BookState()
    }
}