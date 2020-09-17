package com.example.study.data.local

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TravelDao {
    @Query("SELECT * FROM travel")
    fun getAll(): Flow<List<TravelEntity>>

    fun insertTravelData()
}
