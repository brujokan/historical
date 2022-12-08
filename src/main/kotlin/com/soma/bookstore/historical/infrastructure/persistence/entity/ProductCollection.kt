package com.soma.bookstore.historical.infrastructure.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "product")
data class ProductCollection(
    @Id
    val id: String,
    val title: String,
    val language: String,
    val idNumber: String,
    val author: String,
    val category: String
)