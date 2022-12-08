package com.soma.bookstore.historical.infrastructure.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "payment_detail")
data class PaymentDetailCollection(
    @Id
    val id: String,
    val creditNumber: Long,
    val expirationMonth: String,
    val expirationYear: String,
    val cvv: String
)
