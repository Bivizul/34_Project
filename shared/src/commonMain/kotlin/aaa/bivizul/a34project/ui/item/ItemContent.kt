package aaa.bivizul.a34project.ui.item

import aaa.bivizul.a34project.ui.stoploswidget.Stoploscp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun ItemContent(
    component: ItemModel,
    modifier: Modifier = Modifier
) {

    val stoplosItemList by component.state.collectAsState()
    val model by component.models.subscribeAsState()
    val scrollState = rememberScrollState()

    if (stoplosItemList != null) {
        stoplosItemList?.let { list ->
            list[model.selectedStoplosItemId - 1].let { item ->
//                val stoplosinList = item.stoplosin
                Column(
                    modifier = modifier
                        .verticalScroll(scrollState)
                        .padding(8.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = item.stoplostit,
                        style = MaterialTheme.typography.h5
                    )
                    Text(
                        text = item.stoplosdesc,
                        style = MaterialTheme.typography.body1
                    )
//                    if (stoplosinList != emptyList<Stoplosin>()) {
//                        for (i in stoplosinList) {
//                            Text(
//                                text = i.stoplossubtitle,
//                                style = MaterialTheme.typography.h6
//                            )
//                            Text(
//                                text = i.stoplossubdesc,
//                                style = MaterialTheme.typography.body1
//                            )
//                        }
//                    }
                }
            }
        }
    } else {
        Stoploscp(modifier = modifier)
    }
}