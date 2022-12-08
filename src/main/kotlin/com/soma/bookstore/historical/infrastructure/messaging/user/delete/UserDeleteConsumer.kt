package com.soma.bookstore.historical.infrastructure.messaging.user.delete

import com.fasterxml.jackson.databind.ObjectMapper
import com.soma.bookstore.historical.application.use_case.user.delete.UserDeleteUseCase
import com.soma.bookstore.historical.infrastructure.messaging.user.model.UserIdMessage
import mu.KotlinLogging
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class UserDeleteConsumer(
    private val userDeleteUseCase: UserDeleteUseCase,
    private val objectMapper: ObjectMapper
) {

    private val logger = KotlinLogging.logger {  }
    @KafkaListener(topics = ["\${kafka.topic.delete.users}"])
    fun delete(message: String) {
        val messageObject: UserIdMessage = objectMapper.readValue(message, UserIdMessage::class.java)
        try {
            userDeleteUseCase.delete(messageObject.id.toString())
        } catch (ex: Exception) {
            logger.error { "Cannot delete user ${ex.message}" }
        }
    }
}