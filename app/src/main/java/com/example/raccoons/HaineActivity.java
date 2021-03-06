package com.example.raccoons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class HaineActivity extends AppCompatActivity {

    RecyclerView mHaineList;
    DatabaseReference mDatabase;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haine);
        setTitle("Clothes");

        mHaineList = (RecyclerView) findViewById(R.id.hainelist);
        mHaineList.setHasFixedSize(true);
        mHaineList.setLayoutManager(new LinearLayoutManager(this));

        mDatabase = FirebaseDatabase.getInstance().getReference().child("haine");

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Haina,HaineViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Haina, HaineViewHolder>(
                Haina.class,
                R.layout.cv_haine,
                HaineViewHolder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(HaineViewHolder haineViewHolder, Haina haina, int i) {

                    final String post_key = getRef(i).getKey();

                    haineViewHolder.setNume(haina.getNume());
                    haineViewHolder.setDetalii(haina.getDetalii());
                    haineViewHolder.setImagine(getApplicationContext(),haina.getImagine());

                    haineViewHolder.buton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(i==2) {
                                Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
                                Uri intentUri =
                                        Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                                                .appendQueryParameter("file", "https://github.com/GhiaraD/Test_the_sequel/blob/master/alex_mic-processed.glb?raw=true")
                                                .appendQueryParameter("mode", "ar_preferred")
                                                .build();
                                sceneViewerIntent.setData(intentUri);
                                sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");

                                startActivity(sceneViewerIntent);
                            }
                            if(i==4)
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
                            }

                        }
                    });

                    haineViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent(HaineActivity.this,SingleActivity.class);
                            intent.putExtra("id",post_key);
                            startActivity(intent);

                        }
                    });

            }
        };

        mHaineList.setAdapter(firebaseRecyclerAdapter);

    }

    public static class HaineViewHolder extends RecyclerView.ViewHolder{

        View mView;

        private ImageView imagine;
        private TextView nume,detalii;
        private Button buton;
        private CardView cardView;

        public  HaineViewHolder(@NonNull View itemView){

            super(itemView);
            mView = itemView;

            imagine = (ImageView) mView.findViewById(R.id.imagineprodus);
            nume = (TextView) mView.findViewById(R.id.numeprodus);
            detalii = (TextView) mView.findViewById(R.id.detalii);
            buton = (Button) mView.findViewById(R.id.tryItOut);
            cardView = (CardView) mView.findViewById(R.id.cardHaina);

        }

        public void setImagine(Context ctx, String image) {

            Picasso
                    .with(ctx)
                    .load(image)
                    .fit()
                //    .centerInside()
                    .into(imagine);

        }

        public void setNume(String name)
        {
            nume.setText(name);
        }

        public void setDetalii(String det)
        {
            detalii.setText(det);
        }

    }

}