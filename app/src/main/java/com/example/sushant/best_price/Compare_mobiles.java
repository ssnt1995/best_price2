package com.example.sushant.best_price;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Compare_mobiles extends AppCompatActivity {

    Spinner first_spinner , second_spinner ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_mobiles);

        first_spinner = (Spinner) findViewById(R.id.first_mobile_spinner);
        second_spinner = (Spinner) findViewById(R.id.second_mobile_spinner);

        get_data();

    }

    public void close(View view) {
        finish();
    }


    public void get_data()
    {


        final JSONObject job = new JSONObject();

        try {
            job.put("category", "mobile");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jobreq = new JsonObjectRequest("http://"+IpAddress.ip+"/get_all_products.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response);

                try {
                    JSONArray jsarr = response.getJSONArray("products");

                    List<String> list = new ArrayList<>();

                    for(int i = 0 ; i < jsarr.length() ; i ++)
                    {
                        JSONObject jobj = jsarr.getJSONObject(i);
                        list.add(jobj.getString("Product_Name"));
                    }

                    ArrayAdapter<String> dataadapter = new ArrayAdapter<String>(Compare_mobiles.this , android.R.layout.simple_spinner_dropdown_item,list);

                    first_spinner.setAdapter(dataadapter);
                    second_spinner.setAdapter(dataadapter);



                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                System.out.println(error);

            }
        });

        jobreq.setRetryPolicy(new DefaultRetryPolicy(20000 , 2 , 2));

        AppController app = new AppController(Compare_mobiles.this);

        app.addToRequestQueue(jobreq);

    }

    public void do_comparison(View view) {

        Intent i = new Intent(Compare_mobiles.this , Mobile_comparison.class);
        startActivity(i);
        finish();
    }
}
