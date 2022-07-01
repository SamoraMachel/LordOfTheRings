package com.lordoftherings.data.remote.mappers

import com.lordoftherings.data.remote.models.BookDto
import com.lordoftherings.domain.models.BookDomain

fun BookDto.toDomain() = BookDomain(
    name
)