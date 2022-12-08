package com.soma.bookstore.historical.infrastructure.messaging.user.create.mapper

import com.soma.bookstore.historical.domain.mapper.Mapper
import com.soma.bookstore.historical.domain.model.User
import com.soma.bookstore.historical.infrastructure.messaging.user.model.UserMessage
import org.springframework.stereotype.Component

@Component
class UserMessageMapper: Mapper<User, UserMessage> {

    override fun map(input: UserMessage): User {
        return User(
            id = input.id.toString(),
            name = input.name,
            surname = input.surname,
            secondSurname = input.secondSurname,
            email = input.email
        )
    }
}