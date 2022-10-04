@file:Suppress("DEPRECATION")

package aaa.bivizul.a34project.domain.util

import aaa.bivizul.a34project.domain.util.Stoploscon.STOPLOSACTIVITY
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.telephony.TelephonyManager
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

actual fun getStoplosact(stoplosact: Any, stoplosurl: String) {
    val activity = stoplosact as Activity
    val stoplosc = Class.forName(STOPLOSACTIVITY)
    val stoplosi = Intent(activity, stoplosc)
    val put = stoplosi.putExtra(Stoploscon.STOPLOSKOR, stoplosurl)
    activity.startActivity(put)
}