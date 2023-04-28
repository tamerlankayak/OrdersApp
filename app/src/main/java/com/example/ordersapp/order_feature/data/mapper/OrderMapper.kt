package com.example.ordersapp.order_feature.data.mapper

import com.example.ordersapp.core.data.local.entities.OrderEntity
import com.example.ordersapp.order_feature.domain.model.Order

fun Order.toOrderEntity(delivererName: String): OrderEntity {
    return OrderEntity(
        orderId = orderId,
        date = date,
        delivererTime = delivererTime,
        delivererName = delivererName
    )
}