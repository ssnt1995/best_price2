package com.example.sushant.best_price;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Show_brands extends AppCompatActivity {

    RecyclerView r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_brands);

        r = (RecyclerView) findViewById(R.id.recycler_id);
        r.setLayoutManager(new LinearLayoutManager(Show_brands.this , LinearLayoutManager.VERTICAL,false));
        get_brands();
    }


    private void get_brands()
    {
        String category = getIntent().getStringExtra("category");

        JSONObject job = new JSONObject();

        try {
            job.put("category", category);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jobreq = new JsonObjectRequest("http://"+IpAddress.ip+"/brands.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jarr = response.getJSONArray("brands");

                    brand_adapter ad = new brand_adapter(jarr , Show_brands.this);

                    r.setAdapter(ad);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        jobreq.setRetryPolicy(new DefaultRetryPolicy(20000 , 2 , 2));

        AppController app = new AppController(Show_brands.this);

        app.addToRequestQueue(jobreq);
    }
}
