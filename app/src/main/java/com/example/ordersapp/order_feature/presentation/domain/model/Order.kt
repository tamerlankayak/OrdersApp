package com.example.ordersapp.order_feature.presentation.domain.model

data class Order(
    val orderId: String,
    val date: String,
    val delivererTime: String,
    val delivererName: String,
    val products: List<BoughtProducts>
)
