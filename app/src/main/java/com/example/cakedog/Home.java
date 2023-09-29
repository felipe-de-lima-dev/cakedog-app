package com.example.cakedog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

public class Home extends AppCompatActivity {
    ImageView img1, img2, img3, img4;
    private ScrollView scrSimples, scrPers, scrTiskos, scrEspec;
    private Button btnSmp, btnPers, btnTiskos, btnEspec;

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
        btnSelectorChanger();
    }

    public void showSimples(View v) {
        if(scrEspec.getVisibility() == scrEspec.VISIBLE || scrPers.getVisibility() == scrPers.VISIBLE || scrTiskos.getVisibility() == scrTiskos.VISIBLE) {
            scrSimples.setVisibility(scrSimples.VISIBLE);
            scrEspec.setVisibility(scrEspec.GONE);
            scrPers.setVisibility(scrEspec.GONE);
            scrTiskos.setVisibility(scrEspec.GONE);
        }
        btnSelectorChanger();
    }

    public void showPers(View v) {
        if(scrSimples.getVisibility() == scrSimples.VISIBLE || scrEspec.getVisibility() == scrEspec.VISIBLE || scrTiskos.getVisibility() == scrTiskos.VISIBLE) {
            scrPers.setVisibility(scrSimples.VISIBLE);
            scrEspec.setVisibility(scrEspec.GONE);
            scrSimples.setVisibility(scrEspec.GONE);
            scrTiskos.setVisibility(scrEspec.GONE);
        }
        btnSelectorChanger();
    }

    public void showTiskos(View v) {
        if(scrEspec.getVisibility() == scrEspec.VISIBLE || scrPers.getVisibility() == scrPers.VISIBLE || scrSimples.getVisibility() == scrSimples.VISIBLE) {
            scrTiskos.setVisibility(scrSimples.VISIBLE);
            scrEspec.setVisibility(scrEspec.GONE);
            scrPers.setVisibility(scrEspec.GONE);
            scrSimples.setVisibility(scrEspec.GONE);
        }
        btnSelectorChanger();
    }

    public void showEspecial(View v) {
        if(scrSimples.getVisibility() == scrSimples.VISIBLE || scrPers.getVisibility() == scrPers.VISIBLE || scrTiskos.getVisibility() == scrTiskos.VISIBLE) {
            scrEspec.setVisibility(scrSimples.VISIBLE);
            scrSimples.setVisibility(scrEspec.GONE);
            scrPers.setVisibility(scrEspec.GONE);
            scrTiskos.setVisibility(scrEspec.GONE);
        }
        btnSelectorChanger();
    }

    public void btnSelectorChanger() {
        if(scrSimples.getVisibility() == scrSimples.VISIBLE) {
            btnSmp.setBackgroundResource(R.drawable.btn_home_cake_selector_selected);
            btnPers.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnTiskos.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnEspec.setBackgroundResource(R.drawable.btn_home_cake_selector);
            img1 = findViewById(R.id.imgSimples1);
            img2 = findViewById(R.id.imgSimples2);
            img3 = findViewById(R.id.imgSimples3);
            img4 = findViewById(R.id.imgSimples4);
            img1.setImageResource(R.drawable.festa_doggo);
            img2.setImageResource(R.drawable.festa_doggo);
            img3.setImageResource(R.drawable.festa_doggo);
            img4.setImageResource(R.drawable.festa_doggo);
        }
        else if(scrPers.getVisibility() == scrPers.VISIBLE) {
            btnPers.setBackgroundResource(R.drawable.btn_home_cake_selector_selected);
            btnSmp.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnTiskos.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnEspec.setBackgroundResource(R.drawable.btn_home_cake_selector);
            img1 = findViewById(R.id.imgPers1);
            img2 = findViewById(R.id.imgPers2);
            img3 = findViewById(R.id.imgPers3);
            img1.setImageResource(R.drawable.bolo_doggo);
            img2.setImageResource(R.drawable.bolo_doggo);
            img3.setImageResource(R.drawable.bolo_doggo);
        }
        else if(scrTiskos.getVisibility() == scrTiskos.VISIBLE) {
            btnTiskos.setBackgroundResource(R.drawable.btn_home_cake_selector_selected);
            btnPers.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnSmp.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnEspec.setBackgroundResource(R.drawable.btn_home_cake_selector);
            img1 = findViewById(R.id.imgTiskos1);
            img2 = findViewById(R.id.imgTiskos2);
            img3 = findViewById(R.id.imgTiskos3);
            img1.setImageResource(R.drawable.bolo_doggo);
            img2.setImageResource(R.drawable.bolo_doggo);
            img3.setImageResource(R.drawable.bolo_doggo);
        }
        else if(scrEspec.getVisibility() == scrEspec.VISIBLE) {
            btnEspec.setBackgroundResource(R.drawable.btn_home_cake_selector_selected);
            btnPers.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnTiskos.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnSmp.setBackgroundResource(R.drawable.btn_home_cake_selector);
            img1 = findViewById(R.id.imgEspec1);
            img2 = findViewById(R.id.imgEspec2);
            img3 = findViewById(R.id.imgEspec3);
            img1.setImageResource(R.drawable.festa_doggo);
            img2.setImageResource(R.drawable.festa_doggo);
            img3.setImageResource(R.drawable.festa_doggo);
        }
    }
}