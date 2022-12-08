package com.soma.bookstore.historical.infrastructure.persistence.jpa

import com.soma.bookstore.historical.infrastructure.persistence.entity.UserCollection
import org.springframework.data.mongodb.repository.MongoRepository

interface UserJPA: MongoRepository<UserCollection, String>