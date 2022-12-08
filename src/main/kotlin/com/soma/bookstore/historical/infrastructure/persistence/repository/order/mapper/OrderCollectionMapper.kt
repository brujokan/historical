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
class OrderCollectionMapper(
    private val productMapper: Mapper<ProductCollection, Product>,
    private val userMapper: Mapper<UserCollection, User>
): Mapper<OrderCollection, Order> {

    override fun map(input: Order): OrderCollection {
        return OrderCollection(
            id = input.id,
            user = userMapper.map(input.user),
            purchaseDate = input.purchaseDate,
            promotionId = input.promotionId,
            price = input.price,
            product = productMapper.map(input.product)
        )
    }
}