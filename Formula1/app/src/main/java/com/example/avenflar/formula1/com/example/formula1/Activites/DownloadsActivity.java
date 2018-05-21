package com.example.avenflar.formula1.com.example.formula1.Activites;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.avenflar.formula1.R;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.Adapter.DownloadsAdapter;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.GetServices.GetDownloadsServices;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.RecyclerItemClickListener;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.example.avenflar.formula1.com.example.formula1.Activites.activity_home.mediaPlayer;

public class DownloadsActivity extends AppCompatActivity {
    public static final String DOWNLOAD_UPDATE = "https://raw.githubusercontent.com/AdamBouhastine/Donn-esProgrammationMobile/master/Tables%20Json/downloads.json";
    private RecyclerView rv;
    DownloadManager downloadmanager;
    Uri uri;
    DownloadManager.Request request;
    Long reference;
    IntentFilter filter;
    BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloads);
        setTitle(R.string.downloads);


        IntentFilter intentFilter = new IntentFilter(DOWNLOAD_UPDATE);
        LocalBroadcastManager.getInstance(DownloadsActivity.this).registerReceiver(new DownloadsUpdate(), intentFilter);
        GetDownloadsServices.startAction(DownloadsActivity.this);

        rv = (RecyclerView) findViewById(R.id.rv_downloads);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv.setAdapter(new DownloadsAdapter(getdataFromFile(), Glide.with(this)));


        RecyclerView recyclerView = findViewById(R.id.rv_downloads);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        switch (position) {
                            case 0:
                                downloadmanager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                uri = Uri.parse("https://www.formula1.com/content/fom-website/en/championship/teams/Mercedes/_jcr_content/image16x9.img.1920.medium.jpg/1519732606237.jpg");
                                request = new DownloadManager.Request(uri);
                                request.setDescription("Downloading " + uri.toString());
                                request.setTitle("Mercedes");
                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                                reference = downloadmanager.enqueue(request);
                                filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
                                receiver = new BroadcastReceiver() {
                                    @Override
                                    public void onReceive(Context context, Intent intent) {
                                        long referencee = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1);
                                        if(reference == referencee){
                                            NotificationCompat.Builder compat = new NotificationCompat.Builder(DownloadsActivity.this)
                                                    .setSmallIcon(R.drawable.ic_folder)
                                                    .setContentTitle("Téléchargement Fini")
                                                    .setContentText("Le téléchargargement de Mercedes est fini")
                                                    .setVibrate(new long[] { 500, 500, 500, 500, 500 })
                                                    .setLights(Color.RED,3000,3)
                                                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                                            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(DownloadsActivity.this);
                                            notificationManager.notify(1, compat.build());
                                        }
                                    }
                                };
                                registerReceiver(receiver,filter);
                                break;
                            case 1:
                                downloadmanager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                uri = Uri.parse("https://www.formula1.com/content/fom-website/en/championship/teams/Ferrari/_jcr_content/image16x9.img.1920.medium.jpg/1521018692996.jpg");
                                request = new DownloadManager.Request(uri);
                                request.setDescription("Downloading " + uri.toString());
                                request.setTitle("Ferrari");
                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                                reference = downloadmanager.enqueue(request);
                                filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
                                receiver = new BroadcastReceiver() {
                                    @Override
                                    public void onReceive(Context context, Intent intent) {
                                        long referencee = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1);
                                        if(reference == referencee){
                                            NotificationCompat.Builder compat = new NotificationCompat.Builder(DownloadsActivity.this)
                                                    .setSmallIcon(R.drawable.ic_folder)
                                                    .setContentTitle("Téléchargement Fini")
                                                    .setContentText("Le téléchargargement de Ferrari est fini")
                                                    .setVibrate(new long[] { 500, 500, 500, 500, 500 })
                                                    .setLights(Color.RED,3000,3)
                                                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                                            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(DownloadsActivity.this);
                                            notificationManager.notify(1, compat.build());
                                        }
                                    }
                                };
                                registerReceiver(receiver,filter);
                                break;
                            case 2:
                                downloadmanager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                uri = Uri.parse("https://www.formula1.com/content/fom-website/en/championship/teams/Red-Bull/_jcr_content/image16x9.img.1920.medium.jpg/1521018692996.jpg");
                                request = new DownloadManager.Request(uri);
                                request.setDescription("Downloading " + uri.toString());
                                request.setTitle("RedBull");
                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                                reference = downloadmanager.enqueue(request);
                                filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
                                receiver = new BroadcastReceiver() {
                                    @Override
                                    public void onReceive(Context context, Intent intent) {
                                        long referencee = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1);
                                        if(reference == referencee){
                                            NotificationCompat.Builder compat = new NotificationCompat.Builder(DownloadsActivity.this)
                                                    .setSmallIcon(R.drawable.ic_folder)
                                                    .setContentTitle("Téléchargement Fini")
                                                    .setContentText("Le téléchargargement de RedBull est fini")
                                                    .setVibrate(new long[] { 500, 500, 500, 500, 500 })
                                                    .setLights(Color.RED,3000,3)
                                                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                                            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(DownloadsActivity.this);
                                            notificationManager.notify(1, compat.build());
                                        }
                                    }
                                };
                                registerReceiver(receiver,filter);
                                break;
                            case 3:
                                downloadmanager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                uri = Uri.parse("https://www.formula1.com/content/fom-website/en/championship/teams/Force-India/_jcr_content/image16x9.img.1920.medium.jpg/1521018692996.jpg");
                                request = new DownloadManager.Request(uri);
                                request.setDescription("Downloading " + uri.toString());
                                request.setTitle("Force india");
                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                                reference = downloadmanager.enqueue(request);
                                filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
                                receiver = new BroadcastReceiver() {
                                    @Override
                                    public void onReceive(Context context, Intent intent) {
                                        long referencee = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1);
                                        if(reference == referencee){
                                            NotificationCompat.Builder compat = new NotificationCompat.Builder(DownloadsActivity.this)
                                                    .setSmallIcon(R.drawable.ic_folder)
                                                    .setContentTitle("Téléchargement Fini")
                                                    .setContentText("Le téléchargargement de Force India est fini")
                                                    .setVibrate(new long[] { 500, 500, 500, 500, 500 })
                                                    .setLights(Color.RED,3000,3)
                                                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                                            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(DownloadsActivity.this);
                                            notificationManager.notify(1, compat.build());
                                        }
                                    }
                                };
                                registerReceiver(receiver,filter);
                                break;
                            case 4:
                                downloadmanager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                uri = Uri.parse("https://www.formula1.com/content/fom-website/en/championship/teams/Renault/_jcr_content/image16x9.img.1920.medium.jpg/1521018692996.jpg");
                                request = new DownloadManager.Request(uri);
                                request.setDescription("Downloading " + uri.toString());
                                request.setTitle("Renault");
                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                                reference = downloadmanager.enqueue(request);
                                filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
                                receiver = new BroadcastReceiver() {
                                    @Override
                                    public void onReceive(Context context, Intent intent) {
                                        long referencee = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1);
                                        if(reference == referencee){
                                            NotificationCompat.Builder compat = new NotificationCompat.Builder(DownloadsActivity.this)
                                                    .setSmallIcon(R.drawable.ic_folder)
                                                    .setContentTitle("Téléchargement Fini")
                                                    .setContentText("Le téléchargargement de Renault est fini")
                                                    .setVibrate(new long[] { 500, 500, 500, 500, 500 })
                                                    .setLights(Color.RED,3000,3)
                                                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                                            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(DownloadsActivity.this);
                                            notificationManager.notify(1, compat.build());
                                        }
                                    }
                                };
                                registerReceiver(receiver,filter);
                                break;
                            case 5:
                                downloadmanager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                uri = Uri.parse("https://www.formula1.com/content/fom-website/en/championship/teams/Toro-Rosso/_jcr_content/image16x9.img.1920.medium.jpg/1521018692996.jpg");
                                request = new DownloadManager.Request(uri);
                                request.setDescription("Downloading " + uri.toString());
                                request.setTitle("Toro Rosso");
                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                                reference = downloadmanager.enqueue(request);
                                filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
                                receiver = new BroadcastReceiver() {
                                    @Override
                                    public void onReceive(Context context, Intent intent) {
                                        long referencee = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1);
                                        if(reference == referencee){
                                            NotificationCompat.Builder compat = new NotificationCompat.Builder(DownloadsActivity.this)
                                                    .setSmallIcon(R.drawable.ic_folder)
                                                    .setContentTitle("Téléchargement Fini")
                                                    .setContentText("Le téléchargargement de Toro Rosso est fini")
                                                    .setVibrate(new long[] { 500, 500, 500, 500, 500 })
                                                    .setLights(Color.RED,3000,3)
                                                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                                            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(DownloadsActivity.this);
                                            notificationManager.notify(1, compat.build());
                                        }
                                    }
                                };
                                registerReceiver(receiver,filter);
                                break;
                            case 6:
                                downloadmanager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                uri = Uri.parse("https://www.formula1.com/content/fom-website/en/championship/teams/Haas/_jcr_content/image16x9.img.1920.medium.jpg/1521018692996.jpg");
                                request = new DownloadManager.Request(uri);
                                request.setDescription("Downloading " + uri.toString());
                                request.setTitle("Haas");
                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                                reference = downloadmanager.enqueue(request);
                                filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
                                receiver = new BroadcastReceiver() {
                                    @Override
                                    public void onReceive(Context context, Intent intent) {
                                        long referencee = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1);
                                        if(reference == referencee){
                                            NotificationCompat.Builder compat = new NotificationCompat.Builder(DownloadsActivity.this)
                                                    .setSmallIcon(R.drawable.ic_folder)
                                                    .setContentTitle("Téléchargement Fini")
                                                    .setContentText("Le téléchargargement de Haas est fini")
                                                    .setVibrate(new long[] { 500, 500, 500, 500, 500 })
                                                    .setLights(Color.RED,3000,3)
                                                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                                            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(DownloadsActivity.this);
                                            notificationManager.notify(1, compat.build());
                                        }
                                    }
                                };
                                registerReceiver(receiver,filter);

                                break;
                            case 7:
                                downloadmanager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                uri = Uri.parse("https://www.formula1.com/content/fom-website/en/championship/teams/McLaren/_jcr_content/image16x9.img.1920.medium.jpg/1521018692996.jpg");
                                request = new DownloadManager.Request(uri);
                                request.setDescription("Downloading " + uri.toString());
                                request.setTitle("Mclaren");
                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                                reference = downloadmanager.enqueue(request);
                                filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
                                receiver = new BroadcastReceiver() {
                                    @Override
                                    public void onReceive(Context context, Intent intent) {
                                        long referencee = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1);
                                        if(reference == referencee){
                                            NotificationCompat.Builder compat = new NotificationCompat.Builder(DownloadsActivity.this)
                                                    .setSmallIcon(R.drawable.ic_folder)
                                                    .setContentTitle("Téléchargement Fini")
                                                    .setContentText("Le téléchargargement de Mclaren est fini")
                                                    .setVibrate(new long[] { 500, 500, 500, 500, 500 })
                                                    .setLights(Color.RED,3000,3)
                                                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                                            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(DownloadsActivity.this);
                                            notificationManager.notify(1, compat.build());
                                        }
                                    }
                                };
                                registerReceiver(receiver,filter);
                                break;
                            case 8:
                                downloadmanager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                uri = Uri.parse("https://www.formula1.com/content/fom-website/en/championship/teams/Sauber/_jcr_content/image16x9.img.1920.medium.jpg/1521018692996.jpg");
                                request = new DownloadManager.Request(uri);
                                request.setDescription("Downloading " + uri.toString());
                                request.setTitle("Sauber");
                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                                reference = downloadmanager.enqueue(request);
                                filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
                                receiver = new BroadcastReceiver() {
                                    @Override
                                    public void onReceive(Context context, Intent intent) {
                                        long referencee = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1);
                                        if(reference == referencee){
                                            NotificationCompat.Builder compat = new NotificationCompat.Builder(DownloadsActivity.this)
                                                    .setSmallIcon(R.drawable.ic_folder)
                                                    .setContentTitle("Téléchargement Fini")
                                                    .setContentText("Le téléchargargement de Sauber est fini")
                                                    .setVibrate(new long[] { 500, 500, 500, 500, 500 })
                                                    .setLights(Color.RED,3000,3)
                                                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                                            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(DownloadsActivity.this);
                                            notificationManager.notify(1, compat.build());
                                        }
                                    }
                                };
                                registerReceiver(receiver,filter);
                                break;
                            case 9:
                                downloadmanager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                uri = Uri.parse("https://www.formula1.com/content/fom-website/en/championship/teams/Williams/_jcr_content/image16x9.img.1920.medium.jpg/1521018692996.jpg");
                                request = new DownloadManager.Request(uri);
                                request.setDescription("Downloading " + uri.toString());
                                request.setTitle("Williams");
                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                                reference = downloadmanager.enqueue(request);
                                filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
                                receiver = new BroadcastReceiver() {
                                    @Override
                                    public void onReceive(Context context, Intent intent) {
                                        long referencee = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1);
                                        if(reference == referencee){
                                            NotificationCompat.Builder compat = new NotificationCompat.Builder(DownloadsActivity.this)
                                                    .setSmallIcon(R.drawable.ic_folder)
                                                    .setContentTitle("Téléchargement Fini")
                                                    .setContentText("Le téléchargargement de Williams est fini")
                                                    .setVibrate(new long[] { 500, 500, 500, 500, 500 })
                                                    .setLights(Color.RED,3000,3)
                                                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                                            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(DownloadsActivity.this);
                                            notificationManager.notify(1, compat.build());
                                        }
                                    }
                                };
                                registerReceiver(receiver,filter);
                                break;
                            default:
                                break;
                        }
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                }));
    }



    public class DownloadsUpdate extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d("tag", "OnReceive");
            DownloadsAdapter adapter = ((DownloadsAdapter) rv.getAdapter());
            adapter.setNew(getdataFromFile());

        }
    }

    public JSONArray getdataFromFile() {
        try {
            InputStream is = new FileInputStream(getCacheDir() + "/" + "downloads.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new JSONArray(new String(buffer, "utf-8"));
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
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Home:
                Intent intent = new Intent(DownloadsActivity.this, activity_home.class);
                startActivity(intent);
                return true;
            case R.id.Music:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    item.setIcon(R.drawable.ic_stop);
                } else {
                    mediaPlayer.start();
                    item.setIcon(R.drawable.ic_play_arrow);
                }
                return true;
            case R.id.Quit:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.quit);
                builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), getString(R.string.onclickquit), Toast.LENGTH_LONG).show();
                        System.exit(0);
                    }
                });
                builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), getString(R.string.onclicknotquit), Toast.LENGTH_LONG).show();
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
