package com.soma.bookstore.historical.infrastructure.persistence.repository.product

import com.soma.bookstore.historical.domain.mapper.Mapper
import com.soma.bookstore.historical.domain.model.Product
import com.soma.bookstore.historical.domain.repository.ProductRepository
import com.soma.bookstore.historical.infrastructure.persistence.entity.ProductCollection
import com.soma.bookstore.historical.infrastructure.persistence.jpa.ProductJPA
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class ProductRepositoryImpl(
    private val repositoryJPA: ProductJPA,
    private val collectionMapper: Mapper<ProductCollection, Product>,
    private val modelMapper: Mapper<Product, ProductCollection>
): ProductRepository {

    override fun save(product: Product) {
        repositoryJPA.save(collectionMapper.map(product))
    }

    override fun delete(id: String) = repositoryJPA.deleteById(id)

    override fun findById(id: String): Product? {
        return modelMapper.map(
            repositoryJPA.findByIdOrNull(id) ?: return null
        )
    }
}