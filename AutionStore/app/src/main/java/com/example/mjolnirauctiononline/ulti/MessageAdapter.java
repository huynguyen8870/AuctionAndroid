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

import com.example.mjolnirauctiononline.ChattingActivity;
import com.example.mjolnirauctiononline.ProductDetail;
import com.example.mjolnirauctiononline.R;
import com.example.mjolnirauctiononline.model.Chat;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    private final Context context;
    private LayoutInflater mInflater;
    private List<Chat> MessageList;

    public MessageAdapter(Context context, List<Chat> messageList) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        MessageList = messageList;
    }

    @Override
    public int getItemCount() {
        return  MessageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar_message_user;
        TextView txt_sender_name,txt_recent_message;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar_message_user = itemView.findViewById(R.id.avatar_message_user);
            txt_sender_name = itemView.findViewById(R.id.txt_message_name_user);
            txt_recent_message = itemView.findViewById(R.id.txt_recent_message);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.message_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Chat message = MessageList.get(position);
        holder.avatar_message_user.setImageResource(R.drawable.avatar1);
        holder.txt_sender_name.setText(message.getVendorID());
        holder.txt_recent_message.setText(message.getChatID());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent;
                intent =  new Intent(context, ChattingActivity.class);
//                intent.setAction("custom-message");
//                intent.putExtra("ProductName",product.getProductName());
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                context.startActivity(intent);
            }
        });
    }

}
