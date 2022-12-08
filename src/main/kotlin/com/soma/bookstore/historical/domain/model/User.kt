package com.soma.bookstore.historical.domain.model

data class User(
    val id: String,
    val name: String,
    val surname: String,
    val secondSurname: String?,
    val email: String,
    val order: List<Order>? = null
)
