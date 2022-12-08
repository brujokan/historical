package com.soma.bookstore.historical.domain.model

data class PaymentDetail(
    val id: String,
    val creditNumber: Long,
    val expirationMonth: String,
    val expirationYear: String,
    val cvv: String
)