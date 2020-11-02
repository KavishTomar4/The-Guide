package com.notes.theguide;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {


    @Override
    public void onPageFinished(WebView view, String url) {

       view.loadUrl("javascript:(function() { " +
                "document.getElementByClassName('TitleHeader_header TitleHeader_header--noFear').style.display = 'none';" +
               "document.getElementByClassName('global-header').style.display = 'none';"+
                "})()");

    }




}
