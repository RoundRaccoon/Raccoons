package com.example.raccoons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class Model extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);

        ImageView alex = (ImageView) findViewById(R.id.alex);
        alex.getLayoutParams().width = 500;
        alex.getLayoutParams().height = 500;

        SeekBar sk1 = (SeekBar) findViewById(R.id.seekBar1);
        sk1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar1, int progress, boolean fromUser) {
                alex.getLayoutParams().width = progress * 10;
                alex.getLayoutParams().height = progress * 10;
                alex.requestLayout();
                TextView t = (TextView)findViewById(R.id.textView1);
                t.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar1) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar1) {

            }
        });

    }
}