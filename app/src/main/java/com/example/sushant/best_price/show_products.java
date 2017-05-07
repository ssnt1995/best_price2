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

import static com.example.sushant.best_price.R.id.brand_id;

public class show_products extends AppCompatActivity {
    RecyclerView r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_product_activity);

        r = (RecyclerView) findViewById(R.id.recycler_id);
        r.setLayoutManager(new LinearLayoutManager(show_products.this , LinearLayoutManager.VERTICAL,false));


        get_brands();
    }

    private void get_brands()
    {
        String brand_id = getIntent().getStringExtra("brand_id");

        JSONObject job = new JSONObject();

        try {
            job.put("brand_id", brand_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jobreq = new JsonObjectRequest("http://"+IpAddress.ip+"/products.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response);

                try {
                    JSONArray jsarr = response.getJSONArray("products");

                    product_adapter ad = new product_adapter(jsarr , show_products.this);

                    r.setAdapter(ad);

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

        AppController app = new AppController(show_products.this);

        app.addToRequestQueue(jobreq);
    }
}
