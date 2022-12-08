package com.soma.bookstore.historical.application.use_case.user.create

import com.soma.bookstore.historical.domain.model.User
import com.soma.bookstore.historical.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserCreateUseCase(
    private val repository: UserRepository
) {

    fun create(user: User) = repository.save(user)
}