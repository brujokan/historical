package com.soma.bookstore.historical.infrastructure.persistence.jpa

import com.soma.bookstore.historical.infrastructure.persistence.entity.OrderCollection
import com.soma.bookstore.historical.infrastructure.persistence.entity.ProductCollection
import com.soma.bookstore.historical.infrastructure.persistence.entity.UserCollection
import org.springframework.data.mongodb.repository.MongoRepository

interface OrderJPA: MongoRepository<OrderCollection, String> {

    fun findByUser(user: UserCollection): List<OrderCollection>

    fun findByProduct(product: ProductCollection): List<OrderCollection>
}