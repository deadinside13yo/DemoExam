package com.example.demoexam.screen.LaunchScreen.SignInScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.demoexam.R;
import com.example.demoexam.common.CheckData;
import com.example.demoexam.databinding.ActivitySignInBinding;
import com.example.demoexam.screen.LaunchScreen.SignUpScreen.SignUp;

public class SignIn extends AppCompatActivity {

    ActivitySignInBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
    public void SignIn(View view){
        if(
            !binding.EmailET.getText().toString().isEmpty()&&
                    !binding.PasswordET.getText().toString().isEmpty()
            )
        {
            if (CheckData.checkMail(binding.EmailET.getText().toString())){
                CheckData.authConfirmed(SignIn.this, binding.EmailET.getText().toString(),
                        binding.PasswordET.getText().toString());



            }
            else{
                CheckData.makeMessage("Некорректный e-mail", this);
            }
        }
        else {
            CheckData.makeMessage("Пустые поля", this);
        }
    }

    public void GoSignUp(View view) {
        Intent signUp = new Intent(SignIn.this, SignUp.class);
        startActivity(signUp);
        finish();
    }
}