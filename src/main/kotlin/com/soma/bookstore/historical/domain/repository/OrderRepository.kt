package com.soma.bookstore.historical.domain.repository

import com.soma.bookstore.historical.domain.model.Order
import com.soma.bookstore.historical.domain.model.Product
import com.soma.bookstore.historical.domain.model.User

interface OrderRepository {

    fun save(order: Order)

    fun findById(id: String): Order?

    fun findByUser(user: User): List<Order>

    fun findByProduct(product: Product): List<Order>

    fun findAll(): List<Order>
}