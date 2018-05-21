package com.example.avenflar.formula1.com.example.formula1.Activites;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.avenflar.formula1.R;


import java.util.List;


public class activity_home extends AppCompatActivity {

    public static MediaPlayer mediaPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        if(mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.f1_theme);
        if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }
        }

        ImageView btw_results = findViewById(R.id.results_picutre);
        btw_results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(activity_home.this, ResultsActivity.class);
                startActivity(intent);
            }
        });

        ImageView btn_teams = findViewById(R.id.teams_image);

        btn_teams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_home.this,TeamsActivity.class);
                startActivity(intent);
            }
        });

        ImageView btn_schedule = findViewById(R.id.schedule_image);

        btn_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_home.this,ScheduleActivity.class);
                startActivity(intent);
            }
        });

        ImageView btn_drivers = findViewById(R.id.drivers_image);

        btn_drivers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_home.this,DriversActivity.class);
                startActivity(intent);
            }
        });

        ImageView btn_downloads = findViewById(R.id.image_downloads);

        btn_downloads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_home.this,DownloadsActivity.class);
                startActivity(intent);
            }
        });

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/policefont.ttf");

        TextView home_schedule= (TextView)findViewById(R.id.home_schedule);
        TextView home_teams= (TextView)findViewById(R.id.home_teams);
        TextView home_drivers= (TextView)findViewById(R.id.home_drivers);
        TextView home_downloads= (TextView)findViewById(R.id.home_downloads);
        TextView home_results= (TextView)findViewById(R.id.home_results);

        home_schedule.setTypeface(font);
        home_teams.setTypeface(font);
        home_drivers.setTypeface(font);
        home_downloads.setTypeface(font);
        home_results.setTypeface(font);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.Home :
                return true;
            case R.id.Music :
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    item.setIcon(R.drawable.ic_stop);
                }
                else {
                    mediaPlayer.start();
                    item.setIcon(R.drawable.ic_play_arrow);
                }
                return true;
                case R.id.Quit :
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(R.string.quit);
                    builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(),getString(R.string.onclickquit),Toast.LENGTH_LONG).show();
                            System.exit(0);
                        }
                    });
                    builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(),getString(R.string.onclicknotquit),Toast.LENGTH_LONG).show();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (!mediaPlayer.isPlaying()) {
            menu.getItem(1).setIcon(R.drawable.ic_stop);
        }
        return true;
    }


}
