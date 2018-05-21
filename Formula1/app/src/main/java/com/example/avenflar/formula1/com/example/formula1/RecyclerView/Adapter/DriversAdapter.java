package com.example.avenflar.formula1.com.example.formula1.RecyclerView.Adapter;

import android.media.Image;
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
import org.w3c.dom.Text;

public class DriversAdapter extends RecyclerView.Adapter<DriversAdapter.DriversHolder>{
    private JSONArray results;
    private RequestManager glide;

    public DriversAdapter(JSONArray results, RequestManager glide){
        this.results=results;
        this.glide = glide;

    }


    @Override
    public DriversHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.rv_drivers_elements,parent,false);
        return new DriversHolder(view);
    }

    @Override
    public void onBindViewHolder(DriversHolder holder,int position){
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

    public void setNewDriver(JSONArray results){
        this.results=results;
        notifyDataSetChanged();
    }


    public class DriversHolder extends RecyclerView.ViewHolder { ;
        private final TextView driver;
        private final TextView number;
        private final ImageView picture;
        private final TextView team;
        private final ImageView flag;
        private final ImageView head;
        private final TextView country;
        private final TextView podiums;
        private final TextView points;
        private final TextView gp_entered;
        private final TextView wc;


        public DriversHolder(View view) {
            super(view);
            driver = (TextView) itemView.findViewById(R.id.rv_drivers_name);
            number = (TextView) itemView.findViewById(R.id.rv_drivers_number);
            picture = (ImageView) itemView.findViewById(R.id.rv_drivers_picture);
            team = (TextView) itemView.findViewById(R.id.rv_drivers_team);
            flag = (ImageView) itemView.findViewById(R.id.rv_drivers_flag);
            head = (ImageView) itemView.findViewById(R.id.rv_drivers_head);
            country = (TextView) itemView.findViewById(R.id.rv_drivers_country);
            podiums = (TextView) itemView.findViewById(R.id.rv_drivers_podiums);
            points = (TextView) itemView.findViewById(R.id.rv_drivers_points);
            gp_entered = (TextView) itemView.findViewById(R.id.rv_drivers_gp_entered);
            wc = (TextView) itemView.findViewById(R.id.rv_drivers_wc);


        }

        public void display(JSONObject obj,RequestManager glide) {

            try {

                driver.setText(obj.getString("name"));
                number.setText(obj.getString("number"));
                glide.load(obj.getString("Face")).into(picture);
                glide.load(obj.getString("Flag")).into(flag);
                glide.load(obj.getString("headset")).into(head);
                team.setText(obj.getString("Team"));
                country.setText(obj.getString("Country"));
                podiums.setText(obj.getString("Podiums"));
                points.setText(obj.getString("Points"));
                gp_entered.setText(obj.getString("Grands Prix entered"));
                wc.setText(obj.getString("World Championships"));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}
