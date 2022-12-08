package com.soma.bookstore.historical.application.use_case.user.delete

import com.soma.bookstore.historical.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserDeleteUseCase(
    private val repository: UserRepository
) {

    fun delete(id: String) = repository.delete(id)
}