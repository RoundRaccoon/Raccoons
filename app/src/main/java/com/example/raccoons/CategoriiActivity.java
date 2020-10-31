package com.example.raccoons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class CategoriiActivity extends AppCompatActivity {

    RecyclerView mCategList;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorii);

        mCategList = (RecyclerView) findViewById(R.id.categlist);
        mCategList.setLayoutManager(new LinearLayoutManager(this));
        mCategList.setHasFixedSize(true);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("categorie");

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Categorie,CategorieViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Categorie, CategorieViewHolder>(
                Categorie.class,
                R.layout.cv_categorii,
                CategorieViewHolder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(CategorieViewHolder categorieViewHolder, Categorie categorie, int i) {

                final String post_key = getRef(i).getKey();

                categorieViewHolder.setImagine(getApplicationContext(),categorie.getImagine());
                categorieViewHolder.setNume(categorie.getNume());

                categorieViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        startActivity(new Intent(CategoriiActivity.this,HaineActivity.class));

                    }
                });

            }
        };

        mCategList.setAdapter(firebaseRecyclerAdapter);

    }

    public static class CategorieViewHolder extends RecyclerView.ViewHolder{

        View mView;

        ImageView imagine;
        TextView nume;
        CardView cardView;

        public CategorieViewHolder(View itemView)
        {
            super(itemView);
            mView = itemView;

            imagine = (ImageView) mView.findViewById(R.id.imagineStock);
            nume = (TextView) mView.findViewById(R.id.numeStock);
            cardView = (CardView) mView.findViewById(R.id.Stock);

        }

        public void setImagine(Context ctx, String image)
        {

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

    }

}