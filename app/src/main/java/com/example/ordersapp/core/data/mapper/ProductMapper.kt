package com.example.ordersapp.core.data.mapper

import com.example.ordersapp.core.data.local.entities.ProductEntity
import com.example.ordersapp.core.domain.model.Product

fun ProductEntity.toProduct(): Product {
    return Product(
        productId = productId,
        name = name,
        pricePerAmount = pricePerAmount
    )
}