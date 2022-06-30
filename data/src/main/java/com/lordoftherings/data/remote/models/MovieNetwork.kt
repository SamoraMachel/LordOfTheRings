package com.lordoftherings.data.remote.models

data class MovieNetwork(
    val _id: String,
    val academyAwardNominations: Int,
    val academyAwardWins: Int,
    val boxOfficeRevenueInMillions: Int,
    val budgetInMillions: Int,
    val name: String,
    val rottenTomatoesScore: Double,
    val runtimeInMinutes: Int
)