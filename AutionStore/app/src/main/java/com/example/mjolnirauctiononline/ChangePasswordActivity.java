package com.example.mjolnirauctiononline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mjolnirauctiononline.ulti.AccountDataService;

public class ChangePasswordActivity extends AppCompatActivity {
    EditText et_old_pwd, et_new_pwd, et_confirm_pwd;
    Button btn_change_pwd;
    TextView txt_error_old_pwd, txt_error_confirm_password;
    String old_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        Toolbar profileTb = (Toolbar) findViewById(R.id.password_change_toolbar);
        setSupportActionBar(profileTb);
        getSupportActionBar().setTitle("Change Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        profileTb.setNavigationOnClickListener(view -> onBackPressed());

        String accountId = "A-02";

        et_old_pwd = findViewById(R.id.et_pwd_old);
        et_new_pwd = findViewById(R.id.et_pwd_new);
        et_confirm_pwd = findViewById(R.id.et_pwd_confirm);

        txt_error_old_pwd = findViewById(R.id.txt_error_old_pwd);
        txt_error_confirm_password = findViewById(R.id.txt_error_confirm_pwd);

        final AccountDataService accountDataService = new AccountDataService(ChangePasswordActivity.this);
        accountDataService.getPassword(accountId, new AccountDataService.PasswordResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(ChangePasswordActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(String password) {
                old_pwd = password;
            }
        });

        btn_change_pwd = findViewById(R.id.btn_pwd_change);
        btn_change_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_old_pwd = et_old_pwd.getText().toString();
                txt_error_old_pwd.setText("");
                txt_error_confirm_password.setText("");
                if(!txt_old_pwd.equals(old_pwd)){
                    txt_error_old_pwd.setText("Old password doesn't match!");
                } else {
                    String new_pwd = et_new_pwd.getText().toString();
                    String confirm_pwd = et_confirm_pwd.getText().toString();
                    if(!new_pwd.equals(confirm_pwd)){
                        txt_error_confirm_password.setText("Confirm password doesn't match!");
                    } else {
                        accountDataService.changePassword(accountId, new_pwd, new AccountDataService.changePasswordResponseListener() {
                            @Override
                            public void onError(String message) {
                                Toast.makeText(ChangePasswordActivity.this, message, Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onResponse(String message) {
                                Intent intent = new Intent();
                                Toast.makeText(ChangePasswordActivity.this, message, Toast.LENGTH_SHORT).show();
                                ChangePasswordActivity.super.onBackPressed();
                            }
                        });
                    }
                }
            }
        });
    }
}