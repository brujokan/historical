package com.soma.bookstore.historical.infrastructure.messaging.order.create

import com.fasterxml.jackson.databind.ObjectMapper
import com.soma.bookstore.historical.application.use_case.order.create.OrderCreateUseCase
import com.soma.bookstore.historical.domain.mapper.Mapper
import com.soma.bookstore.historical.domain.model.Order
import com.soma.bookstore.historical.exception.MessagingObjectNotFoundException
import com.soma.bookstore.historical.infrastructure.messaging.order.model.OrderMessage
import mu.KotlinLogging
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class OrderCreateConsumer(
    private val orderCreateUseCase: OrderCreateUseCase,
    private val orderMessageMapper: Mapper<Order, OrderMessage>,
    private val objectMapper: ObjectMapper
) {

    private val logger = KotlinLogging.logger {  }

    @KafkaListener(topics = ["\${kafka.topic.create.order}"])
    fun create(message: String) {
        val messageObject: OrderMessage = objectMapper.readValue(message, OrderMessage::class.java)

        try {
            orderCreateUseCase.create(
                orderMessageMapper.map(messageObject)
            )
        } catch (ex: MessagingObjectNotFoundException) {
            logger.error { "Error saving order ${messageObject.id}: ${ex.message}" }
        }
    }
}