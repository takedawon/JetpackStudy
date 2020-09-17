package com.example.study.data.local

import androidx.room.Dao
import androidx.room.Query

@Dao
interface TravelDao {
    @Query("SELECT * FROM travel")
    fun getAll(): List<TravelEntity>
}
