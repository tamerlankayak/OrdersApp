package com.example.ordersapp.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ordersapp.core.data.local.entities.ProductEntity

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(productEntity: ProductEntity)

    @Query("SELECT * FROM ProductEntity WHERE belongsToDeliverer = :delivererId")
    suspend fun getProductForDeliverer(delivererId: String): List<ProductEntity>
}