package com.lordoftherings.data.remote.models

data class MovieDto(
    val _id: String,
    val academyAwardNominations: Int,
    val academyAwardWins: Int,
    val boxOfficeRevenueInMillions: Int,
    val budgetInMillions: Int,
    val name: String,
    val rottenTomatoesScore: Double,
    val runtimeInMinutes: Int
)