package com.example.cakedog;

import android.content.Context;
import android.os.StrictMode;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionToSQL {

    public static Connection con = null;
    public static Statement stmt = null;
    public static ResultSet reSet = null;

    public Connection enterDataBase(Context ctx) {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
        } catch(Exception ex) {
            Toast.makeText(ctx.getApplicationContext(), "Driver não encontrado", Toast.LENGTH_LONG).show();
        }

        try {

            String url = "jdbc:jtds:sqlserver://192.168.1.104:1433/cakedog";
            con = DriverManager.getConnection(url, "sa", "12345");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch(SQLException ex) {
            Toast.makeText(ctx.getApplicationContext(), "Não conectado" + ex, Toast.LENGTH_LONG).show();
        }
        return con;
    }
}
