package com.example.sushant.best_price;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class start_layout extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_layout);
        Handler hn = new Handler();
        hn.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(start_layout.this,Best_price.class);
                startActivity(i);
            }
        },3000);

    }
}
