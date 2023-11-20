package com.example.cakedog;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cakedog.Home;

public class ShoppingCart extends AppCompatActivity {
    ImageView img;
    LinearLayout ln;
    public static int qtdeItem = 1;
    TextView qtdeProd;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_shopping_cart);

        img = findViewById(R.id.imgProdView);
        img.setImageResource(R.drawable.bolo_espec);
        qtdeProd = findViewById(R.id.txtQuantityItem);
        qtdeProd.setText(Integer.toString(qtdeItem));
    }

    public void toDeliver(View v) {
        Intent change = new Intent(ShoppingCart.this, DeliveryScreen.class);
        startActivity(change);
    }
}