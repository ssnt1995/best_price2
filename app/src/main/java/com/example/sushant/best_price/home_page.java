package com.example.sushant.best_price;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import static android.R.attr.start;

public class home_page extends AppCompatActivity {


    DrawerLayout drawer_home ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        drawer_home = (DrawerLayout) findViewById(R.id.drawer_lay);

    }


 public void mobile(View v)
 {
     Intent i = new Intent(home_page.this , Show_brands.class);

     i.putExtra("category" , "mobile");

     startActivity(i);
 }

    public void bike(View v)
    {
        Intent i = new Intent(home_page.this , Show_brands.class);

        i.putExtra("category" , "bike");

        startActivity(i);
    }

    public void car (View v)
    {
        Intent i = new Intent(home_page.this , Show_brands.class);

        i.putExtra("category" , "car");

        startActivity(i);
    }

    public void laptop (View v)
    {
        Intent i = new Intent(home_page.this , Show_brands.class);

        i.putExtra("category" , "laptop");

        startActivity(i);
    }

    public void television (View v)
    {
        Intent i = new Intent(home_page.this , Show_brands.class);

        i.putExtra("category" , "television");

        startActivity(i);
    }

    public void shoes (View v)
    {
        Intent i = new Intent(home_page.this , Show_brands.class);

        i.putExtra("category" , "shoes");

        startActivity(i);
    }

    public void watches (View v)
    {
        Intent i = new Intent(home_page.this , Show_brands.class);

        i.putExtra("category" , "watches");

        startActivity(i);
    }

    public void camera (View v)
    {
        Intent i = new Intent(home_page.this , Show_brands.class);

        i.putExtra("category" , "camera");

        startActivity(i);
    }


    public void show_more(View view) {

        drawer_home.openDrawer(Gravity.LEFT);

    }

    public void compare_mobile(View view) {

        Intent i = new Intent(home_page.this , Compare_mobiles.class);

        startActivity(i);
    }

    public void compare_bikes(View view) {
        Intent i = new Intent(home_page.this , Compare_bikes.class);

        startActivity(i);
    }
}
