package com.example.mjolnirauctiononline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mjolnirauctiononline.ulti.ChatLineAdapter;

public class ChattingActivity extends AppCompatActivity {
    private RecyclerView messageRecycler;
    private ChatLineAdapter chatLineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        Toolbar balanceTb = (Toolbar) findViewById(R.id.chatting_toolbar);
        setSupportActionBar(balanceTb);
        getSupportActionBar().setTitle("Samsung_Official_Store");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        balanceTb.setNavigationOnClickListener(view -> onBackPressed());
    }
}