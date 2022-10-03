package aaa.bivizul.a34project.android

import aaa.bivizul.a34project.domain.util.Stoploscon.STOPLOSOSAI
import android.app.Application
import com.onesignal.OneSignal

class A34PApp : Application() {

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(STOPLOSOSAI)

    }

}