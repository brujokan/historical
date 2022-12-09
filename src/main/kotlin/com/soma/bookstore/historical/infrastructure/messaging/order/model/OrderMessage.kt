package com.soma.bookstore.historical.infrastructure.messaging.order.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.sql.Timestamp

data class OrderMessage(
    @JsonProperty("id")
    val id: Long,
    @JsonProperty("user_id")
    val userId: Long,
    @JsonProperty("purchase_date")
    val purchaseDate: Timestamp,
    @JsonProperty("promotion_id")
    val promotionId: Long?,
    @JsonProperty("price")
    val price: Float,
    @JsonProperty("product_id")
    val productId: String
)
