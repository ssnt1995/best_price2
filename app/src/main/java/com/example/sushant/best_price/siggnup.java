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

public class siggnup extends AppCompatActivity {

    EditText name,email,password,confirm_password,contact_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.siggnup);

        name = (EditText)findViewById(R.id.name);
        email = (EditText) findViewById(R.id.emailadd);
        password = (EditText)findViewById(R.id.passwordsign);
        confirm_password = (EditText)findViewById(R.id.confirm);
        contact_no = (EditText)findViewById(R.id.contact);
    }


    public void signup (View v)
    {
        String names = name.getText().toString();
        String emails = email.getText().toString();
        String passwords = password.getText().toString();
        String confirms = confirm_password.getText().toString();
        String contacts = contact_no.getText().toString();
        if(names.equals(""))
        {
            Toast.makeText(siggnup.this,"please enter name",Toast.LENGTH_SHORT).show();
            return;
        }

        if(emails.equals(""))
        {
            Toast.makeText(siggnup.this,"please enter email",Toast.LENGTH_SHORT).show();
            return;
        }

        if(passwords.equals(""))
        {
            Toast.makeText(siggnup.this,"please enter password",Toast.LENGTH_SHORT).show();
            return;
        }

        if(confirms.equals(""))
        {
            Toast.makeText(siggnup.this,"please enter confirm password",Toast.LENGTH_SHORT).show();
            return;
        }

        if(contacts.equals(""))
        {
            Toast.makeText(siggnup.this,"please enter contact no.",Toast.LENGTH_SHORT).show();
            return;
        }

        if ( ! passwords.equals(confirms))
        {

            Toast.makeText(siggnup.this,"password do not match.",Toast.LENGTH_SHORT).show();
            return;

        }

        JSONObject signj = new JSONObject();

        try {
            signj.put("names_key",names);
            signj.put("emails_key",emails);
            signj.put("passwords_key",passwords);
            signj.put("contacts_key",contacts);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println(signj);
        JsonObjectRequest signreq = new JsonObjectRequest("http://192.168.0.30/signup.php", signj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)

            {
                Toast.makeText(siggnup.this,"signup done",Toast.LENGTH_SHORT).show();


                Intent i = new Intent(siggnup.this,Best_price.class);
                startActivity(i);


            }
        }, new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });



        signreq.setRetryPolicy(new DefaultRetryPolicy(20000,2,3));

        AppController signs = new AppController(siggnup.this);

        signs.addToRequestQueue(signreq);



    }
}