package com.example.avenflar.formula1.com.example.formula1.RecyclerView.GetServices.TeamsServices;

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

public class GetResultsTeamsServices2013 extends IntentService {

    private static final String TAG = GetResultsTeamsServices.class.getSimpleName();
    public static final String Action = "com.example.avenflar.formula1.action.TEAMS2013";

    public GetResultsTeamsServices2013 (){
        super("GetResultServices2013");
    }

    public static void startAction(Context context){
        Intent intent = new Intent(context,GetResultsTeamsServices2013.class);
        intent.setAction(Action);
        context.startService(intent);
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (Action.equals(action)) {
                handleActionResults();
            }
        }
    }


    private void handleActionResults() {
        Log.d(TAG,"Thread service name:" + Thread.currentThread().getName());
        URL url = null;
        try{
            url = new URL("https://ergast.com/api/f1/2013/constructorStandings.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if(HttpURLConnection.HTTP_OK == conn.getResponseCode()){
                copyInputStreamToFile(conn.getInputStream(),
                        new File(getCacheDir(), "teams2013.json"));
                Log.d(TAG,"Results  downloaded");
                LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("Teams Update 2013"));
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
