package com.dmitrysukhov.coffeeshop

import androidx.room.Dao

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoffee(coffee: Coffee)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBeans(beans: Beans)
}