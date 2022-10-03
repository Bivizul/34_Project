package aaa.bivizul.a34project.data.repository

import aaa.bivizul.a34project.data.network.StoplosApi
import aaa.bivizul.a34project.domain.model.Stoplos
import aaa.bivizul.a34project.domain.model.Stoplosg
import aaa.bivizul.a34project.domain.util.stoplosIoDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StoplosRepository {

    private val stoplosApi = StoplosApi()
    private val stoplosjob = SupervisorJob()
    private val stoplosscope = CoroutineScope(stoplosIoDispatcher + stoplosjob)

    private val _stoplosg = MutableStateFlow<Stoplosg?>(null)
    val stoplosg: StateFlow<Stoplosg?> = _stoplosg.asStateFlow()

    fun getStoplosg(stoplos: Stoplos) {
        stoplosscope.launch {
            val response = stoplosApi.getStoplosg(stoplos)
            _stoplosg.emit(response)
        }
    }

}