package com.example.avenflar.formula1.com.example.formula1.RecyclerView.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.example.avenflar.formula1.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class ResultsTeamsAdapter extends RecyclerView.Adapter<ResultsTeamsAdapter.ResultsTeamsHolder>{

    private JSONArray results;

    public ResultsTeamsAdapter(JSONArray results){
        this.results=results;

    }


    @Override
    public ResultsTeamsHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.rv_results_teams_elements,parent,false);
        return new ResultsTeamsHolder(view);
    }

    @Override
    public void onBindViewHolder(ResultsTeamsHolder holder,int position){
        try{
            JSONObject obj=results.getJSONObject(position);
            holder.display(obj);

        }catch(JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount(){
        return results.length();
    }

    public void setNewResultsTeams(JSONArray results){
        this.results=results;
        notifyDataSetChanged();
    }


    public class ResultsTeamsHolder extends RecyclerView.ViewHolder {
        private final TextView position;
        private final TextView team;
        private final TextView nationality;
        private final TextView points;
        private final TextView wins;


        public ResultsTeamsHolder(View view) {
            super(view);
            position = (TextView) itemView.findViewById(R.id.rv_res_t_position);
            team = (TextView) itemView.findViewById(R.id.rv_res_t_teams);
            nationality = (TextView) itemView.findViewById(R.id.rv_res_t_nationality);
            points = (TextView) itemView.findViewById(R.id.rv_res_t_points);
            wins = (TextView) itemView.findViewById(R.id.rv_res_t_wins);


        }

        public void display(JSONObject obj) {

            try {

                position.setText(obj.getString("position"));
                wins.setText(obj.getString("wins"));
                points.setText(obj.getString("points"));
                team.setText(obj.getJSONObject("Constructor").getString("name"));
                nationality.setText(obj.getJSONObject("Constructor").getString("nationality"));


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}
