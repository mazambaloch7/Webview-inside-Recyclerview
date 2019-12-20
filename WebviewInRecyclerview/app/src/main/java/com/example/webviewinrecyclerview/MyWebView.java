package com.example.webviewinrecyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class MyWebView extends WebView {

    public MyWebView(Context context) {
        super(context);
        initDefaultSetting();
    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initDefaultSetting();
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDefaultSetting();
    }

    @SuppressLint("NewApi")
    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr,
                     int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initDefaultSetting();
    }


    private void initDefaultSetting() {
        WebSettings webSettings = this.getSettings();
        webSettings.setJavaScriptEnabled(true);
        setWebChromeClient(new WebChromeClient());
        setVerticalScrollBarEnabled(true);
        setWebViewClient(new MyWebViewClient());
    }

    /**
     * Load Web View with url
     */
    public void load(String url) {
        this.loadUrl(url);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event){
//        requestDisallowInterceptTouchEvent(true);
//        return super.onTouchEvent(event);
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Check is required to prevent crash
//        if (event.findPointerIndex(event, 0) == -1) {
        if (event.findPointerIndex(0) == -1) {
            return super.onTouchEvent(event);
        }

        if (event.getPointerCount() >= -1) {
            requestDisallowInterceptTouchEvent(true);
        } else {
            requestDisallowInterceptTouchEvent(false);
        }

        return super.onTouchEvent(event);
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        requestDisallowInterceptTouchEvent(true);
    }

}
