package com.example.sep.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sep.R;
import com.example.sep.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    private EditText emailField, passwordField;
    private Button loginButton;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailField = findViewById(R.id.emailEditTextView);
        passwordField = findViewById(R.id.passwordEditTextView);
        loginButton = findViewById(R.id.loginButton);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginViewModel.retrieveGymsByEmail(String.valueOf(emailField.getText()));


                loginViewModel.getGymsByEmail().observe(LoginActivity.this, gym -> {
                    if (String.valueOf(passwordField.getText()).replaceAll("\\s+","").equals(gym.getPassword().replaceAll("\\s+",""))){
                        System.out.println("Changing activity");
                        changeActivity();
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Wrong password", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }

    public void changeActivity(){
        Intent myIntent = new Intent(this, MainActivityHome.class);
        startActivity(myIntent);
    }
}