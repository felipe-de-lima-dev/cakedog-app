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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cakedog.Home;

import java.sql.SQLException;
import java.util.ArrayList;

public class ShoppingCart extends AppCompatActivity {
    AppCompatTextView btnChangeAddress, btnChangePayment, txtAddress, txtNbhood, txtSubtotal, txtDeliverPrice, txtTotalBuy;
    AppCompatButton btnEndShop;
    AppCompatEditText txtObservation;
    int valorTotal;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_shopping_cart);

        btnEndShop = findViewById(R.id.btnEndShop);
        btnChangeAddress = findViewById(R.id.btnChangeAddress);
        btnChangePayment = findViewById(R.id.btnChangePayment);
        txtAddress = findViewById(R.id.txtAddres);
        txtNbhood = findViewById(R.id.txtNbrhood);
        txtSubtotal = findViewById(R.id.txtSubTotal);
        txtDeliverPrice = findViewById(R.id.txtDeliverPrice);
        txtObservation = findViewById(R.id.txtObservation);
        txtTotalBuy = findViewById(R.id.txtTotalBuy);
        RecyclerView recyclerView = findViewById(R.id.cartRecyclerView);
        CartAdapter cartAdapter = new CartAdapter(Home.productToCart);
        recyclerView.setAdapter(cartAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        for (Product item : Home.productToCart) {
            valorTotal += item.getProductPrice();
        }
        if(!Home.productToCart.isEmpty()) {
            txtSubtotal.setText(valorTotal + "");
            txtDeliverPrice.setText(String.format(Integer.toString(20)));
            txtTotalBuy.setText(valorTotal + 20 + "");
        }
        btnEndShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String strObservation = txtObservation.getText().toString();
                    UserInformations userInformations = new UserInformations();

                    int id = userInformations.getUserId();
                    String minorSql = "INSERT INTO detalhe_pedido(id_pedido, id_produto, id_cobertura_foto, id_cobertura_cor, id_sabor, id_formato_bolo) VALUES";
                    String sql = "INSERT INTO pedido(id_user, dt_pedido, is_profile_active, status_pedido, valor_pedido, observacao_pedido, metodo_pagamento) VALUES(" + id +", GETDATE(), 1, 'PENDENTE'," + valorTotal + ", '" + strObservation + "', 'CARTÃO DE CRÉDITO')";

                    int i = 0;
                    if(Home.productToCart.size() > 1) {
                        while(i < Home.productToCart.size()) {
                            Product product = Home.productToCart.get(i);
                            Long idProd = product.getProductId();
                            minorSql = minorSql + "(@@IDENTITY, " + idProd + ", NULL, NULL, NULL, NULL),";
                            i++;
                        }
                    } else {
                        while(i < Home.productToCart.size()) {
                            Product product = Home.productToCart.get(i);
                            Long idProd = product.getProductId();
                            minorSql = minorSql + "(@@IDENTITY, " + idProd + ", NULL, NULL, NULL, NULL)";
                            i++;
                        }
                    }

                    ConnectionToSQL.stmt.executeUpdate(sql);
                    ConnectionToSQL.stmt.executeUpdate(minorSql);
                    Toast.makeText(ShoppingCart.this, "Pedido feito", Toast.LENGTH_SHORT).show();
                    Home.productToCart.clear();
                    finish();
                } catch(SQLException ex) {
                    Toast.makeText(ShoppingCart.this, ex.toString(), Toast.LENGTH_SHORT).show();
                }
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

    public void getAddressAndPayment() {
        try {
            UserInformations userInformations = new UserInformations();
            String sql = "SELECT endereco, bairro FROM enedreco_user WHERE id_user = " + userInformations.getUserId();
            ConnectionToSQL.reSet = ConnectionToSQL.stmt.executeQuery(sql);
            if(ConnectionToSQL.reSet.next()) {
                txtAddress.setText(ConnectionToSQL.reSet.getString("endereco"));
                txtNbhood.setText(ConnectionToSQL.reSet.getString("bairro"));
            }
        } catch(SQLException ex) {

        }
    }
}