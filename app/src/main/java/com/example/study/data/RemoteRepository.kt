package com.example.study.data

import com.example.study.data.datasource.MemberDataSource
import com.example.study.network.response.MemberInfoResponse
import javax.inject.Inject

class RemoteRepositoryImpl(
    private val dataSource: MemberDataSource
):RemoteRepository {
    
    override fun getMemberInfo(): MemberInfoResponse {
        return dataSource.getMemberInfo()
    }
}

interface RemoteRepository {
    fun getMemberInfo():MemberInfoResponse
}