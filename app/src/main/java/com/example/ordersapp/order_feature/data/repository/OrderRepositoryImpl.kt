package com.example.ordersapp.order_feature.data.repository

import com.example.ordersapp.core.data.local.DelivererDao
import com.example.ordersapp.core.data.local.OrderDao
import com.example.ordersapp.core.data.local.ProductDao
import com.example.ordersapp.core.data.local.entities.OrderProductEntity
import com.example.ordersapp.core.data.mapper.toDeliver
import com.example.ordersapp.core.data.mapper.toProduct
import com.example.ordersapp.core.domain.model.Deliverer
import com.example.ordersapp.core.domain.model.Product
import com.example.ordersapp.order_feature.data.mapper.toOrder
import com.example.ordersapp.order_feature.data.mapper.toOrderEntity
import com.example.ordersapp.order_feature.presentation.domain.model.Order
import com.example.ordersapp.order_feature.presentation.domain.repository.OrderRepository
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val orderDao: OrderDao,
    private val delivererDao: DelivererDao,
    private val productDao: ProductDao
) : OrderRepository {
    override suspend fun insertOrder(order: Order) {
        orderDao.insertOrder(order.toOrderEntity(order.delivererName))
        val orderProductEntities = order.products.map { boughtProducts ->
            OrderProductEntity(order.orderId, boughtProducts.productId, boughtProducts.amount)
        }
        orderDao.insertOrderProductEntities(orderProductEntities)
    }

    override suspend fun getOrders(): List<Order> {
        return orderDao.getOrderWithProducts().map {
            it.toOrder()
        }
    }

    override suspend fun getDeliverers(): List<Deliverer> {
        return delivererDao.getDeliverers().map {
            it.delivererEntity.toDeliver(
                it.products.map { productEntity ->
                    productEntity.toProduct()
                }
            )
        }
    }

    override suspend fun getProductsForDeliverer(delivererId: String): List<Product> {
        return productDao.getProductForDeliverer(delivererId).map { productEntity ->
            productEntity.toProduct()
        }
    }

    override suspend fun getDelivererNameById(delivererId: String): String {
        return delivererDao.getDelivererNamesById(delivererId)
    }
}