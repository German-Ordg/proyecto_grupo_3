package com.example.proyecto_grupo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Tipo_Empleado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_empleado);
    }

    public void Mesero(View view){
        Intent mesero = new Intent(this,Pantalla_Pedidos.class);
        startActivity(mesero);
    }

    public void Cajero(View view){
        Intent cajero= new Intent(this,Pantalla_Pedidos3.class);
        startActivity(cajero);
    }
}