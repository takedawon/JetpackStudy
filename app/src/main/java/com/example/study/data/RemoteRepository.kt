package com.example.study.data

import android.view.KeyEvent
import com.example.study.data.datasource.MemberDataSource
import com.example.study.network.response.MemberInfoResponse
import com.example.study.network.response.TravelResponse
import com.example.study.network.service.TravelService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
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
        listYN: String,
        type:String
    ): Flow<TravelResponse.Response.Body.Items> {
        return flow {
            emit(
                travelService.getTravelInfo(
                    serviceKey = serviceKey,
                    pageNo = pageNo,
                    arrange = arrange,
                    mapY = mapY,
                    mapX = mapX
                )
                    .response.body.items
            )
        }.flowOn(Dispatchers.IO)
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
        listYN:String = "Y",
        type:String = "json"
    ): Flow<TravelResponse.Response.Body.Items>
}