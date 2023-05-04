package com.example.ordersapp.order_feature.di

import com.example.ordersapp.core.data.local.DelivererDao
import com.example.ordersapp.core.data.local.OrderDao
import com.example.ordersapp.core.data.local.ProductDao
import com.example.ordersapp.order_feature.data.repository.OrderRepositoryImpl
import com.example.ordersapp.order_feature.domain.repository.OrderRepository
import com.example.ordersapp.order_feature.domain.use_case.ConfirmOrderUseClass
import com.example.ordersapp.order_feature.domain.use_case.FilterListByNameUseCase
import com.example.ordersapp.order_feature.domain.use_case.SortListByNameUseCase
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

    @Provides
    @Singleton
    fun provideFilterListByNameUseCase(): FilterListByNameUseCase {
        return FilterListByNameUseCase()
    }

    @Provides
    @Singleton
    fun provideSortListByNameUseCase(): SortListByNameUseCase {
        return SortListByNameUseCase()
    }

    @Provides
    @Singleton
    fun provideConfirmOrderUseCase(orderRepository: OrderRepository): ConfirmOrderUseClass {
        return ConfirmOrderUseClass(orderRepository)
    }
}