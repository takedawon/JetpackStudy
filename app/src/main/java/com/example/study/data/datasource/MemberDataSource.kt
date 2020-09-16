package com.example.study.data.datasource

import com.example.study.network.response.MemberInfoResponse
import com.example.study.network.service.TravelService

class MemberDataSourceImpl:MemberDataSource {
    override fun getMemberInfo(): MemberInfoResponse {
        return MemberInfoResponse(
            name = "다원",
            nickname = "lanic",
            age = 26,
            gender = "남자"
        )
    }


}

interface MemberDataSource {
    fun getMemberInfo():MemberInfoResponse
}