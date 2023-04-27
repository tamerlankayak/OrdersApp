package com.example.ordersapp.core.domain.model

data class Order(
    val orderId: String,
    val date: String,
    val delivererTime: String,
    val delivererName: String,
    val products: List<BoughtProducts>
){}
