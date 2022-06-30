package com.lordoftherings.mappers

import com.lordoftherings.domain.models.BookDomain
import com.lordoftherings.models.BookPresentation
import com.lordoftherings.shared.Constants
import kotlin.random.Random
import kotlin.random.nextInt

fun BookDomain.toPresenter() : BookPresentation {
    val imageIndex = Random.nextInt(Constants.LIST_OF_BOOK_IMAGES.size)

    return BookPresentation(
        Constants.LIST_OF_BOOK_IMAGES[imageIndex],
        name
    )
}