@file:Suppress("DEPRECATION")

package aaa.bivizul.a34project.android

import aaa.bivizul.a34project.domain.util.Stoploscon.STOPLOSDOR
import aaa.bivizul.a34project.domain.util.Stoploscon.STOPLOSKOR
import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.activity.ComponentActivity

class StoplosActivity : ComponentActivity() {

    private lateinit var stoploswv: WebView
    var filePathCallback: ValueCallback<Array<Uri>>? = null
    private val REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stoplos)

        stoploswv = findViewById(R.id.stoplosw)
        stoploswv.webViewClient = WebViewClient()

        stoploswv.webChromeClient = MyChromeClient()
        stoploswv.scrollBarStyle = WebView.SCROLLBARS_OUTSIDE_OVERLAY
        stoploswv.isScrollbarFadingEnabled = false

        setSettings()

        val stoplosurl = intent.getStringExtra(STOPLOSKOR) ?: STOPLOSDOR

        if (savedInstanceState == null) {
            stoploswv.post {
                kotlin.run { stoploswv.loadUrl(stoplosurl) }
            }
        }

        stoploswv.canGoBack()
        stoploswv.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK &&
                event.action == MotionEvent.ACTION_UP &&
                stoploswv.canGoBack()
            ) {
                stoploswv.goBack()
                return@OnKeyListener true
            }
            false
        })
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setSettings() {
        val stoplosws = stoploswv.settings
        stoplosws.javaScriptEnabled = true
        stoplosws.loadWithOverviewMode = true
        stoplosws.allowFileAccess = true
        stoplosws.domStorageEnabled = true
        stoplosws.builtInZoomControls = true
        stoplosws.displayZoomControls = false
        stoplosws.useWideViewPort = true
        stoplosws.setSupportZoom(true)
        stoplosws.userAgentString = stoplosws.userAgentString.replace("; wv", "")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        stoploswv.saveState(outState)
    }

    inner class MyChromeClient : WebChromeClient() {

        override fun onShowFileChooser(
            view: WebView,
            filePath: ValueCallback<Array<Uri>>,
            fileChooserParams: FileChooserParams
        ): Boolean {
            filePathCallback = filePath
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
            startActivityForResult(intent, REQUEST_CODE)
            return true
        }


        private var stoplosCustomView: View? = null
        private var stoplosCustomViewCallback: CustomViewCallback? = null
        private var stoplosOriginalOrientation = 0
        private var stoplosOriginalSystemUiVisibility = 0

        override fun getDefaultVideoPoster(): Bitmap? {
            return if (stoplosCustomView == null) {
                null
            } else BitmapFactory.decodeResource(
                this@StoplosActivity.applicationContext.resources,
                2130837573
            )
        }

        override fun onHideCustomView() {
            (this@StoplosActivity.window.decorView as FrameLayout).removeView(stoplosCustomView)
            stoplosCustomView = null
            this@StoplosActivity.window.decorView.systemUiVisibility =
                stoplosOriginalSystemUiVisibility
            this@StoplosActivity.requestedOrientation = stoplosOriginalOrientation
            stoplosCustomViewCallback!!.onCustomViewHidden()
            stoplosCustomViewCallback = null
        }

        override fun onShowCustomView(
            paramView: View?,
            paramCustomViewCallback: CustomViewCallback?
        ) {
            if (stoplosCustomView != null) {
                onHideCustomView()
                return
            }
            stoplosCustomView = paramView
            stoplosOriginalSystemUiVisibility =
                this@StoplosActivity.window.decorView.systemUiVisibility
            stoplosOriginalOrientation = this@StoplosActivity.requestedOrientation!!
            stoplosCustomViewCallback = paramCustomViewCallback
            (this@StoplosActivity.window.decorView as FrameLayout).addView(
                stoplosCustomView,
                FrameLayout.LayoutParams(-1, -1)
            )
            this@StoplosActivity.window.decorView.systemUiVisibility =
                3846 or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == REQUEST_CODE) {
            filePathCallback!!.onReceiveValue(
                WebChromeClient.FileChooserParams.parseResult(
                    resultCode,
                    intent
                )
            )
            filePathCallback = null
        }
    }
}