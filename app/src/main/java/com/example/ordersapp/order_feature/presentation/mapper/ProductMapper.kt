package com.example.ordersapp.order_feature.presentation.mapper

import com.example.ordersapp.order_feature.presentation.domain.model.BoughtProducts
import com.example.ordersapp.order_feature.presentation.state.ProductListItem

fun BoughtProducts.toProductListItem(): ProductListItem {
    return ProductListItem(
        id = productId,
        name = name,
        pricePerAmount = pricePerAmount,
        selectedAmount = amount,
        isExpanded = false
    )
}