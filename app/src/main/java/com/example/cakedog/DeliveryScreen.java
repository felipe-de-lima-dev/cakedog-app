package com.example.cakedog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DeliveryScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_screen);
    }

    public void toPayment(View v) {
        Intent change = new Intent(DeliveryScreen.this, Payment.class);
        startActivity(change);
    }
}