package com.soma.bookstore.historical.application.use_case.product.create

import com.soma.bookstore.historical.domain.model.Product
import com.soma.bookstore.historical.domain.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductCreateUseCase(
    private val repository: ProductRepository
) {

    fun save(product: Product) = repository.save(product)
}