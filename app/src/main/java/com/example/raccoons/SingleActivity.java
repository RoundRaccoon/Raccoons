package com.example.raccoons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SyncNotedAppOp;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import static android.widget.Toast.LENGTH_SHORT;

public class SingleActivity extends AppCompatActivity {

    LinearLayout watch,buy;
    TextView nume,desc;
    ImageView img;
    String key;
    DatabaseReference mDatabase;
    TextView S,M,L;
    boolean s,m,l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

            watch = (LinearLayout) findViewById(R.id.WATCH);
            buy = (LinearLayout) findViewById(R.id.BUY);
            nume = (TextView) findViewById(R.id.singlenume);
            desc = (TextView) findViewById(R.id.singledesc);
            img = (ImageView) findViewById(R.id.singleimage);
            S = (TextView) findViewById(R.id.S);
            M = (TextView) findViewById(R.id.M);
            L = (TextView) findViewById(R.id.L);
            s=true; m=false; l=false;

            key = getIntent().getStringExtra("id");
            mDatabase = FirebaseDatabase.getInstance().getReference().child("haine").child(key);

            mDatabase.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    nume.setText(snapshot.child("nume").getValue().toString());
                    desc.setText(snapshot.child("detalii").getValue().toString());
                    Picasso.with(getApplicationContext()).load(snapshot.child("imagine").getValue().toString()).fit().into(img);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

            S.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(!s)
                    {
                        S.setBackgroundResource(R.drawable.btn_style);
                        M.setBackgroundResource(R.drawable.btn_style_3);
                        L.setBackgroundResource(R.drawable.btn_style_3);
                        s=true; m=false; l=false;
                    }

                }
            });

        M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!m)
                {
                    S.setBackgroundResource(R.drawable.btn_style_3);
                    M.setBackgroundResource(R.drawable.btn_style);
                    L.setBackgroundResource(R.drawable.btn_style_3);
                    s=false; m=true; l=false;
                }

            }
        });

        L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!l)
                {
                    S.setBackgroundResource(R.drawable.btn_style_3);
                    M.setBackgroundResource(R.drawable.btn_style_3);
                    L.setBackgroundResource(R.drawable.btn_style);
                    s=false; m=false; l=true;
                }

            }
        });

            buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //add functionality

                }
            });

            watch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(s)
                    {
                        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
                        Uri intentUri =
                                Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                                        .appendQueryParameter("file", "https://github.com/GhiaraD/Test_the_sequel/blob/master/tricou_ok-processed.glb?raw=true")
                                        .appendQueryParameter("mode", "ar_preferred")
                                        .build();
                        sceneViewerIntent.setData(intentUri);
                        sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");

                        startActivity(sceneViewerIntent);
                    }else if(l)
                    {
                        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
                        Uri intentUri =
                                Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                                        .appendQueryParameter("file", "https://github.com/GhiaraD/Test_the_sequel/blob/master/tricou_mare-processed.glb?raw=true")
                                        .appendQueryParameter("mode", "ar_preferred")
                                        .build();
                        sceneViewerIntent.setData(intentUri);
                        sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");

                        startActivity(sceneViewerIntent);
                    }else
                    {
                        Toast.makeText(SingleActivity.this,"We do not have this size in stock at the moment",LENGTH_SHORT).show();
                    }

                }
            });

    }
}