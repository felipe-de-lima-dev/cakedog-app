package com.example.cakedog;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cakedog.Home;

public class ShoppingCart extends AppCompatActivity {
    AppCompatImageView img;
    public static int qtdeItem = 1;
    AppCompatTextView qtdeProd, btnChangeAddress, btnChangePayment;
    AppCompatButton btnEndShop;
    Home home = new Home();
    //private RecyclerView.Adapter adapter;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_shopping_cart);

        //img = findViewById(R.id.imgProdView);
        //qtdeProd = findViewById(R.id.txtQuantityItem);
        btnEndShop = findViewById(R.id.btnEndShop);
        btnChangeAddress = findViewById(R.id.btnChangeAddress);
        btnChangePayment = findViewById(R.id.btnChangePayment);
//        qtdeProd.setText(Integer.toString(qtdeItem));
//        img.setImageResource(R.drawable.bolo_simples_frango);
        /*
        RecyclerView recyclerView = findViewById(R.id.cartRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CartAdapter(productToCart);
        recyclerView.setAdapter(adapter);*/
        btnEndShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnChangeAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent change = new Intent(ShoppingCart.this, DeliveryScreen.class);
                startActivity(change);
            }
        });
        btnChangePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent change = new Intent(ShoppingCart.this, Payment.class);
                startActivity(change);
            }
        });
    }
}