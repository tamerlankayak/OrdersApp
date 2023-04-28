package com.example.ordersapp.order_feature.domain.repository

import com.example.ordersapp.core.domain.model.Deliverer
import com.example.ordersapp.core.domain.model.Product
import com.example.ordersapp.order_feature.domain.model.Order

interface OrderRepository {

    suspend fun insertOrder(order: Order)

    suspend fun getOrders(): List<Order>

    suspend fun getDeliverers(): List<Deliverer>

    suspend fun getProductsForDeliverer(delivererId: String): List<Product>

    suspend fun getDelivererNameById(delivererId: String): String
}