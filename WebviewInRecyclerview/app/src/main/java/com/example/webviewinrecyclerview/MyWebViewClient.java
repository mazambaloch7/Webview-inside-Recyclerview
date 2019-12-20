package com.example.webviewinrecyclerview;

import android.annotation.SuppressLint;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {

    @SuppressLint("NewApi")
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        view.loadUrl(request.getUrl().toString());
        return true;

    }
}