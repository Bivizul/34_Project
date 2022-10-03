@file:Suppress("DEPRECATION")

package aaa.bivizul.a34project.domain.util

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.telephony.TelephonyManager
import androidx.browser.customtabs.CustomTabsIntent
import com.onesignal.OneSignal
import kotlinx.coroutines.Dispatchers
import java.text.SimpleDateFormat
import java.util.*
import kotlin.coroutines.CoroutineContext

actual val stoplosUiDispatcher: CoroutineContext = Dispatchers.Main

actual val stoplosIoDispatcher: CoroutineContext = Dispatchers.IO

actual fun getStoplosmm(): String {
    val manfacstoplos = android.os.Build.MANUFACTURER
    val modelstoplos = android.os.Build.MODEL
    return "$manfacstoplos $modelstoplos"
}

actual fun getStoplossim(stoploscon: Any): String {
    val context = stoploscon as Context
    val telmanstoplos = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return telmanstoplos.simCountryIso
}

actual fun getStoplosid(stoploscon: Any): String {
    val context = stoploscon as Context
    val sharedPreferences = context.getSharedPreferences("appprefstoplos", Context.MODE_PRIVATE)
    var stoplosid = sharedPreferences.getString("stoplos_key", "nostoplos") ?: "nostoplos"
    if (stoplosid == "nostoplos") {
        val dateNow = Date()
        val simpleDateFormat = SimpleDateFormat("yyMMddhhmmssMs")
        val datetime = simpleDateFormat.format(dateNow)
        val randomNum = (10000 until 100000).random()
        stoplosid = datetime + randomNum
        sharedPreferences.edit().putString("stoplos_key", stoplosid).apply()
    }
    return stoplosid
}

actual fun getStoplosl(): String {
    return Locale.getDefault().language
}

actual fun getStoplost(): String {
    val stoplostz = TimeZone.getDefault().getDisplayName(false, TimeZone.SHORT)
    var stoploszone = "00:00"
    if (stoplostz.length > 3) {
        stoploszone = stoplostz.substring(3)
    }
    return stoploszone
}

actual fun getStoplosdlg(stoploscon: Any) {
    val context = stoploscon as Context
    val activity = stoploscon as Activity
    AlertDialog.Builder(context).apply {
        setTitle("Sorry, error connect complete")
        setMessage("Please try again later, push exit")
        setPositiveButton("Exit") { _, _ ->
            activity.finish()
            System.exit(0)
        }
        setCancelable(true)
    }.create().show()
}

@SuppressLint("MissingPermission")
actual fun checkStoplosnet(stoploscon: Any): Boolean {
    val context = stoploscon as Context
    val conmanstoplos =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netinfstoplos = conmanstoplos.activeNetworkInfo
    return netinfstoplos != null && netinfstoplos.isConnected
}

actual fun sigStoplosoff() {
    OneSignal.disablePush(true)
}

internal actual fun getStoplosactoff(stoploscon: Any) {
    val activity = stoploscon as Activity
    activity.finish()
    System.exit(0)
}

internal actual fun stoplosct(stoploscon: Any, stoploscc: String) {
    val context = stoploscon as Context
    val activity = (context as? Activity)
    val stoplospn = "com.android.chrome"
    val stoplosb = CustomTabsIntent.Builder()
        .setShowTitle(false)
        .setInstantAppsEnabled(true)
        .build()
    if (stoplospn != null) {
        stoplosb.intent.setPackage(stoplospn)
        stoplosb.launchUrl(context, Uri.parse(stoploscc))
    } else {
        val i = Intent(Intent.ACTION_VIEW, Uri.parse(stoploscc))
        activity?.startActivity(i)
    }
}