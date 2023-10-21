package com.example.cakedog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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