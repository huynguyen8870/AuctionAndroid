package com.example.mjolnirauctiononline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import com.example.mjolnirauctiononline.model.Customer;
import com.example.mjolnirauctiononline.model.Product;
import com.example.mjolnirauctiononline.ulti.CustomerDataService;
import com.example.mjolnirauctiononline.ulti.ProductDataService;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    EditText et_firstname, et_lastname, et_email, et_phone, et_address;
    Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar profileTb = (Toolbar) findViewById(R.id.profile_toolbar);
        setSupportActionBar(profileTb);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        profileTb.setNavigationOnClickListener(view -> onBackPressed());

        et_firstname = findViewById(R.id.et_profile_firstname);
        et_lastname = findViewById(R.id.et_profile_lastname);
        et_email = findViewById(R.id.et_profile_email);
        et_address =findViewById(R.id.et_profile_address);
        et_phone = findViewById(R.id.et_profile_phone);

        final CustomerDataService customerDataService = new CustomerDataService(ProfileActivity.this);
        customerDataService.getProfile(new CustomerDataService.ProfileResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(ProfileActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Customer customer) {
                et_firstname.setText(customer.getFirstname());
                et_lastname.setText(customer.getLastname());
                et_address.setText(customer.getAddress());
                et_email.setText(customer.getEmail());
                et_phone.setText(customer.getPhonenumber());
            }
        });

        btn_save = findViewById(R.id.btn_profile_save);


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Customer customer = new Customer();
                customer.setCustomerID("C-01");
                customer.setFirstname(et_firstname.getText().toString());
                customer.setLastname(et_lastname.getText().toString());
                customer.setAddress(et_address.getText().toString());
                customer.setPhonenumber(et_phone.getText().toString());
                customer.setEmail(et_email.getText().toString());
                customerDataService.saveProfile(customer ,new CustomerDataService.SaveProfileResponseListener(){
                    @Override
                    public void onError(String message) {
                        Toast.makeText(ProfileActivity.this, message, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String message) {
                        Toast.makeText(ProfileActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}