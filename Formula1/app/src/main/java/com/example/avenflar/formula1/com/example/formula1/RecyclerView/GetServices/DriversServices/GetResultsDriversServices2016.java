package com.example.avenflar.formula1.com.example.formula1.RecyclerView.GetServices.DriversServices;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetResultsDriversServices2016 extends IntentService {

    private static final String TAG = GetResultsDriversServices.class.getSimpleName();
    public static final String Action_Results_Drivers = "com.example.avenflar.formula1.action.DRIVERS2016";

    public GetResultsDriversServices2016(){
        super("GetResultsDriversServices2016");
    }

    public static void startActionResultsDrivers(Context context){
        Intent intent = new Intent(context,GetResultsDriversServices2016.class);
        intent.setAction(Action_Results_Drivers);
        context.startService(intent);
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (Action_Results_Drivers.equals(action)) {
                handleActionResults();
            }
        }
    }


    private void handleActionResults() {
        Log.d(TAG,"Thread service name:" + Thread.currentThread().getName());
        URL url = null;
        Log.d(TAG,"Test");
        try{
            url = new URL("https://ergast.com/api/f1/2016/driverStandings.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if(HttpURLConnection.HTTP_OK == conn.getResponseCode()){
                copyInputStreamToFile(conn.getInputStream(),
                        new File(getCacheDir(), "drivers2016.json"));
                Log.d(TAG,"Results  downloaded");
                LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("Drivers Update 2016"));
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copyInputStreamToFile(InputStream in, File file){
        try{
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
