package com.soma.bookstore.historical.infrastructure.persistence.repository.user.mapper

import com.soma.bookstore.historical.domain.mapper.Mapper
import com.soma.bookstore.historical.domain.model.User
import com.soma.bookstore.historical.infrastructure.persistence.entity.UserCollection
import org.springframework.stereotype.Component

@Component
class UserModelMapper: Mapper<User, UserCollection> {

    override fun map(input: UserCollection): User {
        return User(
            id = input.id,
            name = input.name,
            surname = input.surname,
            secondSurname = input.secondSurname,
            email = input.email
        )
    }
}