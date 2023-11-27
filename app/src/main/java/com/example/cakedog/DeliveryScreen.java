package com.example.cakedog;

import static com.example.cakedog.ConnectionToSQL.stmt;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.LinearLayoutCompat;

import java.sql.SQLException;

public class DeliveryScreen extends AppCompatActivity {
    LinearLayoutCompat lnAddresses;
    UserInformations userInfo = new UserInformations();

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_delivery_screen);

        lnAddresses = findViewById(R.id.lnAddresses);
        //AppCompatRadioButton radioButton = new AppCompatRadioButton(this);
    }

    private void getAddress() {
        try {
            int id = userInfo.getUserId(), numRows = 0;
            String sql = "SELECT endereco_user.endereco, endereco_user.bairro FROM endereco_user INNER JOIN usuario ON endereco_user.id_user = usuario.id_user WHERE usuario.id_user = " + id;
            ConnectionToSQL.reSet = stmt.executeQuery(sql);
            while(ConnectionToSQL.reSet.next()) {
                numRows++;
            }
            for(int i = 1; i <= numRows; i++) {
                String[] address = new String[numRows];
                String[] neighborhood = new String[numRows];
                address[i] = ConnectionToSQL.reSet.getString("endereco");
                neighborhood[i] = ConnectionToSQL.reSet.getString("bairro");
            }
        } catch(SQLException ex) {

        }
    }
}