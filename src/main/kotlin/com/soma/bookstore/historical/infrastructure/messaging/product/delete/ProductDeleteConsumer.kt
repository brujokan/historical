package com.soma.bookstore.historical.infrastructure.messaging.product.delete

import com.fasterxml.jackson.databind.ObjectMapper
import com.soma.bookstore.historical.application.use_case.product.delete.ProductDeleteUseCase
import com.soma.bookstore.historical.infrastructure.messaging.product.model.ProductIdMessage
import mu.KotlinLogging
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ProductDeleteConsumer(
    private val deleteUseCase: ProductDeleteUseCase,
    private val objectMapper: ObjectMapper
) {

    private val logger = KotlinLogging.logger {  }

    @KafkaListener(topics = ["\${kafka.topic.delete.products}"])
    fun delete(message: String) {
        val messageObject: ProductIdMessage = objectMapper.readValue(message, ProductIdMessage::class.java)
        try {
            deleteUseCase.delete(messageObject.id)
        } catch (ex: Exception) {
            logger.error { "Cannot delete product ${ex.message}" }
        }

        logger.info { messageObject }
    }
}