package com.example.avenflar.formula1.com.example.formula1.Activites;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.avenflar.formula1.R;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.Adapter.DriversAdapter;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.GetServices.GetDriversServices;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.example.avenflar.formula1.com.example.formula1.Activites.activity_home.mediaPlayer;

public class DriversActivity extends AppCompatActivity {
    RecyclerView rv;
    public static final String DRIVERS_UPDATE = "https://raw.githubusercontent.com/AdamBouhastine/Donn-esProgrammationMobile/master/Tables%20Json/drivers.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drivers);
        setTitle(R.string.drivers);

        IntentFilter intentFilter = new IntentFilter(DRIVERS_UPDATE);
        LocalBroadcastManager.getInstance(DriversActivity.this).registerReceiver(new DriversUpdate(), intentFilter);
        GetDriversServices.startActionDrivers(DriversActivity.this);

        rv = (RecyclerView) findViewById(R.id.rv_drivers);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new   DriversAdapter(getDriversFromFile(), Glide.with(this)));

    }

    public class DriversUpdate extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d("tag", "OnReceive");
            DriversAdapter adapter = ((DriversAdapter) rv.getAdapter());
            adapter.setNewDriver(getDriversFromFile());

        }
    }

    public JSONArray getDriversFromFile() {
        try {
            InputStream is = new FileInputStream(getCacheDir() + "/" + "drivers2.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new JSONArray(new String(buffer,"utf-8"));
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
                Intent intent = new Intent(DriversActivity.this,activity_home.class);
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
