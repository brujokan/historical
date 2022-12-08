package com.soma.bookstore.historical.application.use_case.product.delete

import com.soma.bookstore.historical.domain.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductDeleteUseCase(
    private val repository: ProductRepository
) {

    fun delete(id: String) = repository.delete(id)
}