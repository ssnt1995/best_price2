package com.example.sushant.best_price;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by SUSHANT on 18-Apr-17.
 */

public class brand_adapter extends RecyclerView.Adapter<brand_view_holder> {

    JSONArray jarr;
    Activity a;
    public brand_adapter(JSONArray jarr , Activity a)
    {
        this.jarr = jarr;
        this.a = a;
    }
    @Override
    public brand_view_holder onCreateViewHolder(ViewGroup parent, int viewType) {
       brand_view_holder  b = new brand_view_holder(LayoutInflater.from(a).inflate(R.layout.brand_cell,parent,false));

        return b;
    }

    @Override
    public void onBindViewHolder(brand_view_holder holder, int position) {

        try {
            final JSONObject job = jarr.getJSONObject(position);

            holder.brand_text.setText(job.getString("name"));
            holder.brand_image.setImageBitmap(StringToBitMap(job.getString("image")));
            holder.established.setText(job.getString("established_on"));
            holder.brand_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(a , show_products.class);
                    try {
                        i.putExtra("brand_id",job.getString("brand_id"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    a.startActivity(i);
                }
            });
            holder.brand_description.setText(job.getString("description"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return jarr.length();
    }



    public Bitmap StringToBitMap(String encodedString){
        try{
            byte [] encodeByte=Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        }catch(Exception e){
            e.getMessage();
            return null;
        }
    }
}
