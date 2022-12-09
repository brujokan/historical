package com.soma.bookstore.historical.application.use_case.order.create

import com.soma.bookstore.historical.domain.model.Order
import com.soma.bookstore.historical.domain.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderCreateUseCase(
    private val repository: OrderRepository
) {

    fun create(order: Order) {
        repository.save(order)
    }
}