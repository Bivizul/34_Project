package aaa.bivizul.a34project.ui.root

import aaa.bivizul.a34project.ui.stoplosp.StoplospModel
import aaa.bivizul.a34project.ui.item.ItemModel
import aaa.bivizul.a34project.ui.list.ListModel
import aaa.bivizul.a34project.ui.main.MainModel
import aaa.bivizul.a34project.ui.settings.SettingsModel
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface RootModel {

    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        class StoplospChild(val component: StoplospModel) : Child()
        class MainChild(val component: MainModel) : Child()
        class ListChild(val component: ListModel) : Child()
        class ItemChild(val component: ItemModel) : Child()
        class SettingsChild(val component: SettingsModel) : Child()
    }

}