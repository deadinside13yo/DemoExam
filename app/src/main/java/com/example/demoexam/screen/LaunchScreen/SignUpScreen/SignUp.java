package com.example.demoexam.screen.LaunchScreen.SignUpScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.demoexam.R;
import com.example.demoexam.common.CheckData;
import com.example.demoexam.common.entity.User;
import com.example.demoexam.databinding.ActivitySignUpBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUp extends AppCompatActivity {

    ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void SignUp(View view) {
        if(
                !binding.NameET.getText().toString().equals("")&&
                        !binding.LastNameET.getText().toString().equals("")&&
                        !binding.EmailSignUpET.getText().toString().equals("")&&
                        !binding.PasswordSignUpET.getText().toString().equals("")
        )
        {
            if(CheckData.checkMail(binding.EmailSignUpET.getText().toString()))
            {
                if(binding.PasswordSignUpET.getText().toString().equals(binding.RePasswordET.getText().toString()))
                {
                    JSONObject user = new JSONObject();
                    try{
                        user.put(User.EMAIL, binding.EmailSignUpET.getText().toString());
                        user.put(User.PASSWORD, binding.PasswordSignUpET.getText().toString());
                        user.put(User.FIRST_NAME, binding.NameET.getText().toString());
                        user.put(User.LAST_NAME, binding.LastNameET.getText().toString());
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
                else
                {
                    CheckData.makeMessage("Пароли не совпадают", this);
                }
            }
            else {
                CheckData.makeMessage("Некорректный майл", this);
            }
        }
        else {
            CheckData.makeMessage("Пустые поля", this);
        }
    }
}