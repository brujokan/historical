package com.soma.bookstore.historical.infrastructure.persistence.repository.user

import com.soma.bookstore.historical.domain.mapper.Mapper
import com.soma.bookstore.historical.domain.model.User
import com.soma.bookstore.historical.domain.repository.UserRepository
import com.soma.bookstore.historical.infrastructure.persistence.entity.UserCollection
import com.soma.bookstore.historical.infrastructure.persistence.jpa.UserJPA
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class UserRepository(
    private val repositoryJPA: UserJPA,
    private val collectionMapper: Mapper<UserCollection, User>,
    private val modelMapper: Mapper<User, UserCollection>
): UserRepository {

    override fun save(user: User) {
        repositoryJPA.save(collectionMapper.map(user))
    }

    override fun delete(id: String) = repositoryJPA.deleteById(id)
    override fun findById(id: String): User? {
        return modelMapper.map(
            repositoryJPA.findByIdOrNull(id) ?: return null
        )
    }
}