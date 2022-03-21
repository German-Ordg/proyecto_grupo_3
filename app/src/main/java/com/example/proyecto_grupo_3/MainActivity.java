package com.example.proyecto_grupo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner Combo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Combo= (Spinner) findViewById(R.id.combobox);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.Combo, android.R.layout.simple_spinner_item);
        Combo.setAdapter(adapter);

    }

    public void pantalla_pedido(View view){
        Intent pagina = new Intent(this,Pantalla_Pedido_Detalle.class);
        startActivity(pagina);
    }
}