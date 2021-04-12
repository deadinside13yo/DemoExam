package com.example.demoexam.screen.LaunchScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;


import com.example.demoexam.R;
import com.example.demoexam.screen.LaunchScreen.SignInScreen.SignIn;
import com.example.demoexam.screen.LaunchScreen.SignUpScreen.SignUp;


public class LaunchScreen extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);

        SharedPreferences sharedPreferences = getSharedPreferences("firstLoadd", Context.MODE_PRIVATE);
        boolean firstLoader = sharedPreferences.getBoolean("firstLoaded",true);
        if(firstLoader)
        {
            SharedPreferences.Editor e = sharedPreferences.edit();
            e.putBoolean("firstLoaded", false);
            e.apply();
            intent = new Intent(LaunchScreen.this, SignUp.class);
        }
        else intent = new Intent(LaunchScreen.this, SignIn.class);

        new Handler().postAtTime(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        }, 2000);
    }

}