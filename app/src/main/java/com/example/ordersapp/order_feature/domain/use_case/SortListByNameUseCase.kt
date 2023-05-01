package com.example.ordersapp.order_feature.domain.use_case

import com.example.ordersapp.core.domain.SelectedAndSortByName

class SortListByNameUseCase {
    operator fun <T> invoke(list: List<T>): List<T> where T : SelectedAndSortByName {
        return list.sortedBy { item ->
            item.name
        }
    }
}