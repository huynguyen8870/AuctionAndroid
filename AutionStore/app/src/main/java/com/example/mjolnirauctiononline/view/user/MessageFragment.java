package com.example.mjolnirauctiononline.view.user;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mjolnirauctiononline.R;
import com.example.mjolnirauctiononline.model.Chat;
import com.example.mjolnirauctiononline.ulti.MessageAdapter;

import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflatedView =  inflater.inflate(R.layout.fragment_message, container, false);

        Toolbar messageTb = (Toolbar) inflatedView.findViewById(R.id.message_toolbar);
        messageTb.setTitle("Message");

        return inflatedView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rv_message = view.findViewById(R.id.rv_messageList);

        List<Chat> chatList = new ArrayList<>();
        chatList.add(new Chat("C-01","Cus-01","Ven-01","Active"));
        chatList.add(new Chat("C-01","Cus-01","Ven-01","Active"));
        chatList.add(new Chat("C-01","Cus-01","Ven-01","Active"));
        chatList.add(new Chat("C-01","Cus-01","Ven-01","Active"));
        chatList.add(new Chat("C-01","Cus-01","Ven-01","Active"));
        chatList.add(new Chat("C-01","Cus-01","Ven-01","Active"));

        MessageAdapter messageAdapter = new MessageAdapter(getContext(),chatList);
        rv_message.setAdapter(messageAdapter);
    }
}