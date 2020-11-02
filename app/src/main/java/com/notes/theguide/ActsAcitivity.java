package com.notes.theguide;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;

import java.util.ArrayList;

public class ActsAcitivity extends AppCompatActivity {


    //ActionBar
    ActionBar actionBar;

    //ColorDrawable
    ColorDrawable colorDrawable;

    //Heading;
    TextView heading;

    ArrayList<Drama> dramas;



    //We are initializing ListAdapter to get book
    ListAdapter adapter;

    //Adapter for Acts
    ActsAdapter actsAdapter;

    //ArrayList for acts
    ArrayList<Act> acts;

    RecyclerView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acts_acitivity);




        actionBar = getSupportActionBar();
        colorDrawable = new ColorDrawable(Color.parseColor("#1a458a"));
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle(Html.fromHtml("<font color='#ffffff'>Acts</font>"));



        Actfunction();


    }
    public void Actfunction()
    {
        Intent intent = getIntent();
        //Getting book id
        heading = findViewById(R.id.actHeading);
        adapter = new ListAdapter(this);
        actsAdapter = new ActsAdapter(this);
        listView = findViewById(R.id.actsList);



        heading.setText(intent.getStringExtra(ListAdapter.DRAMA_ID));









        acts = new ArrayList<>();
        acts.add(new Act(1 , "ACT I" ,intent.getStringExtra(ListAdapter.DRAMA_ID) ));
        acts.add(new Act(2 , "ACT II" , intent.getStringExtra(ListAdapter.DRAMA_ID)));
        acts.add(new Act(3 , "ACT III" , intent.getStringExtra(ListAdapter.DRAMA_ID)));
        acts.add(new Act(4 , "ACT IV" , intent.getStringExtra(ListAdapter.DRAMA_ID)));
        acts.add(new Act(5 , "ACT V" , intent.getStringExtra(ListAdapter.DRAMA_ID)));

        actsAdapter.setActList(acts);
        listView.setAdapter(actsAdapter);
        listView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));















    }

}