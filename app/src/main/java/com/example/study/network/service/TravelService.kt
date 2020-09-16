
package com.example.study.network.service

import com.example.study.network.response.TravelResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TravelService {

    @GET("rest/KorService/locationBasedList")
    suspend fun getTravelInfo(
        @Query("serviceKey") serviceKey: String,
        @Query("numOfRows") numOfRows: Int = 10,
        @Query("pageNo") pageNo: String,
        @Query("MobileOS") mobileOS: String = "AND",
        @Query("MobileApp") mobileApp: String = "TEST",
        @Query("arrange") arrange: String,
        @Query("contentTypeId") contentTypeId: String = "15",
        @Query("mapX") mapX: String,
        @Query("mapY") mapY: String,
        @Query("radius") radius: String = "1000",
        @Query("listYN") listYN: String = "Y",
        @Query("_type") type: String = "json"
    ): TravelResponse
}
