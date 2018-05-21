package com.example.avenflar.formula1.com.example.formula1.Onglets.Fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.avenflar.formula1.R;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.Adapter.ResultsDriverAdapter;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.Adapter.ResultsDriverAdapterNoPicture;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.GetServices.DriversServices.GetResultsDriversServices;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.GetServices.DriversServices.GetResultsDriversServices2013;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.GetServices.DriversServices.GetResultsDriversServices2014;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.GetServices.DriversServices.GetResultsDriversServices2015;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.GetServices.DriversServices.GetResultsDriversServices2016;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.GetServices.DriversServices.GetResultsDriversServices2017;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class ResultsDriversFragment2018 extends Fragment {

    private RecyclerView rv;
    TextView drivers_2018;
    TextView drivers_2017;
    TextView drivers_2016;
    TextView drivers_2015;
    TextView drivers_2014;
    TextView drivers_2013;


    public static android.support.v4.app.Fragment newInstance() {
        return new ResultsDriversFragment2018();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_results_drivers_2018, container, false);

        IntentFilter intentFilter = new IntentFilter("Drivers Update");
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(new ResultsDriversUpdate2018(), intentFilter);
        GetResultsDriversServices.startActionResultsDrivers(getActivity());

        rv = (RecyclerView) view.findViewById(R.id.rv_data_drivers);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new ResultsDriverAdapter(getResultsDriversFromFile("drivers.json"), Glide.with(getActivity())));

        final TextView title = (TextView) view.findViewById(R.id.Title2);
        drivers_2018 = (TextView) view.findViewById(R.id.drivers_2018);
        drivers_2018.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IntentFilter intentFilter = new IntentFilter("Drivers Update");
                LocalBroadcastManager.getInstance(getActivity()).registerReceiver(new ResultsDriversUpdate2018(), intentFilter);
                GetResultsDriversServices.startActionResultsDrivers(getActivity());

                rv = (RecyclerView) view.findViewById(R.id.rv_data_drivers);
                rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                rv.setAdapter(new ResultsDriverAdapter(getResultsDriversFromFile("drivers.json"), Glide.with(getActivity())));

                title.setText(R.string.standings_drivers_2018);
                drivers_2018.setTextColor(getResources().getColor(R.color.Primaire));
                drivers_2018.setBackground(getResources().getDrawable(R.color.white));
                drivers_2017.setTextColor(getResources().getColor(R.color.white));
                drivers_2017.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2016.setTextColor(getResources().getColor(R.color.white));
                drivers_2016.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2015.setTextColor(getResources().getColor(R.color.white));
                drivers_2015.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2014.setTextColor(getResources().getColor(R.color.white));
                drivers_2014.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2013.setTextColor(getResources().getColor(R.color.white));
                drivers_2013.setBackground(getResources().getDrawable(R.color.Primaire));

            }
        });

        drivers_2017 = (TextView) view.findViewById(R.id.drivers_2017);
        drivers_2017.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                IntentFilter intentFilter = new IntentFilter("Drivers Update 2017");
                LocalBroadcastManager.getInstance(getActivity()).registerReceiver(new ResultsDriversUpdate2017(), intentFilter);
                GetResultsDriversServices2017.startActionResultsDrivers(getActivity());

                rv = (RecyclerView) view.findViewById(R.id.rv_data_drivers);
                rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                rv.setAdapter(new ResultsDriverAdapterNoPicture(getResultsDriversFromFileWithoutPicture("drivers2017.json")));
                title.setText(R.string.standings_drivers_2017);
                drivers_2017.setTextColor(getResources().getColor(R.color.Primaire));
                drivers_2017.setBackground(getResources().getDrawable(R.color.white));
                drivers_2018.setTextColor(getResources().getColor(R.color.white));
                drivers_2018.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2016.setTextColor(getResources().getColor(R.color.white));
                drivers_2016.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2015.setTextColor(getResources().getColor(R.color.white));
                drivers_2015.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2014.setTextColor(getResources().getColor(R.color.white));
                drivers_2014.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2013.setTextColor(getResources().getColor(R.color.white));
                drivers_2013.setBackground(getResources().getDrawable(R.color.Primaire));
            }
        });

        drivers_2016 = (TextView) view.findViewById(R.id.drivers_2016);
        drivers_2016.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                IntentFilter intentFilter = new IntentFilter("Drivers Update 2016");
                LocalBroadcastManager.getInstance(getActivity()).registerReceiver(new ResultsDriversUpdate2016(), intentFilter);
                GetResultsDriversServices2016.startActionResultsDrivers(getActivity());

                rv = (RecyclerView) view.findViewById(R.id.rv_data_drivers);
                rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                rv.setAdapter(new ResultsDriverAdapterNoPicture(getResultsDriversFromFileWithoutPicture("drivers2016.json")));
                title.setText(R.string.standings_drivers_2016);
                drivers_2016.setTextColor(getResources().getColor(R.color.Primaire));
                drivers_2016.setBackground(getResources().getDrawable(R.color.white));
                drivers_2018.setTextColor(getResources().getColor(R.color.white));
                drivers_2018.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2017.setTextColor(getResources().getColor(R.color.white));
                drivers_2017.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2015.setTextColor(getResources().getColor(R.color.white));
                drivers_2015.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2014.setTextColor(getResources().getColor(R.color.white));
                drivers_2014.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2013.setTextColor(getResources().getColor(R.color.white));
                drivers_2013.setBackground(getResources().getDrawable(R.color.Primaire));
            }
        });

        drivers_2015 = (TextView) view.findViewById(R.id.drivers_2015);
        drivers_2015.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                IntentFilter intentFilter = new IntentFilter("Drivers Update 2015");
                LocalBroadcastManager.getInstance(getActivity()).registerReceiver(new ResultsDriversUpdate2015(), intentFilter);
                GetResultsDriversServices2015.startActionResultsDrivers(getActivity());

                rv = (RecyclerView) view.findViewById(R.id.rv_data_drivers);
                rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                rv.setAdapter(new ResultsDriverAdapterNoPicture(getResultsDriversFromFileWithoutPicture("drivers2015.json")));
                title.setText(R.string.standings_drivers_2015);
                drivers_2015.setTextColor(getResources().getColor(R.color.Primaire));
                drivers_2015.setBackground(getResources().getDrawable(R.color.white));
                drivers_2018.setTextColor(getResources().getColor(R.color.white));
                drivers_2018.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2017.setTextColor(getResources().getColor(R.color.white));
                drivers_2017.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2016.setTextColor(getResources().getColor(R.color.white));
                drivers_2016.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2014.setTextColor(getResources().getColor(R.color.white));
                drivers_2014.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2013.setTextColor(getResources().getColor(R.color.white));
                drivers_2013.setBackground(getResources().getDrawable(R.color.Primaire));
            }
        });

        drivers_2014 = (TextView) view.findViewById(R.id.drivers_2014);
        drivers_2014.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                IntentFilter intentFilter = new IntentFilter("Drivers Update 2014");
                LocalBroadcastManager.getInstance(getActivity()).registerReceiver(new ResultsDriversUpdate2014(), intentFilter);
                GetResultsDriversServices2014.startActionResultsDrivers(getActivity());

                rv = (RecyclerView) view.findViewById(R.id.rv_data_drivers);
                rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                rv.setAdapter(new ResultsDriverAdapterNoPicture(getResultsDriversFromFileWithoutPicture("drivers2014.json")));
                title.setText(R.string.standings_drivers_2014);
                drivers_2014.setTextColor(getResources().getColor(R.color.Primaire));
                drivers_2014.setBackground(getResources().getDrawable(R.color.white));
                drivers_2018.setTextColor(getResources().getColor(R.color.white));
                drivers_2018.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2017.setTextColor(getResources().getColor(R.color.white));
                drivers_2017.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2016.setTextColor(getResources().getColor(R.color.white));
                drivers_2016.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2015.setTextColor(getResources().getColor(R.color.white));
                drivers_2015.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2013.setTextColor(getResources().getColor(R.color.white));
                drivers_2013.setBackground(getResources().getDrawable(R.color.Primaire));
            }
        });

        drivers_2013 = (TextView) view.findViewById(R.id.drivers_2013);
        drivers_2013.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                IntentFilter intentFilter = new IntentFilter("Drivers Update 2013");
                LocalBroadcastManager.getInstance(getActivity()).registerReceiver(new ResultsDriversUpdate2013(), intentFilter);
                GetResultsDriversServices2013.startActionResultsDrivers(getActivity());

                rv = (RecyclerView) view.findViewById(R.id.rv_data_drivers);
                rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                rv.setAdapter(new ResultsDriverAdapterNoPicture(getResultsDriversFromFileWithoutPicture("drivers2013.json")));
                title.setText(R.string.standings_drivers_2013);
                drivers_2013.setTextColor(getResources().getColor(R.color.Primaire));
                drivers_2013.setBackground(getResources().getDrawable(R.color.white));
                drivers_2018.setTextColor(getResources().getColor(R.color.white));
                drivers_2018.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2017.setTextColor(getResources().getColor(R.color.white));
                drivers_2017.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2016.setTextColor(getResources().getColor(R.color.white));
                drivers_2016.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2015.setTextColor(getResources().getColor(R.color.white));
                drivers_2015.setBackground(getResources().getDrawable(R.color.Primaire));
                drivers_2014.setTextColor(getResources().getColor(R.color.white));
                drivers_2014.setBackground(getResources().getDrawable(R.color.Primaire));
            }
        });

        return view;

    }


    public class ResultsDriversUpdate2018 extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d("tag", "OnReceive");
            ResultsDriverAdapter adapter = (ResultsDriverAdapter)rv.getAdapter();
            adapter.setNewResultsDriver(getResultsDriversFromFile("drivers.json"));

        }
    }

    public class ResultsDriversUpdate2017 extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d("tag", "OnReceive");
            ResultsDriverAdapterNoPicture adapter = ((ResultsDriverAdapterNoPicture) rv.getAdapter());
            adapter.setNewResultsDriver(getResultsDriversFromFileWithoutPicture("drivers2017.json"));

        }
    }


    public class ResultsDriversUpdate2016 extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d("tag", "OnReceive");
            ResultsDriverAdapterNoPicture adapter = ((ResultsDriverAdapterNoPicture) rv.getAdapter());
            adapter.setNewResultsDriver(getResultsDriversFromFileWithoutPicture("drivers2016.json"));

        }
    }


    public class ResultsDriversUpdate2015 extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d("tag", "OnReceive");
            ResultsDriverAdapterNoPicture adapter = ((ResultsDriverAdapterNoPicture) rv.getAdapter());
            adapter.setNewResultsDriver(getResultsDriversFromFileWithoutPicture("drivers2015.json"));

        }
    }


    public class ResultsDriversUpdate2014 extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d("tag", "OnReceive");
            ResultsDriverAdapterNoPicture adapter = ((ResultsDriverAdapterNoPicture) rv.getAdapter());
            adapter.setNewResultsDriver(getResultsDriversFromFileWithoutPicture("drivers2014.json"));

        }
    }


    public class ResultsDriversUpdate2013 extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d("tag", "OnReceive");
            ResultsDriverAdapterNoPicture adapter = ((ResultsDriverAdapterNoPicture) rv.getAdapter());
            adapter.setNewResultsDriver(getResultsDriversFromFileWithoutPicture("drivers2013.json"));

        }
    }


    public JSONArray getResultsDriversFromFile(String child ) {
        try {
            InputStream is = new FileInputStream(getActivity().getCacheDir() + "/" + child);
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

    public JSONArray getResultsDriversFromFileWithoutPicture(String child) {
        try {
            InputStream is = new FileInputStream(getActivity().getCacheDir() + "/" + child);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            JSONObject jsonobjeect = new JSONObject(new String(buffer,"utf-8"));
            return new JSONArray(jsonobjeect.getJSONObject("MRData").getJSONObject("StandingsTable").getJSONArray("StandingsLists").getJSONObject(0).getString("DriverStandings"));
        } catch (IOException e) {
            e.printStackTrace();
            return new JSONArray();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new JSONArray();
    }
}
