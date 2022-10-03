package aaa.bivizul.a34project.ui.item

import aaa.bivizul.a34project.data.repository.StoplossRepository
import aaa.bivizul.a34project.domain.model.Stoploss
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

class ItemComponent(
    componentContext: ComponentContext,
    stoplossRepository: StoplossRepository,
    stoplosItemId: Int,
) : ItemModel, ComponentContext by componentContext {

    private val _models = MutableValue(ItemModel.Model(selectedStoplosItemId = stoplosItemId))
    override val models: Value<ItemModel.Model> = _models

    override val state: StateFlow<List<Stoploss>?> =
        stoplossRepository.stoplossList

}