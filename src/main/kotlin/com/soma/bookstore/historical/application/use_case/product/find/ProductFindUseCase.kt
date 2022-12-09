package com.soma.bookstore.historical.application.use_case.product.find

import com.soma.bookstore.historical.domain.model.Product
import com.soma.bookstore.historical.domain.repository.ProductRepository
import com.soma.bookstore.historical.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class ProductFindUseCase(
    private val repository: ProductRepository
) {

    fun find(id: String): Product {
        return repository.findById(id) ?: throw NotFoundException("Product with id $id not found")
    }
}