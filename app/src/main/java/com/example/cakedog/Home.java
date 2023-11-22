package com.example.cakedog;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("FieldCanBeLocal")
public class Home extends AppCompatActivity {
    private LinearLayoutCompat lnAlterQuantity;
    private LinearLayoutCompat btnCartSm1, btnCartSm2, btnCartSm3, btnCartSm4, btnCartSm5;
    private AppCompatImageView img1, img2, img3, img4, img5;
    private NestedScrollView scrSimples, scrPers, scrTiskos, scrEspec;
    private AppCompatButton btnSmp, btnPers, btnTiskos, btnEspec, btnCart, btnUser;
    private AppCompatTextView txtQuantityItem;
    private int qtdeProd = 1;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
        btnCartSm2 = findViewById(R.id.btnCartSm2);
        btnCartSm3 = findViewById(R.id.btnCartSm3);
        btnCartSm4 = findViewById(R.id.btnCartSm4);
        btnCartSm5 = findViewById(R.id.btnCartSm5);
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
        showQuantityButtons();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setMessage("Tem certeza que deseja sair?").setCancelable(false).setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Home.super.finish();
            }
        }).setNegativeButton("Não", null).show();
    }

    public void showQuantityButtons() {
        btnCartSm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showQuantityItem();
            }
        });

        btnCartSm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showQuantityItem();
            }
        });

        btnCartSm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showQuantityItem();
            }
        });

        btnCartSm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showQuantityItem();
            }
        });

        btnCartSm5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showQuantityItem();
            }
        });
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
            btnSmp.setTextColor(ContextCompat.getColor(this, R.color.white));
            btnPers.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnTiskos.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnEspec.setBackgroundResource(R.drawable.btn_home_cake_selector);
            img1 = findViewById(R.id.imgSimples1);
            img2 = findViewById(R.id.imgSimples2);
            img3 = findViewById(R.id.imgSimples3);
            img4 = findViewById(R.id.imgSimples4);
            img5 = findViewById(R.id.imgSimples5);
            img1.setImageResource(R.drawable.bolo_simples_frango);
            img2.setImageResource(R.drawable.bolo_simples_carne);
            img3.setImageResource(R.drawable.bolo_simples_salmao);
            img4.setImageResource(R.drawable.bolo_simples_vegetais);
            img5.setImageResource(R.drawable.bolo_simples_frutas);
        }
        else if(scrPers.getVisibility() == View.VISIBLE) {
            btnPers.setBackgroundResource(R.drawable.btn_home_cake_selector_selected);
            btnPers.setTextColor(ContextCompat.getColor(this, R.color.white));
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
            btnTiskos.setTextColor(ContextCompat.getColor(this, R.color.white));
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
            btnEspec.setTextColor(ContextCompat.getColor(this, R.color.white));
            btnPers.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnTiskos.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnSmp.setBackgroundResource(R.drawable.btn_home_cake_selector);
            img1 = findViewById(R.id.imgEspec1);
            img2 = findViewById(R.id.imgEspec2);
            img3 = findViewById(R.id.imgEspec3);
            img1.setImageResource(R.drawable.bolo_espec);
            img2.setImageResource(R.drawable.bolo_espec);
            img3.setImageResource(R.drawable.bolo_espec);
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