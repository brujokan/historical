package com.soma.bookstore.historical.infrastructure.persistence.repository.order

import com.soma.bookstore.historical.domain.mapper.Mapper
import com.soma.bookstore.historical.domain.model.Order
import com.soma.bookstore.historical.domain.model.Product
import com.soma.bookstore.historical.domain.model.User
import com.soma.bookstore.historical.domain.repository.OrderRepository
import com.soma.bookstore.historical.infrastructure.persistence.entity.OrderCollection
import com.soma.bookstore.historical.infrastructure.persistence.entity.ProductCollection
import com.soma.bookstore.historical.infrastructure.persistence.entity.UserCollection
import com.soma.bookstore.historical.infrastructure.persistence.jpa.OrderJPA
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryImpl(
    private val repositoryJPA: OrderJPA,
    private val collectionMapper: Mapper<OrderCollection, Order>,
    private val modelMapper: Mapper<Order, OrderCollection>,
    private val userCollectionMapper: Mapper<UserCollection, User>,
    private val productCollectionMapper: Mapper<ProductCollection, Product>
): OrderRepository {

    override fun save(order: Order) {
        repositoryJPA.save(collectionMapper.map(order))
    }

    override fun findById(id: String): Order? {
        return (
                repositoryJPA.findByIdOrNull(id) ?: null)?.let {
            modelMapper.map(
                it
            )
        }
    }

    override fun findByUser(user: User): List<Order> {
        return repositoryJPA.findByUser(
            userCollectionMapper.map(user)
        ).map(modelMapper::map)
    }

    override fun findByProduct(product: Product): List<Order> {
        return repositoryJPA.findByProduct(
            productCollectionMapper.map(product)
        ).map(modelMapper::map)
    }

    override fun findAll(): List<Order> {
        return repositoryJPA.findAll().map(modelMapper::map)
    }
}