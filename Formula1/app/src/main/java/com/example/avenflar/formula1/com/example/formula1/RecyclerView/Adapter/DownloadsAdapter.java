package com.example.avenflar.formula1.com.example.formula1.RecyclerView.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.example.avenflar.formula1.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadsAdapter extends RecyclerView.Adapter<DownloadsAdapter.DownloadsHolder>{

    private JSONArray results;
    private RequestManager glide;

    public DownloadsAdapter(JSONArray results,RequestManager glide){
        this.results=results;
        this.glide = glide;

    }


    @Override
    public DownloadsHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.rv_downloads_elements,parent,false);
        return new DownloadsHolder(view);
    }

    @Override
    public void onBindViewHolder(DownloadsHolder holder,int position){
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

    public void setNew(JSONArray results){
        this.results=results;
        notifyDataSetChanged();
    }


    public class DownloadsHolder extends RecyclerView.ViewHolder {
        private final ImageView logo;
        private final ImageView picture;


        public DownloadsHolder(View view) {
            super(view);
            logo = (ImageView) itemView.findViewById(R.id.rv_downloads_logo);
            picture = (ImageView) itemView.findViewById(R.id.rv_downloads_picutre);
        }

        public void display(JSONObject obj,RequestManager glide) {

            try {
                glide.load(obj.getString("name")).into(logo);
                glide.load(obj.getString("image")).into(picture);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}
