package com.example.avenflar.formula1.com.example.formula1.Activites;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.example.avenflar.formula1.R;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.GetServices.GetScheduleServices;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.RecyclerItemClickListener;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.Adapter.ScheduleAdapter;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.example.avenflar.formula1.com.example.formula1.Activites.activity_home.mediaPlayer;


public class ScheduleActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        setTitle(R.string.schedule);
        Toast.makeText(getApplicationContext(),getString(R.string.toastschedule),Toast.LENGTH_LONG).show();


        IntentFilter intentFilter = new IntentFilter(SCHEDULE_UPDATE);
        LocalBroadcastManager.getInstance(ScheduleActivity.this).registerReceiver(new ScheduleUpdate(), intentFilter);
        GetScheduleServices.startActionSchedule(ScheduleActivity.this);

        rv = (RecyclerView) findViewById(R.id.rv_data);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(new ScheduleAdapter(getDateFromFile(), Glide.with(this)));

        RecyclerView recyclerView = findViewById(R.id.rv_data);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        switch (position){
                            case 0 :
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Melbourne Grand Prix Circuit")));
                                break;
                            case 1 :
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Bahrein Grand Prix")));
                                break;
                            case 2 :
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Circuit international de Shanghai")));
                                break;
                            case 3 :
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Circuit urbain de Bakou")));
                                break;
                            case 4 :
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Circuit de Catalunya")));
                                break;
                            case 5 :
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Circuit de Monaco")));
                                break;
                            case 6 :
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Circuit Gilles-Villeneuve")));
                                break;
                            case 7 :
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Circuit du Castellet")));
                                break;
                            case 8 :
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Red Bull Ring")));
                                break;
                            case 9 :
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Circuit de Silverstone")));
                                break;
                            case 10 :
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Circuit d'Hockenheim")));
                                break;
                            case 11 :
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Hungaroring")));
                                break;
                            case 12 :
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Circuit de Spa-Francorchamps")));
                                break;
                            case 13 :
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Autodromo Nazionale di Monza")));
                                break;
                            case 14 :
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Circuit urbain de Singapour")));
                                break;
                            case 15 :
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Sochi Autodrom")));
                                break;
                            case 16 :
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Suzuka")));
                                break;
                            case 17 :
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Circuit des Amériques")));
                                break;
                            case 18 :
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Autódromo Hermanos Rodríguezx")));
                                break;
                            case 19 :
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Autodromo José Carlos Pace")));
                                break;
                            case 20 :
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Circuit Yas Marina")));
                                break;
                            default :
                                break;
                        }

                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do nothing
                    }
                })
        );

    }

    public static final String SCHEDULE_UPDATE = "https://raw.githubusercontent.com/AdamBouhastine/GLPOO_ESIEA_1718_Groupe_Bouhastine/master/calendar.json";
    public class ScheduleUpdate extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d("tag", "OnReceive");
            ScheduleAdapter adapter = ((ScheduleAdapter) rv.getAdapter());
            adapter.setNewSchedule(getDateFromFile());

        }
    }



    public JSONArray getDateFromFile() {
        try {
            InputStream is = new FileInputStream(getCacheDir() + "/" + "schedule.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            JSONArray test = new JSONArray(new String(buffer,"utf-8"));
            int length = test.length();

            Log.d("tag", "Longueur : " + Integer.toString(length));
            return test; // construction du tableau
        } catch (IOException e) {
            e.printStackTrace();
            return new JSONArray();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new JSONArray();
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
                Intent intent = new Intent(ScheduleActivity.this,activity_home.class);
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



