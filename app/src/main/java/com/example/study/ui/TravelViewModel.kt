package com.example.study.ui

import android.net.Uri
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.study.data.RemoteRepository
import com.example.study.data.local.TravelDao
import com.example.study.network.response.TravelResponse
import com.example.study.util.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class TravelViewModel @ViewModelInject constructor(
    private val remoteRepository: RemoteRepository,
    private val dao: TravelDao
) : ViewModel() {

    private val _travelData = MutableLiveData<TravelResponse.Response.Body.Items>()
    val travelData = _travelData

    private val _goToOrderDetails = MutableLiveData<Event<Unit>>()
    val goToOrderDetails: LiveData<Event<Unit>>
        get() = _goToOrderDetails

    private val _daram = MutableLiveData<Event<Unit>>()
    val daram: LiveData<Event<Unit>> = _daram

    private val _a = MutableLiveData<Event<Unit>>()
    val a: LiveData<Event<Unit>> = _a

    private val _b = MutableLiveData<Event<Unit>>()
    val b: LiveData<Event<Unit>> = _b

    private val _c = MutableLiveData<Event<Unit>>()
    val c: LiveData<Event<Unit>> = _c

    val liveDataList = listOf(_goToOrderDetails, _daram, _a, _b, _c)


    val menuList= listOf<String>("메뉴","다람","커흑","커스텀뷰","무엇")

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
                withContext(Dispatchers.Default) {
                    it.item.forEach { data ->
                        dao.insert(data)
                        Timber.d("여행 정보 : $data")
                    }
                }
            }
        }
    }
}
