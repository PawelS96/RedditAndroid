package com.psob96.reddit.ui.feature_login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import com.psob96.reddit.ui.base.BaseComposeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseComposeFragment<LoginViewModel>() {

    override val model: LoginViewModel by viewModels()

    @Composable
    override fun Content() {
    }

    private lateinit var webView: WebView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        webView = WebView(requireContext()).apply {
            layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }

        return webView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startWebView(webView, OAUTH_URL)
    }

    private fun startWebView(webView: WebView, url: String) {

        val client: WebViewClient = object : WebViewClient() {
            override fun onPageCommitVisible(view: WebView?, url: String?) {
                //progressIndicator.visibleOrGone(false)
            }
        }

        webView.webViewClient = client
        webView.settings.apply {
            javaScriptEnabled = true
            loadWithOverviewMode = true
            useWideViewPort = true
        }
        webView.loadUrl(url)
    }

    companion object {
        private const val OAUTH_URL = "https://www.reddit.com/api/v1/authorize.compact"
    }
}