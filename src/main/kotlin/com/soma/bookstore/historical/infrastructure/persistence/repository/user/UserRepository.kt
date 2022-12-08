package com.soma.bookstore.historical.infrastructure.persistence.repository.user

import com.soma.bookstore.historical.domain.mapper.Mapper
import com.soma.bookstore.historical.domain.model.User
import com.soma.bookstore.historical.domain.repository.UserRepository
import com.soma.bookstore.historical.infrastructure.persistence.entity.UserCollection
import com.soma.bookstore.historical.infrastructure.persistence.jpa.UserJPA
import org.springframework.stereotype.Repository

@Repository
class UserRepository(
    private val repositoryJPA: UserJPA,
    private val collectionMapper: Mapper<UserCollection, User>
): UserRepository {

    override fun save(user: User) {
        repositoryJPA.save(collectionMapper.map(user))
    }

    override fun delete(id: String) = repositoryJPA.deleteById(id)
}