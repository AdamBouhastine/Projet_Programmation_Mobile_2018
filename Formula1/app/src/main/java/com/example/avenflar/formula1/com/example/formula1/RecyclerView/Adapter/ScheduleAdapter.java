package com.example.avenflar.formula1.com.example.formula1.RecyclerView.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.avenflar.formula1.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleHolder> {

    private JSONArray schedule;
    private RequestManager glide;

    public ScheduleAdapter(JSONArray schedule,RequestManager glide){
        this.schedule=schedule;
        this.glide = glide;

    }


    @Override
    public ScheduleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_schedule_elements,parent,false);
        return new ScheduleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleHolder holder, int position) {
        try {
            JSONObject obj = schedule.getJSONObject(position);
            holder.display(obj,glide);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return schedule.length();
    }

    public void setNewSchedule(JSONArray schedule){
        this.schedule=schedule;
        notifyDataSetChanged();
    }



    public class ScheduleHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView date;
        private  final ImageView picture;



        public ScheduleHolder(View view) {
            super(view);
            name = (TextView) itemView.findViewById(R.id.rv_name);
            date= (TextView) itemView.findViewById(R.id.rv_date);

            picture =(ImageView) itemView.findViewById(R.id.rv_picture);


        }

        public void display(JSONObject obj,RequestManager glide) {

            try {

                name.setText(obj.getString("name"));
                date.setText(obj.getString("start"));
                glide.load(obj.getString("background")).apply(RequestOptions.circleCropTransform()).into(picture);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}


