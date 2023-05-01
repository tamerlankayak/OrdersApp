package com.example.ordersapp.deliverer_feature.data.mapper

import com.example.ordersapp.core.data.local.entities.ProductEntity
import com.example.ordersapp.core.domain.model.Product

fun Product.toProductEntity(delivererId:String): ProductEntity {
    return ProductEntity(
        productId = productId,
        name = name,
        pricePerAmount = pricePerAmount,
        belongsToDeliverer = delivererId
    )
}