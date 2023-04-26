package com.example.ordersapp.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.ordersapp.core.data.local.entities.DelivererEntity
import com.example.ordersapp.core.data.local.entities.DelivererWithProductsDataObject

@Dao
interface DelivererDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeliverer(delivererEntity: DelivererEntity)

    @Transaction
    @Query("SELECT * FROM DelivererEntity")
    suspend fun getDeliverers(): List<DelivererWithProductsDataObject>

    @Query("SELECT name FROM DelivererEntity WHERE delivererId = :delivererId")
    suspend fun getDelivererNamesById(delivererId: String): String
}