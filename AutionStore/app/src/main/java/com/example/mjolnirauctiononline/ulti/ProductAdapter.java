package com.example.mjolnirauctiononline.ulti;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mjolnirauctiononline.ProductDetail;
import com.example.mjolnirauctiononline.R;
import com.example.mjolnirauctiononline.model.Product;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private final Context context;
    private LayoutInflater mInflater;
    private ArrayList<Product> productList;

    public ProductAdapter(Context context, ArrayList<Product> productList) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.productList = productList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView product_image;
        TextView txt_name_product, txt_current_price, txt_min_price, txt_max_price,txt_expire;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            product_image = itemView.findViewById(R.id.avatar_message_user);
            txt_name_product = itemView.findViewById(R.id.txt_name_product_row);
            txt_current_price = itemView.findViewById(R.id.txt_current_price_row);
            txt_min_price = itemView.findViewById(R.id.txt_min_price_row);
            txt_max_price = itemView.findViewById(R.id.txt_max_price_row);
            txt_expire = itemView.findViewById(R.id.txt_expire_row);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.product_row_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.txt_name_product.setText(product.getProductName());
        holder.txt_current_price.setText("$" + product.getCurrentPrice().toString());
        holder.txt_min_price.setText("$" + product.getMinPrice().toString());
        holder.txt_max_price.setText("$" + product.getMaxPrice().toString());
        holder.txt_expire.setText(product.getToDate().toString());
        holder.product_image.setImageResource(R.drawable.avatar1);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context,"The Item Clicked is: " + product.getProductID(),Toast.LENGTH_SHORT).show();
                final Intent intent;
                intent =  new Intent(context, ProductDetail.class);
                intent.setAction("custom-message");
                intent.putExtra("id",product.getProductID());
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }



}
