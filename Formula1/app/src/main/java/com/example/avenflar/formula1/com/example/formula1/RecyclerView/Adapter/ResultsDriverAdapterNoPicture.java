package com.example.avenflar.formula1.com.example.formula1.RecyclerView.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
;
import com.example.avenflar.formula1.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResultsDriverAdapterNoPicture extends RecyclerView.Adapter<ResultsDriverAdapterNoPicture.ResultsDriverHolderNoPicture>{

    private JSONArray results;

    public ResultsDriverAdapterNoPicture(JSONArray results){
        this.results=results;


    }


    @Override
    public ResultsDriverHolderNoPicture onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.rv_results_drivers_elements_no_picture,parent,false);
        return new ResultsDriverHolderNoPicture(view);
    }



    @Override
    public void onBindViewHolder(ResultsDriverHolderNoPicture holder, int position){
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


    public void setNewResultsDriver(JSONArray results){
        this.results=results;
        notifyDataSetChanged();
    }


    public class ResultsDriverHolderNoPicture extends RecyclerView.ViewHolder {
        private final TextView position;
        private final TextView driver;
        private final TextView nationality;
        private final TextView car;
        private final TextView points;


        public ResultsDriverHolderNoPicture(View view) {
            super(view);
            position = (TextView) itemView.findViewById(R.id.rv_res_d_position);
            driver = (TextView) itemView.findViewById(R.id.rv_res_d_drivers);
            nationality = (TextView) itemView.findViewById(R.id.rv_res_d_nationality);
            car = (TextView) itemView.findViewById(R.id.rv_res_d_car);
            points = (TextView) itemView.findViewById(R.id.rv_res_d_points);


        }

        public void display(JSONObject obj) {

            try {

                position.setText(obj.getString("position"));
                driver.setText(obj.getJSONObject("Driver").getString("familyName"));
                nationality.setText(obj.getJSONObject("Driver").getString("nationality"));
                car.setText(obj.getJSONArray("Constructors").getJSONObject(0).getString("name"));
                points.setText(obj.getString("points"));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}
