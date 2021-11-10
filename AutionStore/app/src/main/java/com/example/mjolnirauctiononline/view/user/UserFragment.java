package com.example.mjolnirauctiononline.view.user;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mjolnirauctiononline.BalanceActivity;
import com.example.mjolnirauctiononline.ChangePasswordActivity;
import com.example.mjolnirauctiononline.LoginActivity;
import com.example.mjolnirauctiononline.ProfileActivity;
import com.example.mjolnirauctiononline.R;
import com.example.mjolnirauctiononline.RegisterActivity;

public class UserFragment extends Fragment {
    Button btn_log, btn_res, btn_balance, btn_profile, btn_change_password;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_log = view.findViewById(R.id.btn_login_test);
        btn_res = view.findViewById(R.id.btn_register_test);
        btn_balance = view.findViewById(R.id.btn_balance);
        btn_profile = view.findViewById(R.id.btn_profile);
        btn_change_password = view.findViewById(R.id.btn_change_password);



        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        btn_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        btn_balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), BalanceActivity.class);
                startActivity(intent);
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        btn_change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ChangePasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}