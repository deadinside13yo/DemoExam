package com.example.demoexam.screen.LaunchScreen.SignUpScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.demoexam.R;
import com.example.demoexam.common.AppData;
import com.example.demoexam.common.CheckData;
import com.example.demoexam.common.URLs;
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
                    JsonObjectRequest signUpRequest = new JsonObjectRequest(Request.Method.POST,
                            URLs.REGISTER, user, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            CheckData.makeMessage("Проблема с регистрацией ошибка", SignUp.this);
                            }
                });
                    AppData.getInstance(this).queue.add(signUpRequest);
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