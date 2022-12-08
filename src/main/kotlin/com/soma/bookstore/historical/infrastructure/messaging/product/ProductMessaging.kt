package com.soma.bookstore.historical.infrastructure.messaging.product

import com.fasterxml.jackson.databind.ObjectMapper
import com.soma.bookstore.historical.application.use_case.product.create.ProductCreateUseCase
import com.soma.bookstore.historical.infrastructure.messaging.product.mapper.ProductMessageMapper
import com.soma.bookstore.historical.infrastructure.messaging.product.model.ProductMessage
import mu.KotlinLogging
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ProductMessaging(
    private val createUseCase: ProductCreateUseCase,
    private val productMapper: ProductMessageMapper,
    private val objectMapper: ObjectMapper
) {

    private val logger = KotlinLogging.logger {  }

    @KafkaListener(topics = ["\${kafka.topic.create.products}"])
    fun create(message: String) {
        val messageObject: ProductMessage = objectMapper.readValue(message, ProductMessage::class.java)
        try {
            createUseCase.save(
                productMapper.map(messageObject)
            )
        } catch (ex: Exception) {
            logger.error { "Cannot save product ${ex.message}" }
        }

        logger.info { messageObject }
    }
}