package com.lordoftherings.domain.repository

import androidx.paging.PagingData
import com.lordoftherings.domain.models.MovieDomain
import com.lordoftherings.domain.models.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun fetchMovies(page: Int) : Flow<Resource<PagingData<MovieDomain>>>

    suspend fun fetchSpecificMovie(id: Int) : Resource<MovieDomain>

//    suspend fun fetchMovieQuotes(page: Int) : List<QuoteDomain>
}