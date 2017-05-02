package com.example.sushant.best_price;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by SUSHANT on 19-Apr-17.
 */

public class product_view_holder extends RecyclerView.ViewHolder {
  public   TextView product_name,product_price;

  public ImageView product_image;

  public TextView product_description;

  public product_view_holder(View itemView) {
    super(itemView);

    product_name = (TextView) itemView.findViewById(R.id.product_name);
    product_price = (TextView) itemView.findViewById(R.id.product_price);

    product_image = (ImageView) itemView.findViewById(R.id.product_image);
    product_description = (TextView)itemView.findViewById(R.id.product_description);
  }
}
