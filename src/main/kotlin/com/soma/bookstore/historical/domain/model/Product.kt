package com.soma.bookstore.historical.domain.model

data class Product(
    val id: String,
    val title: String,
    val language: String,
    val idNumber: String,
    val author: String,
    val category: String
)