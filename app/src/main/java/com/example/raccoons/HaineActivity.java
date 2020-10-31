package com.example.raccoons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haine);

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

            }
        };

        mHaineList.setAdapter(firebaseRecyclerAdapter);

    }

    public static class HaineViewHolder extends RecyclerView.ViewHolder{

        View mView;

        private ImageView imagine;
        private TextView nume,detalii;

        public  HaineViewHolder(@NonNull View itemView){

            super(itemView);
            mView = itemView;

            imagine = (ImageView) mView.findViewById(R.id.imagineprodus);
            nume = (TextView) mView.findViewById(R.id.numeprodus);
            detalii = (TextView) mView.findViewById(R.id.detalii);

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