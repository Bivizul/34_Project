package aaa.bivizul.a34project.ui.item

import aaa.bivizul.a34project.domain.model.Stoploss
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

interface ItemModel {

    val models: Value<Model>

    val state: StateFlow<List<Stoploss>?>

    data class Model(
        val selectedStoplosItemId: Int
    )

}