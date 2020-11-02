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

import java.util.ArrayList;

public class SceneActivity extends AppCompatActivity {


    Intent intent;
    String actNumber;
    String dramaName;

    RecyclerView sceneList;
    SceneListAdapter sceneAdapter;

    ArrayList<Scene> scenes;

    TextView drama;
    TextView act;

    //Actionbar
    ActionBar actionBar;

    //ColorDrawable
    ColorDrawable colorDrawable;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene);

        actionBar = getSupportActionBar();
        colorDrawable = new ColorDrawable(Color.parseColor("#1a458a"));
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle(Html.fromHtml("<font color='#ffffff'>Scenes</font>"));



     scenesFunction();






    }
   //For scene list functionality
    public void scenesFunction()
    {

        intent = getIntent();

        sceneAdapter = new SceneListAdapter(this);
        drama = findViewById(R.id.scenesDrama);
        act = findViewById(R.id.scenesAct);
        actNumber = intent.getStringExtra(ActsAdapter.ACT_NUMBER);
        dramaName = intent.getStringExtra(ActsAdapter.DRAMA_NAME);


        drama.setText(intent.getStringExtra(ActsAdapter.DRAMA_NAME));
        act.setText(intent.getStringExtra(ActsAdapter.ACT_NUMBER));


        sceneList = findViewById(R.id.scenesList);

        scenes = new ArrayList<>();

        //Scenes list initialization
        sceneInitMOV();
        sceneInitTEMP();



    }

    //For scene list initialization
    public void sceneInitMOV()
    {
        if(actNumber.equals("ACT I") && dramaName.equals("The Merchant of Venice"))
        {



            scenes.clear();

            scenes.add(new Scene("Scene I" ,   intent.getStringExtra(ActsAdapter.ACT_NUMBER) ,  intent.getStringExtra(ActsAdapter.DRAMA_NAME)));
            scenes.add(new Scene("Scene II" ,  intent.getStringExtra(ActsAdapter.ACT_NUMBER) , intent.getStringExtra(ActsAdapter.DRAMA_NAME)));
            scenes.add(new Scene("Scene III" , intent.getStringExtra(ActsAdapter.ACT_NUMBER) ,  intent.getStringExtra(ActsAdapter.DRAMA_NAME)));

            sceneAdapter.setScenesList(scenes);
            sceneList.setAdapter(sceneAdapter);
            sceneList.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));





        }else if(actNumber.equals("ACT II") && dramaName.equals("The Merchant of Venice"))
        {
            scenes.clear();

            scenes.add(new Scene("Scene I" ,   intent.getStringExtra(ActsAdapter.ACT_NUMBER) ,  intent.getStringExtra(ActsAdapter.DRAMA_NAME)));
            scenes.add(new Scene("Scene II" ,  intent.getStringExtra(ActsAdapter.ACT_NUMBER) , intent.getStringExtra(ActsAdapter.DRAMA_NAME)));
            scenes.add(new Scene("Scene III" , intent.getStringExtra(ActsAdapter.ACT_NUMBER) ,  intent.getStringExtra(ActsAdapter.DRAMA_NAME)));
            scenes.add(new Scene("Scene IV" ,   intent.getStringExtra(ActsAdapter.ACT_NUMBER) ,  intent.getStringExtra(ActsAdapter.DRAMA_NAME)));
            scenes.add(new Scene("Scene V" ,  intent.getStringExtra(ActsAdapter.ACT_NUMBER) , intent.getStringExtra(ActsAdapter.DRAMA_NAME)));
            scenes.add(new Scene("Scene VI" , intent.getStringExtra(ActsAdapter.ACT_NUMBER) ,  intent.getStringExtra(ActsAdapter.DRAMA_NAME)));
            scenes.add(new Scene("Scene VII" ,   intent.getStringExtra(ActsAdapter.ACT_NUMBER) ,  intent.getStringExtra(ActsAdapter.DRAMA_NAME)));
            scenes.add(new Scene("Scene VIII" ,  intent.getStringExtra(ActsAdapter.ACT_NUMBER) , intent.getStringExtra(ActsAdapter.DRAMA_NAME)));
            scenes.add(new Scene("Scene IX" , intent.getStringExtra(ActsAdapter.ACT_NUMBER) ,  intent.getStringExtra(ActsAdapter.DRAMA_NAME)));





            sceneAdapter.setScenesList(scenes);
            sceneList.setAdapter(sceneAdapter);
            sceneList.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));



        }else if(actNumber.equals("ACT III") && dramaName.equals("The Merchant of Venice"))
        {
            scenes.clear();

            scenes.add(new Scene("Scene I" ,   intent.getStringExtra(ActsAdapter.ACT_NUMBER) ,  intent.getStringExtra(ActsAdapter.DRAMA_NAME)));
            scenes.add(new Scene("Scene II" ,  intent.getStringExtra(ActsAdapter.ACT_NUMBER) , intent.getStringExtra(ActsAdapter.DRAMA_NAME)));
            scenes.add(new Scene("Scene III" , intent.getStringExtra(ActsAdapter.ACT_NUMBER) ,  intent.getStringExtra(ActsAdapter.DRAMA_NAME)));
            scenes.add(new Scene("Scene IV" ,   intent.getStringExtra(ActsAdapter.ACT_NUMBER) ,  intent.getStringExtra(ActsAdapter.DRAMA_NAME)));
            scenes.add(new Scene("Scene V" ,  intent.getStringExtra(ActsAdapter.ACT_NUMBER) , intent.getStringExtra(ActsAdapter.DRAMA_NAME)));




            sceneAdapter.setScenesList(scenes);
            sceneList.setAdapter(sceneAdapter);
            sceneList.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));




        }else if(actNumber.equals("ACT IV") && dramaName.equals("The Merchant of Venice"))
        {
            scenes.clear();

            scenes.add(new Scene("Scene I" ,   intent.getStringExtra(ActsAdapter.ACT_NUMBER) ,  intent.getStringExtra(ActsAdapter.DRAMA_NAME)));
            scenes.add(new Scene("Scene II" ,  intent.getStringExtra(ActsAdapter.ACT_NUMBER) , intent.getStringExtra(ActsAdapter.DRAMA_NAME)));


            sceneAdapter.setScenesList(scenes);
            sceneList.setAdapter(sceneAdapter);
            sceneList.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));


        }else if(actNumber.equals("ACT V") && dramaName.equals("The Merchant of Venice"))
        {
            scenes.clear();

            scenes.add(new Scene("Scene I" ,   intent.getStringExtra(ActsAdapter.ACT_NUMBER) ,  intent.getStringExtra(ActsAdapter.DRAMA_NAME)));


            sceneAdapter.setScenesList(scenes);
            sceneList.setAdapter(sceneAdapter);
            sceneList.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));


        }



    }

    public void sceneInitTEMP()
    {
        if(actNumber.equals("ACT I") && dramaName.equals("The Tempest"))
        {
            scenes.clear();

            scenes.add(new Scene("Scene I" ,   intent.getStringExtra(ActsAdapter.ACT_NUMBER) ,  intent.getStringExtra(ActsAdapter.DRAMA_NAME)));
            scenes.add(new Scene("Scene II" ,  intent.getStringExtra(ActsAdapter.ACT_NUMBER) , intent.getStringExtra(ActsAdapter.DRAMA_NAME)));

            sceneAdapter.setScenesList(scenes);
            sceneList.setAdapter(sceneAdapter);
            sceneList.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));

        }else if(actNumber.equals("ACT II") && dramaName.equals("The Tempest"))
        {
            scenes.clear();

            scenes.add(new Scene("Scene I" ,   intent.getStringExtra(ActsAdapter.ACT_NUMBER) ,  intent.getStringExtra(ActsAdapter.DRAMA_NAME)));
            scenes.add(new Scene("Scene II" ,  intent.getStringExtra(ActsAdapter.ACT_NUMBER) , intent.getStringExtra(ActsAdapter.DRAMA_NAME)));

            sceneAdapter.setScenesList(scenes);
            sceneList.setAdapter(sceneAdapter);
            sceneList.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));



        }else if(actNumber.equals("ACT III") && dramaName.equals("The Tempest"))
        {
            scenes.clear();

            scenes.add(new Scene("Scene I" ,   intent.getStringExtra(ActsAdapter.ACT_NUMBER) ,  intent.getStringExtra(ActsAdapter.DRAMA_NAME)));
            scenes.add(new Scene("Scene II" ,  intent.getStringExtra(ActsAdapter.ACT_NUMBER) , intent.getStringExtra(ActsAdapter.DRAMA_NAME)));
            scenes.add(new Scene("Scene III" ,  intent.getStringExtra(ActsAdapter.ACT_NUMBER) , intent.getStringExtra(ActsAdapter.DRAMA_NAME)));

            sceneAdapter.setScenesList(scenes);
            sceneList.setAdapter(sceneAdapter);
            sceneList.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));

        }else if(actNumber.equals("ACT IV") && dramaName.equals("The Tempest"))
        {
            scenes.clear();

            scenes.add(new Scene("Scene I" ,   intent.getStringExtra(ActsAdapter.ACT_NUMBER) ,  intent.getStringExtra(ActsAdapter.DRAMA_NAME)));

            sceneAdapter.setScenesList(scenes);
            sceneList.setAdapter(sceneAdapter);
            sceneList.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));
        }else if(actNumber.equals("ACT V") && dramaName.equals("The Tempest"))
        {

            scenes.clear();

            scenes.add(new Scene("Scene I" ,   intent.getStringExtra(ActsAdapter.ACT_NUMBER) ,  intent.getStringExtra(ActsAdapter.DRAMA_NAME)));

            sceneAdapter.setScenesList(scenes);
            sceneList.setAdapter(sceneAdapter);
            sceneList.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));


        }



    }



}