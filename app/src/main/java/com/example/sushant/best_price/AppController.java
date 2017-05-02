package com.example.sushant.best_price;




/**
 * Created by DELL on 4/6/2017.
 */



        import android.content.Context;

        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.toolbox.Volley;


public class AppController  {

    private RequestQueue mRequestQueue;

    private Context c;


    private static AppController mInstance;

    public AppController(Context c)
    {
        mInstance = this;
        this.c = c;

    }

    public static synchronized AppController getInstance()
    {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null)
        {
            mRequestQueue = Volley.newRequestQueue(c);
        }

        return mRequestQueue;
    }



    public  void addToRequestQueue(Request req) {

        getRequestQueue().add(req);
    }


}