package com.example.study.data

import com.example.study.data.datasource.MemberDataSource
import com.example.study.network.response.MemberInfoResponse
import com.example.study.network.response.TravelResponse
import com.example.study.network.service.TravelService
import retrofit2.http.Query
import javax.inject.Inject

class RemoteRepositoryImpl(
    private val travelService: TravelService
):RemoteRepository {
    override fun getTravelInfo(
        serviceKey: String,
        numOfRows: Int,
        pageNo: String,
        mobileOS: String,
        mobileApp: String,
        arrange: String,
        contentTypeId: String,
        mapX: String,
        mapY: String,
        radius: String,
        listYN: String
    ): TravelResponse {
        return travelService.getTravelInfo(serviceKey, numOfRows, pageNo, mobileOS, mobileApp, arrange, contentTypeId, mapX, mapY)
    }


}

interface RemoteRepository {
    fun getTravelInfo(
        serviceKey:String,
        numOfRows:Int= 10,
        pageNo:String,
        mobileOS:String = "AND",
        mobileApp:String = "TEST",
        arrange:String,
        contentTypeId:String = "15",
        mapX:String,
        mapY:String,
        radius:String = "1000",
        listYN:String = "Y"
    ):TravelResponse
}