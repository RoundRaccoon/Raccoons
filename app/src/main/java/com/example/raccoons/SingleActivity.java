package com.example.raccoons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SyncNotedAppOp;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class SingleActivity extends AppCompatActivity {

    LinearLayout watch,buy;
    TextView nume,desc;
    ImageView img;
    String key;
    DatabaseReference mDatabase;
    TextView S,M,L;

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
            M = (TextView) findViewById(R.id.L);

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

            buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //add functionality

                }
            });

            watch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    /** DRAGOS AICI TREBUIE SA PUI ASAP ROCKY !!!! **/

                }
            });


    }
}