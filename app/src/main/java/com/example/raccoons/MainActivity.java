package com.example.raccoons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button fizicButton,onlineButton,customButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fizicButton = (Button) findViewById(R.id.fizic);
        onlineButton = (Button) findViewById(R.id.online);
        customButton = (Button) findViewById(R.id.custom);

        fizicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // activitate qr

            }
        });

        onlineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,MagazineActivity.class));

            }
        });

        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // activitate personalizare 

            }
        });

    }

}