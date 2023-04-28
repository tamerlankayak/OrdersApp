package com.example.ordersapp.core.data.mapper

import com.example.ordersapp.core.data.local.entities.DelivererEntity
import com.example.ordersapp.core.domain.model.Deliverer
import com.example.ordersapp.core.domain.model.Product

fun DelivererEntity.toDeliver(products: List<Product>): Deliverer {
    return Deliverer(
        delivererId = delivererId,
        name = name,
        products = products
    )
}