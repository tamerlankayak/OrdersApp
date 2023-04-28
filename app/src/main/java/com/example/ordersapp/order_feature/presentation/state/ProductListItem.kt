package com.example.ordersapp.order_feature.presentation.state

import dagger.multibindings.IntoMap

data class ProductListItem(
    val id: String,
    val name: String,
    val pricePerAmount: Float,
    val selectedAmount: Int,
    val isExpanded: Boolean
)
