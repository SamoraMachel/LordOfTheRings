package com.lordoftherings.domain.repository

import androidx.paging.PagingData
import com.lordoftherings.domain.models.CharacterDomain
import com.lordoftherings.domain.models.Resource
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun fetchCharacters(page : Int) : Flow<Resource<PagingData<CharacterDomain>>>

    suspend fun fetchSpecificCharacter(id : Int) : Resource<CharacterDomain>
}