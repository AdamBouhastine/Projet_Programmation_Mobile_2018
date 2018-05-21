package com.example.avenflar.formula1.com.example.formula1.Activites;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.avenflar.formula1.R;

import static com.example.avenflar.formula1.com.example.formula1.Activites.activity_home.mediaPlayer;

public class TeamsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teams);
        setTitle(R.string.teams);

        Toast.makeText(getApplicationContext(),getString(R.string.toastteams),Toast.LENGTH_LONG).show();
        final int[] click ={0,0,0,0,0,0,0,0,0,0};

        final ImageView ferrari = findViewById(R.id.ferrari_team);
        ferrari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(click[0]==0) {
                    ferrari.setX(160);
                    click[0] = 1;
                }
                else {
                    ferrari.setX(600);
                    click[0] = 0;
                }
            }
        });

        final ImageView mercedes = findViewById(R.id.mercedes_team);
        mercedes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(click[1]==0) {
                    mercedes.setX(160);
                    click[1] = 1;
                }
                else {
                    mercedes.setX(600);
                    click[1] = 0;
                }
            }
        });

        final ImageView redbull = findViewById(R.id.redbull_team);
        redbull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(click[2]==0) {
                    redbull.setX(160);
                    click[2] = 1;
                }
                else {
                    redbull.setX(600);
                    click[2] = 0;
                }
            }
        });

        final ImageView mclaren = findViewById(R.id.mclaren_team);
        mclaren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(click[3]==0) {
                    mclaren.setX(160);
                    click[3] = 1;
                }
                else {
                    mclaren.setX(600);
                    click[3] = 0;
                }
            }
        });

        final ImageView renault = findViewById(R.id.renault_team);
        renault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(click[4]==0) {
                    renault.setX(160);
                    click[4] = 1;
                }
                else {
                    renault.setX(600);
                    click[4] = 0;
                }
            }
        });

        final ImageView forceindia = findViewById(R.id.forceindia_team);
        forceindia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(click[5]==0) {
                    forceindia.setX(160);
                    click[5] = 1;
                }
                else {
                    forceindia.setX(600);
                    click[5] = 0;
                }
            }
        });

        final ImageView tororosso = findViewById(R.id.tororosso_team);
        tororosso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(click[6]==0) {
                    tororosso.setX(160);
                    click[6] = 1;
                }
                else {
                    tororosso.setX(600);
                    click[6] = 0;
                }
            }
        });

        final ImageView haas = findViewById(R.id.haas_team);
        haas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(click[7]==0) {
                    haas.setX(160);
                    click[7] = 1;
                }
                else {
                    haas.setX(600);
                    click[7] = 0;
                }
            }
        });

        final ImageView sauber = findViewById(R.id.sauber_team);
        sauber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(click[8]==0) {
                    sauber.setX(160);
                    click[8] = 1;
                }
                else {
                    sauber.setX(600);
                    click[8] = 0;
                }
            }
        });

        final ImageView williams = findViewById(R.id.williams_team);
        williams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(click[9]==0) {
                    williams.setX(160);
                    click[9] = 1;
                }
                else {
                    williams.setX(600);
                    click[9] = 0;
                }
            }
        });
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
                Intent intent = new Intent(TeamsActivity.this,activity_home.class);
                startActivity(intent);
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
        if(!mediaPlayer.isPlaying()) {
            menu.getItem(1).setIcon(R.drawable.ic_stop);
        }
        return true;
    }
}
