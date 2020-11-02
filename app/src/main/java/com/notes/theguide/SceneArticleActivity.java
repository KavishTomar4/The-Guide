package com.notes.theguide;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.IUnityBannerListener;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.banners.UnityBanners;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class SceneArticleActivity extends AppCompatActivity {

    WebView webView;

    Intent intent;
    MyWebViewClient webViewClient;


    String dramaName;
    String actNum;
    String sceneNum;

    ProgressBar progressBar;

    boolean showWeb;

    //ActionBar
    ActionBar actionBar;


    //ColorDrawable
    ColorDrawable colorDrawable;





    //ads
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_article);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(SceneArticleActivity.this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9657071912829222/7651987097");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());



        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }

                        mInterstitialAd = new InterstitialAd(SceneArticleActivity.this);
                        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());

                    }
                });
            }
        },5 , 5 , TimeUnit.MINUTES);






        progressBar = findViewById(R.id.webViewProgress);


        webView = findViewById(R.id.webView);


        intent = getIntent();

        webViewClient = new MyWebViewClient();

        actionBar = getSupportActionBar();
        colorDrawable = new ColorDrawable(Color.parseColor("#1a458a"));
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle(Html.fromHtml("<font color='#ffffff'>"+intent.getStringExtra(SceneListAdapter.DRAMA_NAME)+"</font>"));




        sceneArticleMOV();
        sceneArticleTEMP();



    }




    public void sceneArticleMOV() {
        dramaName = intent.getStringExtra(SceneListAdapter.DRAMA_NAME);
        actNum = intent.getStringExtra(SceneListAdapter.ACT_NUMBER);
        sceneNum = intent.getStringExtra(SceneListAdapter.SCENE_NUMBER);

        if(dramaName.equals("The Merchant of Venice") && actNum.equals("ACT I") && sceneNum.equals("Scene I"))
        {

            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;



            progressBar.setVisibility(View.VISIBLE);
            webView.setVisibility(View.GONE);




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }

                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }





            });

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/merchant/page_2/");


        }else if(dramaName.equals("The Merchant of Venice") && actNum.equals("ACT I") && sceneNum.equals("Scene II"))
        {
            webView.getSettings().setJavaScriptEnabled(true);



            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/merchant/page_16/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }


                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }





            });



        }else if(dramaName.equals("The Merchant of Venice") && actNum.equals("ACT I") && sceneNum.equals("Scene III"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/merchant/page_26/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }



                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");




                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });




        }else if(dramaName.equals("The Merchant of Venice") && actNum.equals("ACT II") && sceneNum.equals("Scene I"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/merchant/page_42/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }



                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");




                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });





        }else if(dramaName.equals("The Merchant of Venice") && actNum.equals("ACT II") && sceneNum.equals("Scene II"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/merchant/page_46/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }



                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);


                }


            });


        }else if(dramaName.equals("The Merchant of Venice") && actNum.equals("ACT II") && sceneNum.equals("Scene III"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/merchant/page_64/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }




                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });

        }else if(dramaName.equals("The Merchant of Venice") && actNum.equals("ACT II") && sceneNum.equals("Scene IV"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/merchant/page_66/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }



                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });


        }else if(dramaName.equals("The Merchant of Venice") && actNum.equals("ACT II") && sceneNum.equals("Scene V"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/merchant/page_72/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }



                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });

        }else if(dramaName.equals("The Merchant of Venice") && actNum.equals("ACT II") && sceneNum.equals("Scene VI"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/merchant/page_78/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }




                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });

        }else if(dramaName.equals("The Merchant of Venice") && actNum.equals("ACT II") && sceneNum.equals("Scene VII"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/merchant/page_86/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }



                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });

        }else if(dramaName.equals("The Merchant of Venice") && actNum.equals("ACT II") && sceneNum.equals("Scene VIII"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/merchant/page_92/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }



                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");

                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });

        }else if(dramaName.equals("The Merchant of Venice") && actNum.equals("ACT II") && sceneNum.equals("Scene IX"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/merchant/page_98/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }




                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });

        }else if(dramaName.equals("The Merchant of Venice") && actNum.equals("ACT III") && sceneNum.equals("Scene I"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/merchant/page_106/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }


                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });



        }else if(dramaName.equals("The Merchant of Venice") && actNum.equals("ACT III") && sceneNum.equals("Scene II"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/merchant/page_118/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }


                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });

        }else if(dramaName.equals("The Merchant of Venice") && actNum.equals("ACT III") && sceneNum.equals("Scene III"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/merchant/page_142/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }


                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");

                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });

        }else if(dramaName.equals("The Merchant of Venice") && actNum.equals("ACT III") && sceneNum.equals("Scene IV"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/merchant/page_146/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }



                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });

        }else if(dramaName.equals("The Merchant of Venice") && actNum.equals("ACT III") && sceneNum.equals("Scene V"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/merchant/page_154/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }


                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });

        }else if(dramaName.equals("The Merchant of Venice") && actNum.equals("ACT IV") && sceneNum.equals("Scene I"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/merchant/page_162/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }


                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });

        }else if(dramaName.equals("The Merchant of Venice") && actNum.equals("ACT IV") && sceneNum.equals("Scene II"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/merchant/page_200/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }


                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });


        }else if(dramaName.equals("The Merchant of Venice") && actNum.equals("ACT V") && sceneNum.equals("Scene I"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/merchant/page_204/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }


                @Override
                public void onPageFinished(WebView view, String url) {
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; " +
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';" +
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';" +
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';" +
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';" +
                            "})()");


                    progressBar.setVisibility(View.GONE);
                    webView.setVisibility(View.VISIBLE);

                }





            });


        }





    }
    public void sceneArticleTEMP()
    {
        if(dramaName.equals("The Tempest") && actNum.equals("ACT I") && sceneNum.equals("Scene I"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/tempest/page_2/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }


                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });


        }else if(dramaName.equals("The Tempest") && actNum.equals("ACT I") && sceneNum.equals("Scene II"))
        {

            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/tempest/page_12/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }


                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });


        }else if(dramaName.equals("The Tempest") && actNum.equals("ACT II") && sceneNum.equals("Scene I"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/tempest/page_60/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }


                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });

        }else if(dramaName.equals("The Tempest") && actNum.equals("ACT II") && sceneNum.equals("Scene II"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/tempest/page_94/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }


                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });


        }else if(dramaName.equals("The Tempest") && actNum.equals("ACT III") && sceneNum.equals("Scene I"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/tempest/page_110/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }


                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });

        }else if(dramaName.equals("The Tempest") && actNum.equals("ACT III") && sceneNum.equals("Scene II"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/tempest/page_120/");




            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }


                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });

        }else if(dramaName.equals("The Tempest") && actNum.equals("ACT III") && sceneNum.equals("Scene III"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/tempest/page_134/");

            progressBar.setVisibility(View.VISIBLE);
            webView.setVisibility(View.GONE);


            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }


                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });

        }else if(dramaName.equals("The Tempest") && actNum.equals("ACT IV") && sceneNum.equals("Scene I"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/tempest/page_146/");

            progressBar.setVisibility(View.VISIBLE);
            webView.setVisibility(View.GONE);


            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }


                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });

        }else if(dramaName.equals("The Tempest") && actNum.equals("ACT V") && sceneNum.equals("Scene I"))
        {
            webView.getSettings().setJavaScriptEnabled(true);

            showWeb = false;

            webView.loadUrl("https://www.sparknotes.com/nofear/shakespeare/tempest/page_172/");

            progressBar.setVisibility(View.VISIBLE);
            webView.setVisibility(View.GONE);


            webView.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view , String url)
                {
                    view.loadUrl(url);

                    progressBar.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.GONE);



                    return true;
                }


                @Override
                public void onPageFinished(WebView view, String url){
                    view.loadUrl("javascript:(function() { " +
                            "document.getElementsByClassName('global-header')[0].style.display='none'; " +
                            "document.getElementsByClassName('footer')[0].style.display='none'; "+
                            "document.getElementsByClassName('TitleHeader_header TitleHeader_header--noFear')[0].style.display='none';"+
                            "document.getElementsByClassName('more-like-this')[0].style.display='none';"+
                            "document.getElementsByClassName('layout-wrapper-2018__column layout-wrapper-2018__column--right-rail')[0].style.display='none';"+
                            "document.getElementsByClassName('title-nav interiorpage_subnav1 nfs-tab')[0].style.display='none';"+
                            "})()");


                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);



                }


            });

        }



    }



}