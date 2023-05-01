package com.example.ordersapp.deliverer_feature.domain.repository

import com.example.ordersapp.core.domain.model.Deliverer
import com.example.ordersapp.core.domain.model.Product

interface DelivererRepository {

    suspend fun insertDeliverers(list:List<Deliverer>)

    suspend fun insertProducts(list:List<Product>, delivererId:String)

}