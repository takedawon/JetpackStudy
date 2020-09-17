package com.example.study.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.study.data.RemoteRepository
import com.example.study.network.response.MemberInfoResponse

class TestViewModel @ViewModelInject constructor(
    private val remoteRepository: RemoteRepository
) : ViewModel() {

    private val _memberData = MutableLiveData<MemberInfoResponse>()
    val memberData = _memberData
}
