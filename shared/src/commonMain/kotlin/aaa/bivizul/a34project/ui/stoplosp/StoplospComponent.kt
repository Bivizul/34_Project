package aaa.bivizul.a34project.ui.stoplosp

import aaa.bivizul.a34project.data.repository.StoplosRepository
import aaa.bivizul.a34project.domain.model.Stoplos
import aaa.bivizul.a34project.domain.model.Stoplosg
import aaa.bivizul.a34project.domain.util.*
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow

class StoplospComponent(
    componentContext: ComponentContext,
    context: Any,
    stoplosRepository: StoplosRepository,
    private val onReplaceToMain: () -> Unit
) : StoplospModel, ComponentContext by componentContext {

    private val _models = MutableValue(StoplospModel.Model(activity = context))
    override val models: Value<StoplospModel.Model> = _models
    override val state: StateFlow<Stoplosg?> = stoplosRepository.stoplosg

    init {
        try {
            stoplosRepository.getStoplosg(
                Stoplos(
                    getStoplosmm(),
                    getStoplossim(context),
                    getStoplosid(context),
                    getStoplosl(),
                    getStoplost()
                )
            )
        } catch (e: Exception) {
            getStoplosdlg(context)
        }
    }

    override fun onReplace() {
        onReplaceToMain()
    }

}