package com.example.userinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity3 extends AppCompatActivity {



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);



        Bundle Bl = getIntent().getExtras();
        String n =  Bl.getString("name");
        String num = Bl.getString("number");
        String em = Bl.getString("email");
        String Add = Bl.getString("address");



        TextView a = findViewById(R.id.NameView);
        TextView b = findViewById(R.id.NumberView);
        TextView c = findViewById(R.id.EmailView);
        TextView d = findViewById(R.id.addressView);



        a.setText(" Hi "+n);
        b.setText(" phone "+num);
        c.setText(" E-mail " +em);
        d.setText(" Address "+Add);


        final int REQUEST_PHONE_CALL = 1;

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+num));

                if (ContextCompat.checkSelfPermission(MainActivity3.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity3.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
                }
                else
                {
                    startActivity(callIntent);
                }

            }
        });


        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, em);
                email.putExtra(Intent.EXTRA_SUBJECT, "from " +n);
                email.putExtra(Intent.EXTRA_TEXT,"Hi");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Send email:"));

            }
        });


        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri gmmIntentUri = Uri.parse("google.streetview:cbll=29.381653544278528, 48.00206131696215");

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);


            }
        });


        Button Back = findViewById(R.id.button);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent q = new Intent(MainActivity3.this,MainActivity2.class);
                startActivity(q) ;

            }
        });


    }
}