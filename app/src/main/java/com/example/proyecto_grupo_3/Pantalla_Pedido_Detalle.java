package com.example.proyecto_grupo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Pantalla_Pedido_Detalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_pedido_detalle);

        Intent intent = getIntent();

        int mesa1 = intent.getIntExtra(Pantalla_Pedidos.MESA1,-1);


        Toast.makeText(this,"Mesa: "+mesa1, Toast.LENGTH_SHORT).show();

    }
}