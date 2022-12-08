package com.soma.bookstore.historical.domain.model

import java.sql.Timestamp

data class Order(
    val id: String,
    val user: User,
    val purchaseDate: Timestamp,
    val promotionId: Long?,
    val price: Float,
    val product: Product,
)
