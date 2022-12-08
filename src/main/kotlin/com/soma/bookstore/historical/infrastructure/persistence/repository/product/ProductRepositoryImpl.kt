package com.soma.bookstore.historical.infrastructure.persistence.repository.product

import com.soma.bookstore.historical.domain.mapper.Mapper
import com.soma.bookstore.historical.domain.model.Product
import com.soma.bookstore.historical.domain.repository.ProductRepository
import com.soma.bookstore.historical.infrastructure.persistence.entity.ProductCollection
import com.soma.bookstore.historical.infrastructure.persistence.jpa.ProductJPA
import org.springframework.stereotype.Repository

@Repository
class ProductRepositoryImpl(
    private val repositoryJPA: ProductJPA,
    private val collectionMapper: Mapper<ProductCollection, Product>
): ProductRepository {

    override fun save(product: Product) {
        repositoryJPA.save(collectionMapper.map(product))
    }

    override fun delete(id: String) = repositoryJPA.deleteById(id)
}