package com.example.ordersapp.order_feature.di

import com.example.ordersapp.core.data.local.DelivererDao
import com.example.ordersapp.core.data.local.OrderDao
import com.example.ordersapp.core.data.local.ProductDao
import com.example.ordersapp.order_feature.data.repository.OrderRepositoryImpl
import com.example.ordersapp.order_feature.domain.repository.OrderRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OrderFeatureModule {

    @Provides
    @Singleton
    fun providerOrderRepository(
        orderDao: OrderDao,
        delivererDao: DelivererDao,
        productDao: ProductDao
    ): OrderRepository {
        return OrderRepositoryImpl(orderDao, delivererDao, productDao)
    }
}