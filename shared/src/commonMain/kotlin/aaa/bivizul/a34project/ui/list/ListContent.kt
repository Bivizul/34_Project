package aaa.bivizul.a34project.ui.list

import aaa.bivizul.a34project.ui.stoploswidget.StoplosButton
import aaa.bivizul.a34project.ui.stoploswidget.Stoploscp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListContent(
    component: ListModel,
    modifier: Modifier = Modifier
) {

    val stoplosItemList by component.state.collectAsState()

    if (stoplosItemList != null) {
        stoplosItemList?.let { list ->
            LazyColumn(
                modifier = modifier.padding(8.dp).fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.Start
            ) {
                items(list) { stoplosItem ->
                    StoplosButton(
                        onClick = { component.onClickListItemModel(id = stoplosItem.id) },
                        text = stoplosItem.stoplostit
                    )
                }
            }
        }
    } else {
        Stoploscp(modifier = modifier)
    }

}