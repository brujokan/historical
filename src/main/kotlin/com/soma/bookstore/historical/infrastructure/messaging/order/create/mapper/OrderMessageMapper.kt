package com.soma.bookstore.historical.infrastructure.messaging.order.create.mapper

import com.soma.bookstore.historical.application.use_case.product.find.ProductFindUseCase
import com.soma.bookstore.historical.application.use_case.user.find.UserFindUseCase
import com.soma.bookstore.historical.domain.mapper.Mapper
import com.soma.bookstore.historical.domain.model.Order
import com.soma.bookstore.historical.infrastructure.messaging.order.model.OrderMessage
import org.springframework.stereotype.Component

@Component
class OrderMessageMapper(
    private val userUseCase: UserFindUseCase,
    private val productUseCase: ProductFindUseCase
): Mapper<Order, OrderMessage> {

    override fun map(input: OrderMessage): Order {
        return Order(
            id = input.id.toString(),
            user = userUseCase.find(input.userId.toString()),
            purchaseDate = input.purchaseDate,
            promotionId = input.promotionId,
            price = input.price,
            product = productUseCase.find(input.productId)
        )
    }
}