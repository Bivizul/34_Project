package aaa.bivizul.a34project.ui.list

import aaa.bivizul.a34project.domain.model.Stoploss
import kotlinx.coroutines.flow.StateFlow

interface ListModel {

    val state: StateFlow<List<Stoploss>?>

    fun onClickListItemModel(id: Int)

}