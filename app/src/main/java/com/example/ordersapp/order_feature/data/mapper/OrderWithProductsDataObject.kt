package com.example.ordersapp.order_feature.data.mapper

import com.example.ordersapp.core.data.local.entities.OrderWithProductsDataObject
import com.example.ordersapp.order_feature.domain.model.BoughtProducts
import com.example.ordersapp.order_feature.domain.model.Order

fun OrderWithProductsDataObject.toOrder(): Order {
    return Order(
        orderId = orderEntity.orderId,
        date = orderEntity.date,
        delivererName = orderEntity.delivererName,
        delivererTime = orderEntity.delivererTime,
        products = products.zip(orderProductEntities).map { pair ->
            BoughtProducts(
                pair.component1().productId,
                pair.component1().name,
                pair.component1().pricePerAmount,
                pair.component2().amount
            )
        }
    )
}