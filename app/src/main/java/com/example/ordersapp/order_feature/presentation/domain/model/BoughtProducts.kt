package com.example.ordersapp.order_feature.presentation.domain.model

data class BoughtProducts(
    val productId: String,
    val name: String,
    val pricePerAmount: Float,
    val amount: Int
)
