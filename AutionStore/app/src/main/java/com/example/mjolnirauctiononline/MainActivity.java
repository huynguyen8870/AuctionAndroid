package com.example.mjolnirauctiononline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.mjolnirauctiononline.view.user.MessageFragment;
import com.example.mjolnirauctiononline.view.user.OrderFragment;
import com.example.mjolnirauctiononline.view.user.HomeFragment;
import com.example.mjolnirauctiononline.view.user.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment;
    private OrderFragment orderFragment;
    private MessageFragment messageFragment;
    private UserFragment userFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        orderFragment = new OrderFragment();
        messageFragment = new MessageFragment();
        userFragment = new UserFragment();

        bottomNavigationView = findViewById(R.id.BottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setCustomAnimations(R.anim.slide_in,R.anim.fade_out)
                            .replace(R.id.FrameContainer, homeFragment)
                            .commit();
                    return true;

                case R.id.order:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setCustomAnimations(R.anim.slide_in,R.anim.fade_out)
                            .replace(R.id.FrameContainer, orderFragment)
                            .commit();
                    return true;

                case R.id.message:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setCustomAnimations(R.anim.slide_in,R.anim.fade_out)
                            .replace(R.id.FrameContainer, messageFragment)
                            .commit();
                    return true;

                case R.id.user:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setCustomAnimations(R.anim.slide_in,R.anim.fade_out)
                            .replace(R.id.FrameContainer, userFragment)
                            .commit();
                    return true;
            }
            return false;
        });
        bottomNavigationView.setSelectedItemId(R.id.home);
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}