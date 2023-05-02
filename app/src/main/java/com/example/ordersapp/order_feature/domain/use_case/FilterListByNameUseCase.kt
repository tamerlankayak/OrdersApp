package com.example.ordersapp.order_feature.domain.use_case

import com.example.ordersapp.core.domain.SelectedAndSortByName

class FilterListByNameUseCase {
    operator fun <T> invoke(list: List<T>, name: String): List<T> where T : SelectedAndSortByName {
        return list.filter { item ->
            item.name.lowercase().contains(name.lowercase())
        }
    }
}