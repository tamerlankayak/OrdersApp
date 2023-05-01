package com.example.ordersapp.core.domain.model

import com.example.ordersapp.core.domain.SelectedAndSortByName

data class Deliverer(
    val delivererId: String,
    override val name: String,
    val products: List<Product>
) : SelectedAndSortByName