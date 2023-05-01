package com.example.ordersapp.core.domain.model

import com.example.ordersapp.core.domain.SelectedAndSortByName

data class Product(
    val productId: String,
    override val name: String,
    val pricePerAmount: Float
):SelectedAndSortByName