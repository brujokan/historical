package com.soma.bookstore.historical.infrastructure.persistence.repository.user.mapper

import com.soma.bookstore.historical.domain.mapper.Mapper
import com.soma.bookstore.historical.domain.model.User
import com.soma.bookstore.historical.infrastructure.persistence.entity.UserCollection
import org.springframework.stereotype.Component

@Component
class UserCollectionMapper: Mapper<UserCollection, User> {

    override fun map(input: User): UserCollection {
        return UserCollection(
            id = input.id,
            name = input.name,
            surname = input.surname,
            secondSurname = input.secondSurname,
            email = input.email
        )
    }
}