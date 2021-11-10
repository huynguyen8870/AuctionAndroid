package com.example.mjolnirauctiononline;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mjolnirauctiononline.view.user.UserFragment;

public class BalanceActivity extends AppCompatActivity {
    TextView txt_balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);

        Toolbar balanceTb = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(balanceTb);
        getSupportActionBar().setTitle("Balance");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        balanceTb.setNavigationOnClickListener(view -> onBackPressed());

        txt_balance = findViewById(R.id.txt_balance_in_page);

        SharedPreferences sp1=this.getSharedPreferences("Login", MODE_PRIVATE);

        String balance=sp1.getString("balance", null);

        txt_balance.setText("$" + balance);
    }

}