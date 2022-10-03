package aaa.bivizul.a34project.ui.stoplosp

import aaa.bivizul.a34project.domain.model.Stoplosvar
import aaa.bivizul.a34project.domain.util.getStoplosactoff
import aaa.bivizul.a34project.domain.util.sigStoplosoff
import aaa.bivizul.a34project.ui.stoploswidget.Stoploscp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import kotlinx.coroutines.delay

@Composable
fun StoplospContent(
    component: StoplospModel,
    modifier: Modifier = Modifier
) {

    val stoplosg by component.state.collectAsState()
    val model by component.models.subscribeAsState()

    LaunchedEffect(key1 = true) {
        delay(3000)
        stoplosg?.stoplosg?.let {
            if (it == Stoplosvar.SLNO.sl) {
                component.onReplace()
            } else if (it == Stoplosvar.SLNP.sl) {
                sigStoplosoff()
                component.onReplace()
            } else {
//                stoplosct(model.activity, it)
                getStoplosactoff(model.activity)
            }
        }
    }
    Stoploscp(modifier = modifier)
}