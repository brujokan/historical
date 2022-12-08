package com.soma.bookstore.historical.infrastructure.persistence.repository.order.mapper

import com.soma.bookstore.historical.domain.mapper.Mapper
import com.soma.bookstore.historical.domain.model.Order
import com.soma.bookstore.historical.domain.model.Product
import com.soma.bookstore.historical.domain.model.User
import com.soma.bookstore.historical.infrastructure.persistence.entity.OrderCollection
import com.soma.bookstore.historical.infrastructure.persistence.entity.ProductCollection
import com.soma.bookstore.historical.infrastructure.persistence.entity.UserCollection
import org.springframework.stereotype.Component

@Component
class OrderModelMapper(
    private val productMapper: Mapper<Product, ProductCollection>,
    private val userMapper: Mapper<User, UserCollection>
): Mapper<Order, OrderCollection> {

    override fun map(input: OrderCollection): Order {
        return Order(
            id = input.id,
            user = userMapper.map(input.user),
            purchaseDate = input.purchaseDate,
            promotionId = input.promotionId,
            price = input.price,
            product = productMapper.map(input.product)
        )
    }
}