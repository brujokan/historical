package com.soma.bookstore.historical.infrastructure.persistence.repository.product.mapper

import com.soma.bookstore.historical.domain.mapper.Mapper
import com.soma.bookstore.historical.domain.model.Product
import com.soma.bookstore.historical.infrastructure.persistence.entity.ProductCollection
import org.springframework.stereotype.Component

@Component
class ProductCollectionMapper: Mapper<ProductCollection, Product> {

    override fun map(input: Product): ProductCollection {
        return ProductCollection(
            id = input.id,
            title = input.title,
            language = input.language,
            idNumber = input.idNumber,
            author = input.author,
            category = input.category
        )
    }
}