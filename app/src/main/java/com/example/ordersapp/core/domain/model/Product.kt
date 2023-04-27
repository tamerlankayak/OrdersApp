package com.example.ordersapp.core.domain.model

data class Product(
    val productId: String,
    val name: String,
    val pricePerAmount: Float
) {}