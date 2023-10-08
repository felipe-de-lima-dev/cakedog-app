package com.example.cakedog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ShoppingCart extends AppCompatActivity {
    ImageView img;
    LinearLayout ln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        img = findViewById(R.id.imgProdView);
        img.setImageResource(R.drawable.bolo_espec);
    }
}