package com.soma.bookstore.historical.infrastructure.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.sql.Timestamp

@Document(collection = "order")
data class OrderCollection(
    @Id
    val id: String,
    val user: UserCollection,
    val purchaseDate: Timestamp,
    val promotionId: Long?,
    val price: Float,
    val product: ProductCollection,
)
