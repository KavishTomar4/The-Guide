package com.notes.theguide;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.StatusBarManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class ListActivity extends AppCompatActivity {

    ActionBar actionBar;


    RecyclerView dramaList;
    ArrayList<Drama> allDrama;
    ListAdapter adapter;



    String shortDescriptionMOV = "The Merchant of Venice is a 16th-century play written by William Shakespeare in which a merchant in Venice named Antonio defaults on a large loan provided by a Jewish moneylender, Shylock. It is believed to have been written between 1596 and 1599. ";

    String shortDescriptionTEMP = "The Tempest is a play by William Shakespeare, probably written in 1610–1611, and thought to be one of the last plays that Shakespeare wrote alone.";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //Styling
        actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#ffffff'>Drama</font>"));
        ColorDrawable  cd = new ColorDrawable(Color.parseColor("#1a458a"));
        actionBar.setBackgroundDrawable(cd);

        //--------------------------------------------------------------------------------









        listFunction();





    }

    public void listFunction()
    {
        dramaList = findViewById(R.id.dramaList);
        allDrama = new ArrayList<>();
        allDrama.add(new Drama(0 , "The Merchant of Venice" , shortDescriptionMOV , "https://images-na.ssl-images-amazon.com/images/I/5194y97u8TL._SX320_BO1,204,203,200_.jpg"));
        allDrama.add(new Drama(1 , "The Tempest" , shortDescriptionTEMP , "https://a.wattpad.com/cover/177229530-352-k123534.jpg" ));
        adapter = new ListAdapter(this);

         adapter.setDramaList(allDrama);
         dramaList.setAdapter(adapter);
         dramaList.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));




    }





}