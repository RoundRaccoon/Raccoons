package com.example.raccoons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;

public class AR extends AppCompatActivity {

    private String key;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_r);

        key = getIntent().getExtras().getString("id");
        storageReference = FirebaseStorage.getInstance().getReference();

        String string = "/storage/emulated/0/shirt.glb";

        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
        Uri intentUri =
                Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                        .appendQueryParameter("file", "https://github.com/GhiaraD/Test_the_sequel/blob/master/woman_mica-processed.glb?raw=true")
                        .appendQueryParameter("mode", "ar_preferred")
                        .build();
        sceneViewerIntent.setData(intentUri);
        sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");

        startActivity(sceneViewerIntent);

    }
}
//https://github.com/GhiaraD/Test_the_sequel/blob/master/scene-processed2.glb?raw=true
//https://github.com/GhiaraD/Test_the_sequel/blob/master/alex-processed.glb?raw=true
//https://github.com/GhiaraD/Test_the_sequel/blob/master/alex_mic-processed.glb?raw=true

//https://github.com/GhiaraD/Test_the_sequel/blob/master/fata-processed.glb?raw=true
//https://github.com/GhiaraD/Test_the_sequel/blob/master/fata_mica-processed.glb?raw=true

//https://github.com/GhiaraD/Test_the_sequel/blob/master/woman_mica-processed.glb?raw=true
