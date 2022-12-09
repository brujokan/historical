package com.soma.bookstore.historical.application.use_case.user.find

import com.soma.bookstore.historical.domain.model.User
import com.soma.bookstore.historical.exception.MessagingObjectNotFoundException
import com.soma.bookstore.historical.exception.NotFoundException
import com.soma.bookstore.historical.infrastructure.persistence.repository.user.UserRepository
import org.springframework.stereotype.Service

@Service
class UserFindUseCase(
    private val repository: UserRepository
) {

    fun find(id: String): User {
        return repository.findById(id) ?: throw MessagingObjectNotFoundException("User with id $id not found")
    }
}