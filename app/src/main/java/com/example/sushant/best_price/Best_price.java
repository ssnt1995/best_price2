package com.example.sushant.best_price;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Best_price extends AppCompatActivity {
    EditText email,password;
    TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.best_price);


        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        signup = (TextView) findViewById(R.id.account);
    }

    public  void signup (View v)
    {
        Intent i = new Intent(Best_price.this,siggnup.class);
        startActivity(i);
        finish();
    }

    public void login(View v)
    {
        String emailval = email.getText().toString();
        String passval = password.getText().toString();


        if(emailval.equals(""))
        {
            Toast.makeText(Best_price.this,"please enter email",Toast.LENGTH_SHORT).show();
            return;
        }

        if(passval.equals(""))
        {
            Toast.makeText(Best_price.this,"please enter password",Toast.LENGTH_SHORT).show();
            return;
        }

        JSONObject jobj = new JSONObject();

        try {
            jobj.put("email_key",emailval);
            jobj.put("pass_key" , passval);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jobjreq = new JsonObjectRequest("http://192.168.0.25/login.php", jobj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    if(response.getString("key").equals("done"))
                    {


                        Intent i = new Intent(Best_price.this , home_page.class);
                        startActivity(i);
                        finish();
                    }

                    else {
                        Toast.makeText(Best_price.this , "error try again" , Toast.LENGTH_SHORT).show();
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

        AppController app = new AppController(Best_price.this);

        app.addToRequestQueue(jobjreq);


    }
}