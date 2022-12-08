package com.soma.bookstore.historical.infrastructure.messaging.product.mapper

import com.soma.bookstore.historical.domain.mapper.Mapper
import com.soma.bookstore.historical.domain.model.Product
import com.soma.bookstore.historical.infrastructure.messaging.product.model.ProductMessage
import org.springframework.stereotype.Component

@Component
class ProductMessageMapper: Mapper<Product, ProductMessage> {

    override fun map(input: ProductMessage): Product {
        return Product(
            id = input.id,
            title = input.title,
            idNumber = input.idNumber,
            language = input.language,
            author = input.author,
            category = input.category
        )
    }
}