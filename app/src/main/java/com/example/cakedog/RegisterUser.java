package com.example.cakedog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegisterUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
    }

    public void doRegister(View v) {
        Intent change = new Intent(RegisterUser.this, MainActivity.class);
        startActivity(change);
        finish();
    }
}