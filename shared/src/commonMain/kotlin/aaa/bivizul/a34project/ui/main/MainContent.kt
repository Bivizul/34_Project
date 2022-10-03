package aaa.bivizul.a34project.ui.main

import aaa.bivizul.a34project.domain.util.Stoploscon.STOPLOSAN
import aaa.bivizul.a34project.ui.stoploswidget.StoplosButton
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun MainContent(
    component: MainModel,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.padding(16.dp).fillMaxSize(),
    ) {
        Icon(
            imageVector = Icons.Filled.Settings,
            contentDescription = "Settings",
            modifier = modifier
                .clickable { component.onClickSettingsModel() }
                .align(Alignment.TopEnd),
        )
        Text(
            text = STOPLOSAN,
            modifier = modifier.align(Alignment.Center),
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Center
        )
        StoplosButton(
            modifier = modifier.align(Alignment.BottomCenter).padding(bottom = 32.dp),
            onClick = { component.onClickListModel() },
            text = "Begin"
        )
    }
}