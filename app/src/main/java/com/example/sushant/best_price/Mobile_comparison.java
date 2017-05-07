package com.example.sushant.best_price;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Mobile_comparison extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_comparison);
    }

    public void go_home(View view) {
        finish();
    }
}
