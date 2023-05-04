package com.example.ordersapp.deliverer_feature.data.mapper

import com.example.ordersapp.core.data.local.entities.DelivererEntity
import com.example.ordersapp.core.domain.model.Deliverer

//clean architecture for mapping objects
fun Deliverer.toDelivererEntity(): DelivererEntity {
    return DelivererEntity(
        delivererId = delivererId,
        name = name
    )
}