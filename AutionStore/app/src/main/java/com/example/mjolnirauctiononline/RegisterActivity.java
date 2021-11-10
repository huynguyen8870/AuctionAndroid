package com.example.mjolnirauctiononline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mjolnirauctiononline.model.Account;
import com.example.mjolnirauctiononline.model.Customer;
import com.example.mjolnirauctiononline.ulti.AccountDataService;
import com.example.mjolnirauctiononline.ulti.CustomerDataService;

public class RegisterActivity extends AppCompatActivity {
    EditText et_username, et_password, et_confirm_password, et_firstname, et_lastname, et_phonenumber;
    TextView txt_error_repwd;
    Button btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_username = findViewById(R.id.et_reg_username);
        et_password = findViewById(R.id.et_reg_password);
        et_confirm_password = findViewById(R.id.et_reg_repassword);
        et_firstname = findViewById(R.id.et_reg_firstname);
        et_lastname = findViewById(R.id.et_reg_lastname);
        et_phonenumber = findViewById(R.id.et_reg_phone);

        txt_error_repwd = findViewById(R.id.txt_reg_error_repwd);

        final AccountDataService accountDataService = new AccountDataService(RegisterActivity.this);
        final CustomerDataService customerDataService = new CustomerDataService(RegisterActivity.this);

        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_error_repwd.setText("");
                String pwd = et_password.getText().toString();
                String re_pwd = et_confirm_password.getText().toString();
                if(!pwd.equals(re_pwd)){
                    txt_error_repwd.setText("Confirm password doesn't match!");
                } else {
                    /*Register Account Info*/
                    Account account = new Account();
                    account.setUsername(et_username.getText().toString());
                    account.setPassword(et_password.getText().toString());
                    account.setRole("Customer");
                    accountDataService.Register(account, new AccountDataService.RegisterResponseListener() {
                        @Override
                        public void onError(String message) {
                            Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onResponse(String accountID) {
                            /*Register Customer Info*/
                            Customer cus = new Customer();
                            cus.setFirstname(et_firstname.getText().toString());
                            cus.setLastname(et_lastname.getText().toString());
                            cus.setPhonenumber(et_phonenumber.getText().toString());
                            customerDataService.Register(accountID, cus, new CustomerDataService.RegisterResponseListener() {
                                @Override
                                public void onError(String message) {
                                    Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onResponse(String message) {
                                    Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }

            }
        });
    }
}