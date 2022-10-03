package aaa.bivizul.a34project.data.repository

import aaa.bivizul.a34project.data.network.StoplosApi
import aaa.bivizul.a34project.domain.model.Stoploss
import aaa.bivizul.a34project.domain.util.stoplosIoDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StoplossRepository {

    private val stoplosApi = StoplosApi()
    private val stoplosjob = SupervisorJob()
    private val stoplosscope = CoroutineScope(stoplosIoDispatcher + stoplosjob)

    private val _stoplosItemList = MutableStateFlow<List<Stoploss>?>(null)
    val stoplossList: StateFlow<List<Stoploss>?> = _stoplosItemList.asStateFlow()

    init {
        getStoplosItem()
    }

    fun getStoplosItem() {
        stoplosscope.launch {
            val response = stoplosApi.getStoplosItem()
            _stoplosItemList.emit(response)
        }
    }

}