package com.lordoftherings.data.remote.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.lordoftherings.data.remote.api.BookApi
import com.lordoftherings.data.remote.mappers.toDomain
import com.lordoftherings.domain.models.BookDomain
import java.io.IOException
import javax.inject.Inject

class BookPagingData @Inject constructor( private val apiService : BookApi) : PagingSource<Int, BookDomain>() {
    override fun getRefreshKey(state: PagingState<Int, BookDomain>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BookDomain> {
        val position = params.key ?: 1

        return try {
            val response = apiService.fetchBook(position)
            val dataList: List<BookDomain> = if(response.isSuccessful) {
                response.body()!!.docs.map{
                    it.toDomain()
                }
            } else {
                listOf<BookDomain>()
            }

            val nextKey = if(dataList.isEmpty()) {
                null
            } else {
                position + (params.loadSize / 1000)
            }

            LoadResult.Page(
                data = dataList,
                prevKey = if (position == 1) null else (position - 1),
                nextKey = nextKey
            )
        } catch (e : Exception) {
            LoadResult.Error(e)
        } catch (e : IOException) {
            LoadResult.Error(e)
        }
    }
}