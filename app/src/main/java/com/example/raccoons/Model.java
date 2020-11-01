package com.example.raccoons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class Model extends AppCompatActivity {

    int lat, lung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);

        ImageView alex = (ImageView) findViewById(R.id.alex);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(800, 800);
        //layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        alex.setLayoutParams(layoutParams);


        lat=550; lung=550;

        SeekBar sk1 = (SeekBar) findViewById(R.id.seekBar1);
        SeekBar sk2 = (SeekBar) findViewById(R.id.seekBar2);

        sk1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar1, int progress, boolean fromUser) {

//                alex.getLayoutParams().width = progress * 10;
//                alex.getLayoutParams().height = progress * 10;
//                alex.requestLayout();

                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(progress*12, lung);
                lat=progress*15;
                layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
                alex.setLayoutParams(layoutParams);

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

        sk2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar1, int progress, boolean fromUser) {

//                alex.getLayoutParams().width = progress * 10;
//                alex.getLayoutParams().height = progress * 10;
//                alex.requestLayout();

                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(lat, progress*15);
                lung=progress*15;
                layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
                alex.setLayoutParams(layoutParams);

                TextView t = (TextView)findViewById(R.id.textView2);
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