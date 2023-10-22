package com.example.cakedog;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cakedog.ConnectionToSQL;
import java.sql.SQLException;
import java.util.Calendar;

public class RegisterUser extends AppCompatActivity {
    String ufSelected;
    String[] ufList = {
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

    //ConnectionToSQL connect = new ConnectionToSQL();
    EditText txtName, cpf, phone, address, neibhood, postalCode, city, email, pw;
    private DatePickerDialog datePickerDialog;
    private Button btnDate, btnUF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterUser.this);
        initDatePicker();
        builder.setTitle("Selecione o UF");
        txtName = findViewById(R.id.txtName);
        cpf = findViewById(R.id.txtCPF);
        phone = findViewById(R.id.txtPhone);
        address = findViewById(R.id.txtAddress);
        neibhood = findViewById(R.id.txtNeighborhood);
        postalCode = findViewById(R.id.txtCEP);
        city = findViewById(R.id.txtCity);
        email = findViewById(R.id.txtEmail);
        pw = findViewById(R.id.txtPw);
        btnDate = findViewById(R.id.btnBirthDate);
        btnUF = findViewById(R.id.btnUF);
        final ArrayAdapter<String> ufAdapt = new ArrayAdapter<>(RegisterUser.this, android.R.layout.select_dialog_singlechoice);
        ufAdapt.addAll(ufList);
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setAdapter(ufAdapt, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                btnUF.setText(ufList[which]);
                ufSelected = ufList[which];
            }
        });
        btnUF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.show();
            }
        });
        /* ----------------------MÉTODO PARA COLOCAR UM - NO EDITTEXT------------------------------
        postalCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().contains("-") && s.length() > 5) {
                    String.substring(s);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
         */
    }

    public void doRegister(View v) {
        try {
            String strName, strCPF, strBirthDate, strPhone, strAddress, strNebhood, strPostalCode, strCity, strEmail, strPw;
            strName = txtName.getText().toString();
            strCPF = cpf.getText().toString();
            strBirthDate = btnDate.getText().toString();
            strPhone = phone.getText().toString();
            strAddress = address.getText().toString();
            strNebhood = neibhood.getText().toString();
            strPostalCode = postalCode.getText().toString();
            strCity = city.getText().toString();
            strEmail = email.getText().toString();
            strPw = pw.getText().toString();
            ConnectionToSQL.stmt.executeUpdate(
                    "INSERT INTO Cliente(nome_cli, cpf_cli, telefone_cli, email_cli, senha_cli, dt_cadastro, is_cliente_active, dt_inativo, dt_nascimento)" +
                    "VALUES('" + strName + "','" + strCPF + "','" + strPhone + "','" + strEmail + "','" + strPw + "', GETDATE(), 1, NULL,'" + strBirthDate + "')"
            );
            ConnectionToSQL.stmt.executeUpdate(
                    "INSERT INTO Endereco_cliente(id_cli, endereco_cli, bairro, cep, cidade, estado_uf, dt_cadastro, tipo_endereco) " +
                      "VALUES(@@IDENTITY, '" + strAddress + "', '" + strNebhood + "', '" + strPostalCode + "', '" + strCity + "', '" + ufSelected + "', GETDATE(), 'Principal')"
            );
            ConnectionToSQL.reSet = ConnectionToSQL.stmt.executeQuery("SELECT COUNT(*) FROM Cliente WHERE id_cli = " + strCPF +"");
            if(ConnectionToSQL.reSet.next()) {
                Toast.makeText(this, "Cadastro feito com sucesso", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(this, "Não cadastrado", Toast.LENGTH_LONG).show();
            }
        } catch(SQLException ex) {
            Toast.makeText(this, "Necessário preencher todos os campos para finalizar o cadastro", Toast.LENGTH_LONG).show();
        }
    }

    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);
                btnDate.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

    private String makeDateString(int day, int month, int year) {
        return day + "/" + month + "/" + year;
    }

    public void openDatePicker(View v) {
        datePickerDialog.show();
    }

    /*
    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }
     */
}