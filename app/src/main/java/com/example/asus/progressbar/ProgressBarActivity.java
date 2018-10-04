package com.example.asus.progressbar;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressBarActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvTitre,tvSeekBar;
    Button btStart;
    ProgressDialog progressBar;
    ProgressBar pbDownload;
    SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        tvTitre = (TextView) findViewById(R.id.progress_tv_titre);
         btStart = (Button) findViewById(R.id.progress_bt_start);
        btStart.setOnClickListener(this);

        pbDownload = (ProgressBar) findViewById(R.id.progress_pb_download);
        tvSeekBar = (TextView) findViewById(R.id.seekbartv);
        seekBar  = (SeekBar) findViewById(R.id.seekBar);


        Resources res = getResources();
        //Drawable drawable = res.getDrawable(R.drawable.designe_bar);
        pbDownload.setProgress(80);
        pbDownload.setSecondaryProgress(95);
        pbDownload.setMax(100);
        //pbDownload.setProgressDrawable(drawable);

        // Initialize the textview with '0'.
        tvSeekBar.setText("Covered: " + seekBar.getProgress() + "/" + seekBar.getMax());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tvSeekBar.setText("Covered: " + progress + "/" + seekBar.getMax());
                Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        progressBar = new ProgressDialog(v.getContext());
        Chargement ch = new Chargement(progressBar);
        ch.start();

    }









}
