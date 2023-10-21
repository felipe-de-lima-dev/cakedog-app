package com.example.cakedog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class RegisterUser extends AppCompatActivity {
    String[] ufList = {
            "Selecione o UF",
            "RO",
            "AC",
            "AM",
            "RR",
            "PA",
            "AP",
            "TO",
            "MA",
            "PI",
            "CE",
            "RN",
            "PB",
            "PE",
            "AL",
            "SE",
            "BA",
            "MG",
            "ES",
            "RJ",
            "SP",
            "PR",
            "SC",
            "RS",
            "MS",
            "MT",
            "GO",
            "DF"
    };
    ArrayAdapter<String> ufAdapt;
    Spinner spnUf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        spnUf = findViewById(R.id.spnUf);
        spnUf.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int selItem, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView parent) {

            }
        });
        ufAdapt = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ufList);
        spnUf.setAdapter(ufAdapt);
    }

    public void doRegister(View v) {
        Intent change = new Intent(RegisterUser.this, LoginUser.class);
        startActivity(change);
        finish();
    }
}