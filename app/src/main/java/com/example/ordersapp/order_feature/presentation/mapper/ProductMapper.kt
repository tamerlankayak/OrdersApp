package com.example.ordersapp.order_feature.presentation.mapper

import com.example.ordersapp.core.domain.model.Product
import com.example.ordersapp.order_feature.domain.model.BoughtProducts
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

fun Product.toProductListItem(): ProductListItem {
    return ProductListItem(
        id = productId,
        name = name,
        pricePerAmount = pricePerAmount,
        selectedAmount = 0,
        isExpanded = false
    )
}

fun ProductListItem.toBoughtProduct(): BoughtProducts {
    return BoughtProducts(
        productId = id,
        name = name,
        pricePerAmount = pricePerAmount,
        amount = selectedAmount
    )
}
