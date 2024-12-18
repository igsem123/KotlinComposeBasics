package br.com.app.src.main.kotlin.com.basicAndroidKotlinCompose

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity

class WebViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val webView = WebView(this)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

        val url = intent.getStringExtra("url") ?: "https://www.google.com"
        webView.loadUrl(url)
        setContentView(webView)
    }
}
