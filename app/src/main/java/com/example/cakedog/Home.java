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

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class Home extends AppCompatActivity {
    private LinearLayoutCompat btnCartSm1, btnCartSm2, btnCartSm3, btnCartSm4, btnCartSm5, btnCartEspec1, btnCartEspec2, btnCartEspec3, btnCartTiskos1, btnCartTiskos2, btnCartTiskos3;
    private AppCompatImageView img1, img2, img3, img4, img5, imgPersFlavor, imgPersForm, imgPersColor, imgPersPhoto;
    private NestedScrollView scrSimples, scrPers, scrTiskos, scrEspec;
    private Spinner spnFlavor, spnForm, spnColor, spnPhoto;
    private CustomArrayAdapter arrayAdapter;
    private String[] arrayFlavor = {
            "Frango",
            "Carne Bovina",
            "Salmão",
            "Vegatais",
            "Frutas"
    };
    private int[] arrayFlavorImg = {
            R.drawable.bolo_simples_frango,
            R.drawable.bolo_simples_carne,
            R.drawable.bolo_simples_salmao,
            R.drawable.bolo_simples_vegetais,
            R.drawable.bolo_simples_frutas
    };
    private String[] arrayForm = {
            "Osso",
            "Quadrado",
            "Redondo",
            "Cachorro"
    };
    private int[] arrayFormImg = {
            R.drawable.forma_osso,
            R.drawable.forma_quadrada,
            R.drawable.forma_redonda,
            R.drawable.forma_dog
    };
    private String[] arrayColor = {
            "Azul",
            "Rosa",
            "Vermelho",
            "Amarelo"
    };
    private int[] arrayColorId = {
            R.color.blue,
            R.color.pink,
            R.color.red,
            R.color.yellow
    };
    private String[] arrayPhotoText = {
            "Poodle",
            "Lhasa",
            "Golden Retriever",
            "Labrador Retriever",
            "Doberman",
            "Buldogue",
            "Pug",
            "Rottveiler",
            "Pastor-Alemão",
            "Pitbull",
            "Chow Chow",
            "Nenhum"
    };
    private int[] arrayPhotoImg = {
            R.drawable.poodle,
            R.drawable.lhasa,
            R.drawable.golden_retriever,
            R.drawable.labrador,
            R.drawable.doberman,
            R.drawable.buldogue,
            R.drawable.pug,
            R.drawable.rottweiler,
            R.drawable.pastor_alemao,
            R.drawable.pitbull,
            R.drawable.chow_chow,
            R.drawable.vazio
    };
    private AppCompatButton btnSmp, btnPers, btnTiskos, btnEspec, btnCart, btnUser;
    private AppCompatTextView txtTitle, txtPersFlavor, txtPersForm, txtPersColor, txtPersPhoto;

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
        btnCart = findViewById(R.id.btnToCart);
        btnUser = findViewById(R.id.btnToUser);
        btnCartSm1 = findViewById(R.id.btnCartSm1);
        btnCartSm2 = findViewById(R.id.btnCartSm2);
        btnCartSm3 = findViewById(R.id.btnCartSm3);
        btnCartSm4 = findViewById(R.id.btnCartSm4);
        btnCartSm5 = findViewById(R.id.btnCartSm5);
        btnCartEspec1 = findViewById(R.id.btnCartEspec1);
        btnCartEspec2 = findViewById(R.id.btnCartEspec2);
        btnCartEspec3 = findViewById(R.id.btnCartEspec3);
        btnCartTiskos1 = findViewById(R.id.btnCartTiskos1);
        btnCartTiskos2 = findViewById(R.id.btnCartTiskos2);
        btnCartTiskos3 = findViewById(R.id.btnCartTiskos3);
        txtTitle = findViewById(R.id.txtTitle);
        imgPersFlavor = findViewById(R.id.imgPersFlavor);
        imgPersForm = findViewById(R.id.imgPersForm);
        imgPersColor = findViewById(R.id.imgPersColor);
        imgPersPhoto = findViewById(R.id.imgPersPhoto);
        txtPersFlavor = findViewById(R.id.txtPersFlavorTitle);
        txtPersForm = findViewById(R.id.txtPersFormTitle);
        txtPersColor = findViewById(R.id.txtPersColorTitle);
        txtPersPhoto = findViewById(R.id.txtPersPhotoTitle);
        spnFlavor = findViewById(R.id.spnFlavor);
        spnForm = findViewById(R.id.spnForm);
        spnColor = findViewById(R.id.spnColor);
        spnPhoto = findViewById(R.id.spnPhoto);
        List<String> listFlavor = new ArrayList<>(Arrays.asList(arrayFlavor));
        arrayAdapter = new CustomArrayAdapter(this, R.layout.spinner_item_layout, listFlavor);
        spnFlavor.setAdapter(arrayAdapter);
        spnFlavor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imgPersFlavor.setImageResource(arrayFlavorImg[i]);
                txtPersFlavor.setText(arrayFlavor[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                imgPersFlavor.setImageResource(arrayFlavorImg[0]);
                txtPersFlavor.setText(arrayFlavor[0]);
            }
        });
        List<String> listForm = new ArrayList<>(Arrays.asList(arrayForm));
        arrayAdapter = new CustomArrayAdapter(this, R.layout.spinner_item_layout, listForm);
        spnForm.setAdapter(arrayAdapter);
        spnForm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                txtPersForm.setText(arrayForm[i]);
                imgPersForm.setImageResource(arrayFormImg[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                txtPersForm.setText(arrayForm[0]);
                imgPersForm.setImageResource(arrayFormImg[0]);
            }
        });
        List<String> listColor = new ArrayList<>(Arrays.asList(arrayColor));
        arrayAdapter = new CustomArrayAdapter(this, R.layout.spinner_item_layout, listColor);
        spnColor.setAdapter(arrayAdapter);
        spnColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                txtPersColor.setText(arrayColor[i]);
                imgPersColor.setBackgroundColor(getColor(arrayColorId[i]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                txtPersColor.setText(arrayColor[0]);
                imgPersColor.setBackgroundColor(getColor(arrayColorId[0]));
            }
        });
        List<String> listPhoto = new ArrayList<>(Arrays.asList(arrayPhotoText));
        arrayAdapter = new CustomArrayAdapter(this, R.layout.spinner_item_layout, listPhoto);
        spnPhoto.setAdapter(arrayAdapter);
        spnPhoto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                txtPersPhoto.setText(arrayPhotoText[i]);
                imgPersPhoto.setImageResource(arrayPhotoImg[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                txtPersPhoto.setText(arrayPhotoText[0]);
                imgPersPhoto.setImageResource(arrayPhotoImg[0]);
            }
        });
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
                Intent change = new Intent(Home.this, UserPage.class);
                startActivity(change);
            }
        });
        btnCartSm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart(1L, "Bolo Simples", "Bolo de Frango", 40.00);
            }
        });
        btnCartSm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart(2L, "Bolo Simples", "Bolo de Carne", 45.00);
            }
        });
        btnCartSm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart(3L, "Bolo Simples", "Bolo de Salmão", 54.00);
            }
        });
        btnCartSm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart(4L, "Bolo Simples", "Bolo de Vegetais", 48.00);
            }
        });
        btnCartSm5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart(5L, "Bolo Simples", "Bolo de Frutas", 46.00);
            }
        });
        btnCartEspec1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart(6L, "Bolo Especial", "Bolo WheyProtein", 65.00);
            }
        });
        btnCartEspec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart(7L, "Bolo Especial", "Bolo Puppy", 62.00);
            }
        });
        btnCartEspec3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart(8L, "Bolo Especial", "Bolo Diet", 65.00);
            }
        });
        btnCartTiskos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart(9L, "Caketisko", "Pacote de Caketiskos 10 und", 20.00);
            }
        });
        btnCartTiskos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart(10L, "Caketisko", "Pacote de Caketiskos 20 und", 27.00);
            }
        });
        btnCartTiskos3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCart(11L, "Caketisko", "Pacote de Caketiskos 30 und", 40.00);
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
            btnSmp.setTextColor(ContextCompat.getColor(this, R.color.white));
            btnPers.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnTiskos.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnEspec.setBackgroundResource(R.drawable.btn_home_cake_selector);
            txtTitle.setText(R.string.txt_title_simple);
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
            txtTitle.setText(R.string.txt_title_pers);
        }
        else if(scrTiskos.getVisibility() == View.VISIBLE) {
            btnTiskos.setBackgroundResource(R.drawable.btn_home_cake_selector_selected);
            btnTiskos.setTextColor(ContextCompat.getColor(this, R.color.white));
            btnPers.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnSmp.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnEspec.setBackgroundResource(R.drawable.btn_home_cake_selector);
            txtTitle.setText(R.string.txt_title_tiskos);
            img1 = findViewById(R.id.imgTiskos1);
            img2 = findViewById(R.id.imgTiskos2);
            img3 = findViewById(R.id.imgTiskos3);
            img1.setImageResource(R.drawable.caketisko);
            img2.setImageResource(R.drawable.caketisko);
            img3.setImageResource(R.drawable.caketisko);
        }
        else if(scrEspec.getVisibility() == View.VISIBLE) {
            btnEspec.setBackgroundResource(R.drawable.btn_home_cake_selector_selected);
            btnEspec.setTextColor(ContextCompat.getColor(this, R.color.white));
            btnPers.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnTiskos.setBackgroundResource(R.drawable.btn_home_cake_selector);
            btnSmp.setBackgroundResource(R.drawable.btn_home_cake_selector);
            txtTitle.setText(R.string.txt_title_simple);
            img1 = findViewById(R.id.imgEspec1);
            img2 = findViewById(R.id.imgEspec2);
            img3 = findViewById(R.id.imgEspec3);
            img1.setImageResource(R.drawable.bolowhey);
            img2.setImageResource(R.drawable.bolopuppy);
            img3.setImageResource(R.drawable.bolofat);
        }
    }

    public void toCart() {
        Intent change = new Intent(Home.this, ShoppingCart.class);
        startActivity(change);
    }

    public static List<Product> productToCart = new ArrayList<>();

    public void addToCart(Long productId, String productType, String productName, double productPrice) {
        Product item = new Product(productId, productType, productName, productPrice);
        productToCart.add(item);
    }
}