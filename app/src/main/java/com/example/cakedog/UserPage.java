package com.example.cakedog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.sql.SQLException;

@SuppressWarnings("FieldCanBeLocal")
public class UserPage extends AppCompatActivity {
    private AppCompatTextView txtHelloUser, txtEmailUser;
    private AppCompatButton btnDeleteAccount, btnExit;
    UserInformations userInformations = new UserInformations();

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_user_page);

        txtHelloUser = findViewById(R.id.txtHelloUser);
        txtEmailUser = findViewById(R.id.txtEmailUser);
        btnDeleteAccount = findViewById(R.id.btnDeleteAccount);
        btnExit = findViewById(R.id.btnExit);
        helloUser();
        btnDeleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserInformations userInformations = new UserInformations();
                int id = userInformations.getUserId();
                String sql1 = "update usuario set nome_user = null, telefone_user = null, email_user = null, senha_user = null, dt_cadastro = null, is_user_active = 0, dt_inativo = GETDATE(), dt_nascimento = null where id_user = " + id;
                String sql2 = "update endereco_user set endereco = null, bairro = null, cep = null, cidade = null, estado_uf = null, dt_cadastro = null, tipo_endereco = null where id_user =" + id;
                try {
                    ConnectionToSQL.stmt.executeUpdate(sql1);
                    ConnectionToSQL.stmt.executeUpdate(sql2);
                    userInformations.setUserId(0);
                    Intent change = new Intent(UserPage.this, LoginUser.class);
                    startActivity(change);
                } catch(SQLException ex) {
                    Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserInformations userInformations = new UserInformations();
                userInformations.setUserId(0);
                Intent change = new Intent(UserPage.this, LoginUser.class);
                startActivity(change);
            }
        });
    }

    public void helloUser() {
        try {
            String sql = "SELECT nome_user, email_user FROM usuario WHERE id_user = " + userInformations.getUserId();
            ConnectionToSQL.reSet = ConnectionToSQL.stmt.executeQuery(sql);
            if(ConnectionToSQL.reSet.next()) {
                String hello = "Olá, " + ConnectionToSQL.reSet.getString("nome_user");
                String helloEmail = ConnectionToSQL.reSet.getString("email_user");
                txtHelloUser.setText(hello);
                txtEmailUser.setText(helloEmail);
            }
        } catch(SQLException ex) {

        }
    }
}