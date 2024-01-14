package com.shutter.soulsync;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    Handler handler = new Handler();
    FirebaseUser currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

                if(currentUser==null) {
                    startActivity(new Intent(SplashActivity.this, CreateUserActivity.class));
                }
                else{
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
                finish();
            }
        },1000);
    }
}