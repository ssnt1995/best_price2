package com.example.sushant.best_price;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by SUSHANT on 18-Apr-17.
 */

public class brand_view_holder extends RecyclerView.ViewHolder {

    public TextView brand_text,brand_description , founded ;

    public LinearLayout brand_cell;

    public ImageView brand_image;


    public brand_view_holder(View itemView) {
        super(itemView);

        brand_text = (TextView) itemView.findViewById(R.id.brand_id);
        brand_description = (TextView) itemView.findViewById(R.id.description);

        founded = (TextView) itemView.findViewById(R.id.founded);

        brand_image = (ImageView) itemView.findViewById(R.id.brand_image);
    }
}
