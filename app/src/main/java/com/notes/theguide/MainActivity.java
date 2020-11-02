package com.notes.theguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;

import java.net.DatagramSocket;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static int TIME_OUT = 3000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this , ListActivity.class);
                startActivity(intent);

                finish();
            }
        }, TIME_OUT);



    }
}