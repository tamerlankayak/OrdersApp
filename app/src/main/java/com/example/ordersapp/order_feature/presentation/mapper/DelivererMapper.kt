package com.example.ordersapp.order_feature.presentation.mapper

import com.example.ordersapp.core.domain.model.Deliverer
import com.example.ordersapp.order_feature.presentation.state.DelivererListItem

fun Deliverer.toDelivererListItem(): DelivererListItem {
    return DelivererListItem(
        delivererId = delivererId,
        name = name
    )
}