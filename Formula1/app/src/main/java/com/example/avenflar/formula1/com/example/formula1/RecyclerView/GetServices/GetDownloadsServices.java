package com.example.avenflar.formula1.com.example.formula1.RecyclerView.GetServices;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.example.avenflar.formula1.com.example.formula1.Activites.DownloadsActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetDownloadsServices extends IntentService {

    private static final String TAG = GetDownloadsServices.class.getSimpleName();
    public static final String Action = "com.example.avenflar.formula1.action.DOWNLAODS";

    public GetDownloadsServices(){
        super("GetDownloadsServices");
    }

    public static void startAction(Context context){
        Intent intent = new Intent(context,GetDownloadsServices.class);
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
            url = new URL("https://raw.githubusercontent.com/AdamBouhastine/Donn-esProgrammationMobile/master/Tables%20Json/downloads.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if(HttpURLConnection.HTTP_OK == conn.getResponseCode()){
                copyInputStreamToFile(conn.getInputStream(),
                        new File(getCacheDir(), "downloads.json"));
                Log.d(TAG,"Results  downloaded");
                LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(DownloadsActivity.DOWNLOAD_UPDATE));
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
