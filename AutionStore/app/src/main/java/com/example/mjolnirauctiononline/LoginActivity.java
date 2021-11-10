package com.example.mjolnirauctiononline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mjolnirauctiononline.model.Account;
import com.example.mjolnirauctiononline.model.Customer;
import com.example.mjolnirauctiononline.ulti.AccountDataService;

public class LoginActivity extends AppCompatActivity {
    EditText et_username, et_password;
    TextView txt_login_error;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_username = findViewById(R.id.et_login_username);
        et_password = findViewById(R.id.et_login_password);
        txt_login_error = findViewById(R.id.txt_login_error);
        btn_login = findViewById(R.id.btn_login);

        final AccountDataService accountDataService = new AccountDataService(LoginActivity.this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_login_error.setText("");
                Account account = new Account();
                account.setUsername(et_username.getText().toString());
                account.setPassword(et_password.getText().toString());
                account.setRole("Customer");
                accountDataService.checkLogin(account, new AccountDataService.LoginResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(Customer customer) {
                        Toast.makeText(LoginActivity.this, customer.toString(), Toast.LENGTH_SHORT).show();
                        if(customer.equals(null)){
                            txt_login_error.setText("Wrong username or password!");
                        } else {
                            SharedPreferences sp= getSharedPreferences("Login", MODE_PRIVATE);
                            SharedPreferences.Editor Ed=sp.edit();
                            Ed.putString("customerID",customer.getCustomerID());
                            Ed.putString("accountID",customer.getAccountID() );
                            Ed.putString("name",customer.getFirstname() + " " + customer.getLastname());
                            Ed.putString("balance", customer.getBalance().toString());
                            Ed.commit();

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
//
                    }
                });
            }
        });


    }
}