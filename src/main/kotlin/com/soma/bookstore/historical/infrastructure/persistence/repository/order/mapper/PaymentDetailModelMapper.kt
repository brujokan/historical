package com.soma.bookstore.historical.infrastructure.persistence.repository.order.mapper

import com.soma.bookstore.historical.domain.mapper.Mapper
import com.soma.bookstore.historical.domain.model.PaymentDetail
import com.soma.bookstore.historical.infrastructure.persistence.entity.PaymentDetailCollection
import org.springframework.stereotype.Component

@Component
class PaymentDetailModelMapper: Mapper<PaymentDetail, PaymentDetailCollection> {

    override fun map(input: PaymentDetailCollection): PaymentDetail {
        return PaymentDetail(
            creditNumber = input.creditNumber,
            expirationMonth = input.expirationMonth,
            expirationYear = input.expirationYear,
            cvv = input.cvv,
            id = input.id
        )
    }
}