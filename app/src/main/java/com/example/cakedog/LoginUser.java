package com.example.cakedog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class LoginUser extends AppCompatActivity {
    private EditText txtUser, txtPw;
    ConnectionToSQL connect = new ConnectionToSQL();
    boolean statusDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUser = findViewById(R.id.txtUser);
        txtPw = findViewById(R.id.txtPw);
        connect.enterDataBase(this);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setMessage("Tem certeza que deseja sair?").setCancelable(false).setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        LoginUser.super.finish();
                    }
                }).setNegativeButton("Não", null).show();
    }

    public void toHome(View v) {
        String user = "", pw = "";
        try {
            user = txtUser.getText().toString();
            pw = txtPw.getText().toString();
            try {
                ConnectionToSQL.reSet = ConnectionToSQL.stmt.executeQuery("SELECT * FROM Cliente WHERE email_cli LIKE '" + user + "' AND senha_cli = '" + pw + "'");
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

        } catch(Exception ex) {
            Toast.makeText(this, "Digite seu e-mail ou senha", Toast.LENGTH_LONG).show();
        }
    }

    public void toRegister(View v) {
        Intent change = new Intent(LoginUser.this, RegisterUser.class);
        startActivity(change);
    }
}