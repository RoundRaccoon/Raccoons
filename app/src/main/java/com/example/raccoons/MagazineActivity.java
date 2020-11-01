package com.example.raccoons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MagazineActivity extends AppCompatActivity {

    CardView cardView1;

    ImageView img1,img2,img3,img4,img5,img6,img7,img8;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazine);

        cardView1 = (CardView) findViewById(R.id.shops1);
        img1 = (ImageView) findViewById(R.id.shopLogo1);
        img2 = (ImageView) findViewById(R.id.shopLogo2);
        img3 = (ImageView) findViewById(R.id.shopLogo3);
        img4 = (ImageView) findViewById(R.id.shopLogo4);
        img5 = (ImageView) findViewById(R.id.shopLogo5);
        img6 = (ImageView) findViewById(R.id.shopLogo6);
        img7 = (ImageView) findViewById(R.id.shopLogo7);
        img8 = (ImageView) findViewById(R.id.shopLogo8);

        Picasso.with(getApplicationContext()).load("https://firebasestorage.googleapis.com/v0/b/raccoon-61e45.appspot.com/o/HM-Logo.png?alt=media&token=2c399782-7908-4d16-b937-84abefb3feac").fit().into(img1);
        Picasso.with(getApplicationContext()).load("https://firebasestorage.googleapis.com/v0/b/raccoon-61e45.appspot.com/o/zara.png?alt=media&token=9948400f-74c2-4626-ad8d-87b1fb8bcbf9").fit().into(img2);
        Picasso.with(getApplicationContext()).load("https://firebasestorage.googleapis.com/v0/b/raccoon-61e45.appspot.com/o/LouisVuitton.jpg?alt=media&token=d551ddbd-226a-4d83-ab5f-26f52c760c2b").fit().into(img3);
        Picasso.with(getApplicationContext()).load("https://firebasestorage.googleapis.com/v0/b/raccoon-61e45.appspot.com/o/HugoBoss.png?alt=media&token=ea3ed358-fafe-45dd-a677-6d5da6005e92").fit().into(img4);
        Picasso.with(getApplicationContext()).load("https://firebasestorage.googleapis.com/v0/b/raccoon-61e45.appspot.com/o/armani.png?alt=media&token=ee7adc66-cbf9-4916-965a-38054bbfb7c5").fit().into(img5);
        Picasso.with(getApplicationContext()).load("https://firebasestorage.googleapis.com/v0/b/raccoon-61e45.appspot.com/o/gucci.jpg?alt=media&token=e8d4c342-c932-4939-9b94-99efa53d4205").fit().into(img6);
        Picasso.with(getApplicationContext()).load("https://firebasestorage.googleapis.com/v0/b/raccoon-61e45.appspot.com/o/Cropp-Logo.png?alt=media&token=05276c13-a4e9-476a-ad9b-32aa9a0d74de").fit().into(img7);
        Picasso.with(getApplicationContext()).load("https://firebasestorage.googleapis.com/v0/b/raccoon-61e45.appspot.com/o/Forever-21-Logo.png?alt=media&token=14f7c816-c58f-4346-ab07-b9b2d4588626").fit().into(img8);


        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MagazineActivity.this,CategoriiActivity.class));

            }
        });

    }
}