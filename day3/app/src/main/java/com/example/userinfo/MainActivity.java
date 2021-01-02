package com.example.userinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler A = new Handler(getMainLooper());
        A.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent x = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(x);

            }
        },5000);




    }
}