package com.example.avenflar.formula1.com.example.formula1.RecyclerView.GetServices;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.example.avenflar.formula1.com.example.formula1.Activites.ScheduleActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetScheduleServices extends IntentService {

    private static final String TAG = GetScheduleServices.class.getSimpleName();
    public static final String Action_Schedule = "com.example.avenflar.formula1.action.SCHEDULE";

    public GetScheduleServices(){
        super("GetScheduleServices");
    }

    public static void startActionSchedule(Context context){
        Intent intent = new Intent(context,GetScheduleServices.class);
        intent.setAction(Action_Schedule);
        context.startService(intent);
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (Action_Schedule.equals(action)) {
                handleActionBiers();
            }
        }
    }


    private void handleActionBiers() {
        Log.d(TAG,"Thread service name:" + Thread.currentThread().getName());
        URL url = null;
        try{
            url = new URL("https://raw.githubusercontent.com/AdamBouhastine/GLPOO_ESIEA_1718_Groupe_Bouhastine/master/calendar.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if(HttpURLConnection.HTTP_OK == conn.getResponseCode()){
                copyInputStreamToFile(conn.getInputStream(),
                        new File(getCacheDir(), "schedule.json"));
                Log.d(TAG," Schedule downloaded");
                LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(ScheduleActivity.SCHEDULE_UPDATE));
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
