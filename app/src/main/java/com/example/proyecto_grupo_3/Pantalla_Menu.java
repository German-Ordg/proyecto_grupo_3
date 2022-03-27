package com.example.proyecto_grupo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.nio.charset.StandardCharsets;

public class Pantalla_Menu extends AppCompatActivity {

    private String tipo;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_menu);
    }

    public void napolitana(View view)
    {
        tipo= "Napolitana";
        Intent Napolitana= new Intent(this,Detalles_Menu.class);
        Napolitana.putExtra("dato", tipo);
        startActivity(Napolitana);
    }

    public void pepperoni(View view)
    {
        tipo= "Pepperoni";
        Intent Pepperoni= new Intent(this,Detalles_Menu.class);
        Pepperoni.putExtra("dato", tipo);
        startActivity(Pepperoni);
    }

    public void suprema(View view)
    {
        tipo= "Suprema";
        Intent Suprema = new Intent(this,Detalles_Menu.class);
        Suprema.putExtra("dato", tipo);
        startActivity(Suprema);
    }

    public void queso(View view)
    {
        tipo= "Queso";
        Intent Queso= new Intent(this,Detalles_Menu.class);
        Queso.putExtra("dato", tipo);
        startActivity(Queso);
    }

}

