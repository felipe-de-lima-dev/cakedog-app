package com.example.cakedog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    private LinearLayout lnAlterQuantity;
    private LinearLayoutCompat btnCartSm1;
    private ImageView img1, img2, img3, img4;
    private ScrollView scrSimples, scrPers, scrTiskos, scrEspec;
    private AppCompatButton btnSmp, btnPers, btnTiskos, btnEspec;
    private TextView txtQuantityItem;
    private int qtdeProd = 1;
    private AppCompatButton btnCart, btnUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnSmp = findViewById(R.id.btnSimples);
        btnPers = findViewById(R.id.btnPers);
        btnTiskos = findViewById(R.id.btnCaketisco);
        btnEspec = findViewById(R.id.btnEspecial);
        scrSimples = findViewById(R.id.scrViewSimples);
        scrPers = findViewById(R.id.scrViewPers);
        scrTiskos = findViewById(R.id.scrViewTiskos);
        scrEspec = findViewById(R.id.scrViewEspecial);
        lnAlterQuantity = findViewById(R.id.alterQuantityItem);
        txtQuantityItem = findViewById(R.id.txtQuantityItem);
        btnCart = findViewById(R.id.btnToCart);
        btnUser = findViewById(R.id.btnToUser);
        btnCartSm1 = findViewById(R.id.btnCartSm1);
        btnSelectorChanger();
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toCart();
            }
        });
        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Em desenvolvimento", Toast.LENGTH_LONG).show();
            }
        });
        btnCartSm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showQuantityItem();
            }
        });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setMessage("Tem certeza que deseja sair?").setCancelable(false).setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Home.super.finish();
            }
        }).setNegativeButton("Não", null).show();
    }

    public void showSimples(View v) {
        if(scrEspec.getVisibility() == View.VISIBLE || scrPers.getVisibility() == View.VISIBLE || scrTiskos.getVisibility() == View.VISIBLE) {
            scrSimples.setVisibility(View.VISIBLE);
            scrEspec.setVisibility(View.GONE);
            scrPers.setVisibility(View.GONE);
            scrTiskos.setVisibility(View.GONE);
        }
        btnSelectorChanger();
    }

    public void showPers(View v) {
        if(scrSimples.getVisibility() == View.VISIBLE || scrEspec.getVisibility() == View.VISIBLE || scrTiskos.getVisibility() == View.VISIBLE) {
            scrPers.setVisibility(View.VISIBLE);
            scrEspec.setVisibility(View.GONE);
            scrSimples.setVisibility(View.GONE);
            scrTiskos.setVisibility(View.GONE);
        }
        btnSelectorChanger();
    }

    public void showTiskos(View v) {
        if(scrEspec.getVisibility() == View.VISIBLE || scrPers.getVisibility() == View.VISIBLE || scrSimples.getVisibility() == View.VISIBLE) {
            scrTiskos.setVisibility(View.VISIBLE);
            scrEspec.setVisibility(View.GONE);
            scrPers.setVisibility(View.GONE);
            scrSimples.setVisibility(View.GONE);
        }
        btnSelectorChanger();
    }

    public void showEspecial(View v) {
        if(scrSimples.getVisibility() == View.VISIBLE || scrPers.getVisibility() == View.VISIBLE || scrTiskos.getVisibility() == View.VISIBLE) {
            scrEspec.setVisibility(View.VISIBLE);
            scrSimples.setVisibility(View.GONE);
            scrPers.setVisibility(View.GONE);
            scrTiskos.setVisibility(View.GONE);
        }
        btnSelectorChanger();
    }

    public void btnSelectorChanger() {
        if(scrSimples.getVisibility() == View.VISIBLE) {
            btnSmp.setBackgroundResource(R.drawable.btn_home_cake_selector_selected);
            btnSmp.setTextColor(getResources().getColor(R.color.white));
            btnPers.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnTiskos.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnEspec.setBackgroundResource(R.drawable.btn_home_cake_selector);
            img1 = findViewById(R.id.imgSimples1);
            img2 = findViewById(R.id.imgSimples2);
            img3 = findViewById(R.id.imgSimples3);
            img4 = findViewById(R.id.imgSimples4);
            img1.setImageResource(R.drawable.bolo_simples);
            img2.setImageResource(R.drawable.bolo_simples);
            img3.setImageResource(R.drawable.bolo_simples);
            img4.setImageResource(R.drawable.bolo_simples);
        }
        else if(scrPers.getVisibility() == View.VISIBLE) {
            btnPers.setBackgroundResource(R.drawable.btn_home_cake_selector_selected);
            btnPers.setTextColor(getResources().getColor(R.color.white));
            btnSmp.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnTiskos.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnEspec.setBackgroundResource(R.drawable.btn_home_cake_selector);
            img1 = findViewById(R.id.imgPers1);
            img2 = findViewById(R.id.imgPers2);
            img3 = findViewById(R.id.imgPers3);
            img4 = findViewById(R.id.imgPers4);
            img1.setImageResource(R.drawable.bolo_pers2);
            img2.setImageResource(R.drawable.bolo_pers2);
            img3.setImageResource(R.drawable.bolo_pers2);
            img4.setImageResource(R.drawable.bolo_pers2);
        }
        else if(scrTiskos.getVisibility() == View.VISIBLE) {
            btnTiskos.setBackgroundResource(R.drawable.btn_home_cake_selector_selected);
            btnTiskos.setTextColor(getResources().getColor(R.color.white));
            btnPers.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnSmp.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnEspec.setBackgroundResource(R.drawable.btn_home_cake_selector);
            img1 = findViewById(R.id.imgTiskos1);
            img2 = findViewById(R.id.imgTiskos2);
            img3 = findViewById(R.id.imgTiskos3);
            img4 = findViewById(R.id.imgTiskos4);
            img1.setImageResource(R.drawable.caketisko);
            img2.setImageResource(R.drawable.caketisko);
            img3.setImageResource(R.drawable.caketisko);
            img4.setImageResource(R.drawable.caketisko);
        }
        else if(scrEspec.getVisibility() == View.VISIBLE) {
            btnEspec.setBackgroundResource(R.drawable.btn_home_cake_selector_selected);
            btnEspec.setTextColor(getResources().getColor(R.color.white));
            btnPers.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnTiskos.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnSmp.setBackgroundResource(R.drawable.btn_home_cake_selector);
            img1 = findViewById(R.id.imgEspec1);
            img2 = findViewById(R.id.imgEspec2);
            img3 = findViewById(R.id.imgEspec3);
            img4 = findViewById(R.id.imgEspec4);
            img1.setImageResource(R.drawable.bolo_espec);
            img2.setImageResource(R.drawable.bolo_espec);
            img3.setImageResource(R.drawable.bolo_espec);
            img4.setImageResource(R.drawable.bolo_espec);
        }
    }

    public void toCart() {
        Intent change = new Intent(Home.this, ShoppingCart.class);
        startActivity(change);
        lnAlterQuantity.setVisibility(View.GONE);
    }

    public void showQuantityItem() {
        if(lnAlterQuantity.getVisibility() == View.VISIBLE) {
            lnAlterQuantity.setVisibility(View.GONE);
        } else {
            lnAlterQuantity.setVisibility(View.VISIBLE);
        }
    }

    public void plusOne(View v) {
        try {
            qtdeProd = Integer.parseInt(txtQuantityItem.getText().toString());
            qtdeProd++;
            txtQuantityItem.setText(Integer.toString(qtdeProd));
        } catch(Exception ex) {

        }
    }

    public void minusOne(View v) {
        try {
            qtdeProd = Integer.parseInt(txtQuantityItem.getText().toString());
            if(qtdeProd < 2) {
                qtdeProd = 1;
            } else {
                qtdeProd--;
            }
            txtQuantityItem.setText(Integer.toString(qtdeProd));
        } catch(Exception ex) {

        }
    }

    public void addQtdeToCart(View v) {
        ShoppingCart.qtdeItem = qtdeProd;
        lnAlterQuantity.setVisibility(View.GONE);
    }
}