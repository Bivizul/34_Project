package aaa.bivizul.a34project.domain.util

import kotlin.coroutines.CoroutineContext

internal expect val stoplosIoDispatcher: CoroutineContext
internal expect val stoplosUiDispatcher: CoroutineContext

internal expect fun getStoplosmm(): String
internal expect fun getStoplossim(stoploscon: Any): String
internal expect fun getStoplosid(stoploscon: Any): String
internal expect fun getStoplosl(): String
internal expect fun getStoplost(): String
internal expect fun getStoplosdlg(stoploscon: Any)
internal expect fun checkStoplosnet(stoploscon: Any): Boolean
internal expect fun sigStoplosoff()
internal expect fun getStoplosactoff(stoploscon: Any)
internal expect fun stoplosct(stoploscon: Any, stoploscc: String)