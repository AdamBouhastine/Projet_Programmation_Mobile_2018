package com.example.avenflar.formula1.com.example.formula1.RecyclerView.Adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.RequestManager;
import com.example.avenflar.formula1.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ResultsDriverAdapter extends RecyclerView.Adapter<ResultsDriverAdapter.ResultsDriverHolder>{

    private JSONArray results;
    private RequestManager glide;

    public ResultsDriverAdapter(JSONArray results,RequestManager glide){
            this.results=results;
            this.glide = glide;

            }


        @Override
        public ResultsDriverHolder onCreateViewHolder(ViewGroup parent, int viewType){
                LayoutInflater inflater=LayoutInflater.from(parent.getContext());
                View view=inflater.inflate(R.layout.rv_results_drivers_elements,parent,false);
                return new ResultsDriverHolder(view);
                }

    @Override
    public void onBindViewHolder(ResultsDriverHolder holder,int position){
            try{
            JSONObject obj=results.getJSONObject(position);
            holder.display(obj,glide);

            }catch(JSONException e){
            e.printStackTrace();
            }
            }

    @Override
    public int getItemCount(){
            return results.length();
            }

    public void setNewResultsDriver(JSONArray results){
            this.results=results;
            notifyDataSetChanged();
            }


    public class ResultsDriverHolder extends RecyclerView.ViewHolder {
        private final TextView position;
        private final TextView driver;
        private final TextView nationality;
        private final ImageView car;
        private final TextView points;


        public ResultsDriverHolder(View view) {
            super(view);
            position = (TextView) itemView.findViewById(R.id.rv_res_d_position);
            driver = (TextView) itemView.findViewById(R.id.rv_res_d_drivers);
            nationality = (TextView) itemView.findViewById(R.id.rv_res_d_nationality);
            car = (ImageView) itemView.findViewById(R.id.rv_res_d_car);
            points = (TextView) itemView.findViewById(R.id.rv_res_d_points);


        }

        public void display(JSONObject obj,RequestManager glide) {

            try {

                position.setText(obj.getString("pos"));
                driver.setText(obj.getString("driver"));
                nationality.setText(obj.getString("nat"));
                glide.load(obj.getString("car")).into(car);
                points.setText(obj.getString("pts"));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}
