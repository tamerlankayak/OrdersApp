package com.example.ordersapp.core.domain.model

data class BoughtProducts(
    val productId: String,
    val name: String,
    val pricePerAmount: Float,
    val amount: Int
)
