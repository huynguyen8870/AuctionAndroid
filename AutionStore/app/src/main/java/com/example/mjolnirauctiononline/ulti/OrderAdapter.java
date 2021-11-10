package com.example.mjolnirauctiononline.ulti;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mjolnirauctiononline.ProductDetail;
import com.example.mjolnirauctiononline.R;
import com.example.mjolnirauctiononline.model.Bid;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private final Context context;
    private LayoutInflater mInflater;
    private List<Bid> orders;

    public OrderAdapter(Context context, List<Bid> orders) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.orders = orders;
    }

    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.order_row,parent,false);
        return new OrderAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, int position) {
        Bid order = orders.get(position);
        holder.order_product_image.setImageResource(R.drawable.avatar1);
        holder.order_product_name.setText(order.getProductID());
        holder.order_product_price.setText("$" + order.getPrice());
        holder.order_bid_expire.setText(order.getProductID());
        holder.order_bid_status.setText(order.getStatus());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent;
                intent =  new Intent(context, ProductDetail.class);
//                intent.setAction("custom-message");
//                intent.putExtra("ProductName",product.getProductName());
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView order_product_image;
        TextView order_product_name, order_product_price, order_bid_expire,order_bid_status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            order_product_image = itemView.findViewById(R.id.Image_order_product);
            order_product_name = itemView.findViewById(R.id.txt_order_product_name);
            order_product_price = itemView.findViewById(R.id.txt_order_price);
            order_bid_expire = itemView.findViewById(R.id.txt_order_bid_expire);
            order_bid_status = itemView.findViewById(R.id.txt_order_status);
        }
    }
}
