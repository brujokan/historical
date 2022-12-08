package com.soma.bookstore.historical.infrastructure.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "user")
data class UserCollection(
    @Id
    val id: String,
    val name: String,
    val surname: String,
    val secondSurname: String?,
    val email: String,
    val order: List<OrderCollection>? = null
)