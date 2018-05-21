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

import com.example.avenflar.formula1.R;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.Adapter.ResultsTeamsAdapter;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.GetServices.TeamsServices.GetResultsTeamsService2015;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.GetServices.TeamsServices.GetResultsTeamsServices;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.GetServices.TeamsServices.GetResultsTeamsServices2013;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.GetServices.TeamsServices.GetResultsTeamsServices2014;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.GetServices.TeamsServices.GetResultsTeamsServices2016;
import com.example.avenflar.formula1.com.example.formula1.RecyclerView.GetServices.TeamsServices.GetResultsTeamsServices2017;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResultsTeamsFragment2018 extends Fragment {


    private RecyclerView rv;
    TextView teams_2018;
    TextView teams_2017;
    TextView teams_2016;
    TextView teams_2015;
    TextView teams_2014;
    TextView teams_2013;

    public static android.support.v4.app.Fragment newInstance() {
        return new ResultsTeamsFragment2018();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_results_teams_2018, container, false);


        IntentFilter intentFilter = new IntentFilter("Teams Update");
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(new ResultsTeamsUpdate2018(), intentFilter);
        GetResultsTeamsServices.startAction(getActivity());

        rv = (RecyclerView) view.findViewById(R.id.rv_results_teams);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new ResultsTeamsAdapter(getResultsTeamsFromFile("teams.json")));

        final TextView title = (TextView) view.findViewById(R.id.Title);

        teams_2018 = (TextView) view.findViewById(R.id.teams_2018);
        teams_2018.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentFilter intentFilter = new IntentFilter("Teams Update");
                LocalBroadcastManager.getInstance(getActivity()).registerReceiver(new ResultsTeamsUpdate2018(), intentFilter);
                GetResultsTeamsServices.startAction(getActivity());

                rv = (RecyclerView) view.findViewById(R.id.rv_results_teams);
                rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                rv.setAdapter(new ResultsTeamsAdapter(getResultsTeamsFromFile("teams.json")));
                title.setText(R.string.standings_teams_2018);
                teams_2018.setTextColor(getResources().getColor(R.color.Primaire));
                teams_2018.setBackground(getResources().getDrawable(R.color.white));
                teams_2017.setTextColor(getResources().getColor(R.color.white));
                teams_2017.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2016.setTextColor(getResources().getColor(R.color.white));
                teams_2016.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2015.setTextColor(getResources().getColor(R.color.white));
                teams_2015.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2014.setTextColor(getResources().getColor(R.color.white));
                teams_2014.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2013.setTextColor(getResources().getColor(R.color.white));
                teams_2013.setBackground(getResources().getDrawable(R.color.Primaire));


            }
        });


        teams_2017 = (TextView) view.findViewById(R.id.teams_2017);
        teams_2017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentFilter intentFilter = new IntentFilter("Teams Update 2017");
                LocalBroadcastManager.getInstance(getActivity()).registerReceiver(new ResultsTeamsUpdate2017(), intentFilter);
                GetResultsTeamsServices2017.startAction(getActivity());

                rv = (RecyclerView) view.findViewById(R.id.rv_results_teams);
                rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                rv.setAdapter(new ResultsTeamsAdapter(getResultsTeamsFromFile("teams2017.json")));
                title.setText(R.string.standings_teams_2017);
                teams_2017.setTextColor(getResources().getColor(R.color.Primaire));
                teams_2017.setBackground(getResources().getDrawable(R.color.white));
                teams_2018.setTextColor(getResources().getColor(R.color.white));
                teams_2018.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2016.setTextColor(getResources().getColor(R.color.white));
                teams_2016.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2015.setTextColor(getResources().getColor(R.color.white));
                teams_2015.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2014.setTextColor(getResources().getColor(R.color.white));
                teams_2014.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2013.setTextColor(getResources().getColor(R.color.white));
                teams_2013.setBackground(getResources().getDrawable(R.color.Primaire));
            }
        });


        teams_2016 = (TextView) view.findViewById(R.id.teams_2016);
        teams_2016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentFilter intentFilter = new IntentFilter("Teams Update 2016");
                LocalBroadcastManager.getInstance(getActivity()).registerReceiver(new ResultsTeamsUpdate2016(), intentFilter);
                GetResultsTeamsServices2016.startAction(getActivity());

                rv = (RecyclerView) view.findViewById(R.id.rv_results_teams);
                rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                rv.setAdapter(new ResultsTeamsAdapter(getResultsTeamsFromFile("teams2016.json")));
                title.setText(R.string.standings_teams_2016);
                teams_2016.setTextColor(getResources().getColor(R.color.Primaire));
                teams_2016.setBackground(getResources().getDrawable(R.color.white));
                teams_2018.setTextColor(getResources().getColor(R.color.white));
                teams_2018.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2017.setTextColor(getResources().getColor(R.color.white));
                teams_2017.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2015.setTextColor(getResources().getColor(R.color.white));
                teams_2015.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2014.setTextColor(getResources().getColor(R.color.white));
                teams_2014.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2013.setTextColor(getResources().getColor(R.color.white));
                teams_2013.setBackground(getResources().getDrawable(R.color.Primaire));
            }
        });

        teams_2015 = (TextView) view.findViewById(R.id.teams_2015);
        teams_2015.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentFilter intentFilter = new IntentFilter("Teams Update 2015");
                LocalBroadcastManager.getInstance(getActivity()).registerReceiver(new ResultsTeamsUpdate2015(), intentFilter);
                GetResultsTeamsService2015.startAction(getActivity());

                rv = (RecyclerView) view.findViewById(R.id.rv_results_teams);
                rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                rv.setAdapter(new ResultsTeamsAdapter(getResultsTeamsFromFile("teams2015.json")));
                title.setText(R.string.standings_teams_2015);
                teams_2015.setTextColor(getResources().getColor(R.color.Primaire));
                teams_2015.setBackground(getResources().getDrawable(R.color.white));
                teams_2018.setTextColor(getResources().getColor(R.color.white));
                teams_2018.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2017.setTextColor(getResources().getColor(R.color.white));
                teams_2017.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2016.setTextColor(getResources().getColor(R.color.white));
                teams_2016.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2014.setTextColor(getResources().getColor(R.color.white));
                teams_2014.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2013.setTextColor(getResources().getColor(R.color.white));
                teams_2013.setBackground(getResources().getDrawable(R.color.Primaire));
            }
        });

        teams_2014 = (TextView) view.findViewById(R.id.teams_2014);
        teams_2014.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentFilter intentFilter = new IntentFilter("Teams Update 2014");
                LocalBroadcastManager.getInstance(getActivity()).registerReceiver(new ResultsTeamsUpdate2014(), intentFilter);
                GetResultsTeamsServices2014.startAction(getActivity());

                rv = (RecyclerView) view.findViewById(R.id.rv_results_teams);
                rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                rv.setAdapter(new ResultsTeamsAdapter(getResultsTeamsFromFile("teams2014.json")));
                title.setText(R.string.standings_teams_2014);
                teams_2014.setTextColor(getResources().getColor(R.color.Primaire));
                teams_2014.setBackground(getResources().getDrawable(R.color.white));
                teams_2018.setTextColor(getResources().getColor(R.color.white));
                teams_2018.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2017.setTextColor(getResources().getColor(R.color.white));
                teams_2017.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2016.setTextColor(getResources().getColor(R.color.white));
                teams_2016.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2015.setTextColor(getResources().getColor(R.color.white));
                teams_2015.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2013.setTextColor(getResources().getColor(R.color.white));
                teams_2013.setBackground(getResources().getDrawable(R.color.Primaire));
            }
        });

        teams_2013 = (TextView) view.findViewById(R.id.teams_2013);
        teams_2013.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentFilter intentFilter = new IntentFilter("Teams Update 2013");
                LocalBroadcastManager.getInstance(getActivity()).registerReceiver(new ResultsTeamsUpdate2013(), intentFilter);
                GetResultsTeamsServices2013.startAction(getActivity());

                rv = (RecyclerView) view.findViewById(R.id.rv_results_teams);
                rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                rv.setAdapter(new ResultsTeamsAdapter(getResultsTeamsFromFile("teams2013.json")));
                title.setText(R.string.standings_teams_2013);
                teams_2013.setTextColor(getResources().getColor(R.color.Primaire));
                teams_2013.setBackground(getResources().getDrawable(R.color.white));
                teams_2018.setTextColor(getResources().getColor(R.color.white));
                teams_2018.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2017.setTextColor(getResources().getColor(R.color.white));
                teams_2017.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2016.setTextColor(getResources().getColor(R.color.white));
                teams_2016.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2015.setTextColor(getResources().getColor(R.color.white));
                teams_2015.setBackground(getResources().getDrawable(R.color.Primaire));
                teams_2014.setTextColor(getResources().getColor(R.color.white));
                teams_2014.setBackground(getResources().getDrawable(R.color.Primaire));
            }
        });

        return view;
    }

    public class ResultsTeamsUpdate2018 extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d("tag", "OnReceive");
            ResultsTeamsAdapter adapter = ((ResultsTeamsAdapter) rv.getAdapter());
            adapter.setNewResultsTeams(getResultsTeamsFromFile("teams.json"));

        }
    }

    public class ResultsTeamsUpdate2017 extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d("tag", "OnReceive");
            ResultsTeamsAdapter adapter = ((ResultsTeamsAdapter) rv.getAdapter());
            adapter.setNewResultsTeams(getResultsTeamsFromFile("teams2017.json"));

        }
    }

    public class ResultsTeamsUpdate2016 extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d("tag", "OnReceive");
            ResultsTeamsAdapter adapter = ((ResultsTeamsAdapter) rv.getAdapter());
            adapter.setNewResultsTeams(getResultsTeamsFromFile("teams2016.json"));

        }
    }
    public class ResultsTeamsUpdate2015 extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d("tag", "OnReceive");
            ResultsTeamsAdapter adapter = ((ResultsTeamsAdapter) rv.getAdapter());
            adapter.setNewResultsTeams(getResultsTeamsFromFile("teams2015.json"));

        }
    }

    public class ResultsTeamsUpdate2014 extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d("tag", "OnReceive");
            ResultsTeamsAdapter adapter = ((ResultsTeamsAdapter) rv.getAdapter());
            adapter.setNewResultsTeams(getResultsTeamsFromFile("teams2014.json"));

        }
    }

    public class ResultsTeamsUpdate2013 extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d("tag", "OnReceive");
            ResultsTeamsAdapter adapter = ((ResultsTeamsAdapter) rv.getAdapter());
            adapter.setNewResultsTeams(getResultsTeamsFromFile("teams2013.json"));

        }
    }

    public JSONArray getResultsTeamsFromFile(String child) {
        try {
            InputStream is = new FileInputStream(getActivity().getCacheDir() + "/" + child);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            JSONObject jsonobjeect = new JSONObject(new String(buffer,"utf-8"));
            return new JSONArray(jsonobjeect.getJSONObject("MRData").getJSONObject("StandingsTable").getJSONArray("StandingsLists").getJSONObject(0).getString("ConstructorStandings"));
        } catch (IOException e) {
            e.printStackTrace();
            return new JSONArray();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new JSONArray();
    }

}
