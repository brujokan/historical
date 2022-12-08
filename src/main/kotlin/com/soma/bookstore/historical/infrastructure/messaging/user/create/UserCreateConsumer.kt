package com.soma.bookstore.historical.infrastructure.messaging.user.create

import com.fasterxml.jackson.databind.ObjectMapper
import com.soma.bookstore.historical.application.use_case.user.create.UserCreateUseCase
import com.soma.bookstore.historical.infrastructure.messaging.user.create.mapper.UserMessageMapper
import com.soma.bookstore.historical.infrastructure.messaging.user.model.UserMessage
import mu.KotlinLogging
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class UserCreateConsumer(
    private val userCreateUseCase: UserCreateUseCase,
    private val userMessageMapper: UserMessageMapper,
    private val objectMapper: ObjectMapper
) {

    private val logger = KotlinLogging.logger {  }
    @KafkaListener(topics = ["\${kafka.topic.create.users}"])
    fun create(message: String) {
        val messageObject: UserMessage = objectMapper.readValue(message, UserMessage::class.java)

        try {
            userCreateUseCase.create(
                userMessageMapper.map(messageObject)
            )
        } catch (ex: Exception) {
            logger.error { "Cannot save product ${ex.message}" }
        }

        logger.info { messageObject }
    }
}