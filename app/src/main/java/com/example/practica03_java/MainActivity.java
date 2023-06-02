package com.example.practica03_java;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnIngresar;
    private Button btnSalir;
    private EditText txtUsuario;
    private EditText txtContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnIngresar();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSalir();
            }
        });
    }

    private void iniciarComponentes() {
        btnIngresar = findViewById(R.id.btnIngresar);
        btnSalir = findViewById(R.id.btnSalir);
        txtUsuario = findViewById(R.id.txtUsuario);
        txtContraseña = findViewById(R.id.txtContraseña);
    }

    private void btnIngresar() {
        String strUsuario;
        String strContraseña;

        strUsuario = getResources().getString(R.string.usuario);
        strContraseña = getResources().getString(R.string.contraseña);

        if (strUsuario.equals(txtUsuario.getText().toString()) && strContraseña.equals(txtContraseña.getText().toString())) {
            Bundle bundle = new Bundle();
            bundle.putString("Usuario", txtUsuario.getText().toString());

            Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "El usuario o contraseña no es válido", Toast.LENGTH_SHORT).show();
        }
    }

    private void btnSalir() {
        AlertDialog.Builder confirmar = new AlertDialog.Builder(this);

        confirmar.setTitle("Calculadora");
        confirmar.setMessage("¿Regresar al MainActivity?");
        confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // No hacer nada
            }
        });

        confirmar.show();
    }
}