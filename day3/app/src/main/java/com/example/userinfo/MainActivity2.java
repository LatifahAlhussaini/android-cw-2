package com.example.userinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        EditText Name = findViewById(R.id.name);
        EditText Number = findViewById(R.id.number);
        EditText Email = findViewById(R.id.email);
        EditText Address = findViewById(R.id.address);
        Button Next = findViewById(R.id.next);


        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent x2 = new Intent(MainActivity2.this,MainActivity3.class);
                String name = Name.getText().toString();
                x2.putExtra( "name",name );
                String number = Number.getText().toString();
                x2.putExtra( "number",number);
                String email = Email.getText().toString();
                x2.putExtra( "email",email);
                String address = Address.getText().toString();
                x2.putExtra( "address",address);

                startActivity(x2);

            }
        });


    }
}