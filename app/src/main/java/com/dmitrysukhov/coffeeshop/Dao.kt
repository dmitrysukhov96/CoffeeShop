package com.dmitrysukhov.coffeeshop

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoffee(coffee: Coffee)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBeans(beans: Beans)

    @Delete
    suspend fun deleteCoffee(coffee: Coffee)

    @Delete
    suspend fun deleteBeans(beans: Beans)

    @Query("SELECT * FROM cart")
    suspend fun getAllCartItems(): List<Any>
}
