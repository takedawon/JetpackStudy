package com.example.study.ui

import android.net.Uri
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.study.data.RemoteRepository
import com.example.study.network.response.TravelResponse
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

class TravelViewModel @ViewModelInject constructor(
    private val remoteRepository: RemoteRepository
) : ViewModel() {

    private val _travelData = MutableLiveData<TravelResponse.Response.Body.Items>()
    val travelData = _travelData

    init {
        getTravelData()
    }

    private fun getTravelData() {
        viewModelScope.launch {
            remoteRepository.getTravelInfo(
                serviceKey = Uri.decode("5QyVwm0GQxAdvNdc%2BRHjoLPF07dmzuYnQi%2F2BiMLpPQtGwPItZolkz4GLA4PPiS7pgTGKhGBhn5GHi8t9WRcnQ%3D%3D"),
                pageNo = "1",
                arrange = "A",
                mapX = "126.981611",
                mapY = "37.568477"
            ).catch { throwable ->
                Timber.e("테스트 : $throwable")
            }.collect {
                Timber.d("테스트 결과 : $it")
                _travelData.value = it
            }
        }
    }
}
