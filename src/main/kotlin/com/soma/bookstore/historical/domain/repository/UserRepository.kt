package com.soma.bookstore.historical.domain.repository

import com.soma.bookstore.historical.domain.model.User

interface UserRepository {

    fun save(user: User)

    fun delete(id: String)
}