package com.example.cakedog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtUser, txtPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUser = findViewById(R.id.txtUser);
        txtPw = findViewById(R.id.txtPw);
    }

    public void toHome(View v) {
        String user, pw;
        try {
            user = txtUser.getText().toString();
            pw = txtPw.getText().toString();
            if(user.equals("user") && pw.equals("123")) {
                Intent change = new Intent(MainActivity.this, Home.class);
                startActivity(change);
                finish();
            } else {
                Toast.makeText(this, "Dados inválidos", Toast.LENGTH_LONG).show();
                txtUser.setText("");
                txtPw.setText("");
                txtUser.requestFocus();
            }
        } catch(Exception ex) {

        }
    }

    public void toRegister(View v) {
        Intent change = new Intent(MainActivity.this, RegisterUser.class);
        startActivity(change);
        finish();
    }
}