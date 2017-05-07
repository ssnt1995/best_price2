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
 * Created by SUSHANT on 19-Apr-17.
 */

public class product_adapter extends RecyclerView.Adapter<product_view_holder>



{
    JSONArray jsarr;
    Activity a;

    public product_adapter(JSONArray jsarr , Activity a)
    {
        this.jsarr = jsarr;
        this.a = a;

    }
    @Override
    public product_view_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        product_view_holder  b = new product_view_holder(LayoutInflater.from(a).inflate(R.layout.product_cell,parent,false));

        return b;
    }

    @Override
    public void onBindViewHolder(product_view_holder holder, int position) {
        try {
            final JSONObject job = jsarr.getJSONObject(position);

            holder.product_name.setText(job.getString("Product_Name"));
            holder.product_image.setImageBitmap(StringToBitMap(job.getString("image")));

            holder.product_price.setText(job.getString("Price"));
            holder.product_description.setText(job.getString("Product_Details"));

        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

    @Override
    public int getItemCount() {
        return jsarr.length();
    }


    public Bitmap StringToBitMap(String encodedString){
        try{
            byte [] encodeByte= Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        }catch(Exception e){
            e.getMessage();
            return null;
        }
    }
}
