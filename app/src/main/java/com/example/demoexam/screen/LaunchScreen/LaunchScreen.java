package com.example.demoexam.screen.LaunchScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import com.example.demoexam.R;
import com.example.demoexam.screen.LaunchScreen.SignInScreen.SignIn;


public class LaunchScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);

        new Handler().postAtTime(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LaunchScreen.this, SignIn.class);
                startActivity(intent);
            }
        }, 2000);
    }

}