package com.lordoftherings.domain.models

data class MovieDomain(
    val academyAwardNominations: Int,
    val academyAwardWins: Int,
    val boxOfficeRevenueInMillions: Int,
    val budgetInMillions: Int,
    val name: String,
    val rottenTomatoesScore: Double,
    val runtimeInMinutes: Int
)