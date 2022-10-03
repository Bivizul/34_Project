package aaa.bivizul.a34project.ui.list

import aaa.bivizul.a34project.data.repository.StoplossRepository
import aaa.bivizul.a34project.domain.model.Stoploss
import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow

class ListComponent(
    componentContext: ComponentContext,
    stoplossRepository: StoplossRepository,
    private val onClickListItem: (id: Int) -> Unit,
) : ListModel, ComponentContext by componentContext {

    override val state: StateFlow<List<Stoploss>?> = stoplossRepository.stoplossList

    override fun onClickListItemModel(id: Int) {
        onClickListItem(id)
    }
}