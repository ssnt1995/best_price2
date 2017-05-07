package com.example.sushant.best_price;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class admin_home extends AppCompatActivity {

    EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        email=(EditText)findViewById(R.id.admin_username);
        password=(EditText)findViewById(R.id.admin_password);
    }

    public void login(View v)
    {
        String emailval = email.getText().toString();
        String passval = password.getText().toString();


        if(emailval.equals(""))
        {
            Toast.makeText(admin_home.this,"please enter email",Toast.LENGTH_SHORT).show();
            return;
        }

        if(passval.equals(""))
        {
            Toast.makeText(admin_home.this,"please enter password",Toast.LENGTH_SHORT).show();
            return;
        }

        JSONObject jobj = new JSONObject();
        try {
            jobj.put("email_key",emailval);
            jobj.put("pass_key" , passval);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jobjreq = new JsonObjectRequest("http://"+IpAddress.ip+"/login.php", jobj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    if(response.getString("key").equals("done"))
                    {


                        Intent i = new Intent(admin_home.this , admin_homepage.class);
                        startActivity(i);
                        finish();
                    }

                    else {
                        Toast.makeText(admin_home.this , "error try again" , Toast.LENGTH_SHORT).show();
                    }
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

        jobjreq.setRetryPolicy(new DefaultRetryPolicy(20000 , 3 , 2));

        AppController app = new AppController(admin_home.this);

        app.addToRequestQueue(jobjreq);


    }


    }
