package com.example.cakedog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.SQLException;

public class LoginUser extends AppCompatActivity {
    private EditText txtUser, txtPw;
    private Button btnEnter, btnToRegister;
    //ConnectionToSQL connect = new ConnectionToSQL();

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_login);

        txtUser = findViewById(R.id.txtUser);
        txtPw = findViewById(R.id.txtPw);
        //connect.enterDataBase(this);
        btnEnter = findViewById(R.id.btnEnter);
        btnToRegister = findViewById(R.id.btnToRegister);
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toHome();
            }
        });
        btnToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toRegister();
            }
        });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setMessage("Tem certeza que deseja sair?").setCancelable(false).setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        LoginUser.super.finish();
                    }
                }).setNegativeButton("Não", null).show();
    }

    public void toHome() {
        String user = "", pw = "";
        try {
            user = txtUser.getText().toString();
            pw = txtPw.getText().toString();
            if(user.equals("user") && pw.equals("123")) {
                Intent change = new Intent(LoginUser.this, Home.class);
                startActivity(change);
                finish();
            }
            /*
            try {
                ConnectionToSQL.reSet = ConnectionToSQL.stmt.executeQuery("SELECT * FROM usuario WHERE email_user LIKE '" + user + "' AND senha_user = '" + pw + "'");
                if(ConnectionToSQL.reSet.next()) {
                    Intent change = new Intent(LoginUser.this, Home.class);
                    startActivity(change);
                    finish();
                } else {
                    Toast.makeText(this, "Dados inválidos", Toast.LENGTH_LONG).show();
                    txtUser.setText("");
                    txtPw.setText("");
                    txtUser.requestFocus();
                }
            } catch(SQLException ex) {
                Toast.makeText(this, ex.toString(), Toast.LENGTH_LONG).show();
            }
             */

        } catch(Exception ex) {
            Toast.makeText(this, "Digite seu e-mail ou senha", Toast.LENGTH_LONG).show();
        }
    }

    public void toRegister() {
        Intent change = new Intent(LoginUser.this, RegisterUser.class);
        startActivity(change);
    }
}