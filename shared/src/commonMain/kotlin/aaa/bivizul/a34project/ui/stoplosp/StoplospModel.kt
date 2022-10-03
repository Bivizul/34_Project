package aaa.bivizul.a34project.ui.stoplosp

import aaa.bivizul.a34project.domain.model.Stoplosg
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface StoplospModel {

    val models: Value<Model>
    val state: StateFlow<Stoplosg?>

    fun onReplace()

    data class Model(
        val activity: Any
    )

}