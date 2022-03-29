package com.example.proyecto_grupo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import com.example.proyecto_grupo_3.BaseDeDatos;

public class Detalles_Menu extends AppCompatActivity {

    private TextView pizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_menu);

        pizza= (TextView) findViewById(R.id.txtdato);

        String dato= getIntent().getStringExtra("dato");

        pizza.setText(dato);
    }


}