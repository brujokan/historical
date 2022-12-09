package com.soma.bookstore.historical.domain.repository

import com.soma.bookstore.historical.domain.model.Product

interface ProductRepository {

    fun save(product: Product)

    fun delete(id: String)

    fun findById(id: String): Product?
}