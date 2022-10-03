package aaa.bivizul.a34project.ui.stoploswidget

import aaa.bivizul.a34project.domain.util.Stoploscon
import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import coil.compose.AsyncImage

@Composable
actual fun Stoplosibl() {

    val betstratorient = LocalConfiguration.current.orientation
    val betstratImgModel = when (betstratorient) {
        Configuration.ORIENTATION_PORTRAIT -> Stoploscon.STOPLOSBV
        else -> Stoploscon.STOPLOSBH
    }

    AsyncImage(
        model = betstratImgModel,
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
    )

}