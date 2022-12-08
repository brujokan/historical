package com.soma.bookstore.historical.domain.mapper

interface Mapper<T, V> {

    fun map(input: V): T
}