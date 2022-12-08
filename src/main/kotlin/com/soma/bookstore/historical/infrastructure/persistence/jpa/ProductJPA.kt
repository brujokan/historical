package com.soma.bookstore.historical.infrastructure.persistence.jpa

import com.soma.bookstore.historical.infrastructure.persistence.entity.ProductCollection
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductJPA: MongoRepository<ProductCollection, String>