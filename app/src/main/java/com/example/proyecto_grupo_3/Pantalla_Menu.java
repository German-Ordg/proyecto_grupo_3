package com.example.proyecto_grupo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.nio.charset.StandardCharsets;

public class Pantalla_Menu extends AppCompatActivity {

    private String tipo;
    private int num;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_menu);
    }

    public void napolitana(View view)
    {
        Intent Napolitana= new Intent(this,Detalles_Menu.class);
        Napolitana.putExtra("dato","Napolitana");
        startActivity(Napolitana);
    }

    public void pepperoni(View view)
    {
        Intent Pepperoni= new Intent(this,Detalles_Menu.class);
        Pepperoni.putExtra("dato", "Pepperoni");
        startActivity(Pepperoni);
    }

    public void suprema(View view)
    {
        Intent Suprema = new Intent(this,Detalles_Menu.class);
        Suprema.putExtra("dato", "Suprema");
        startActivity(Suprema);
    }

    public void queso(View view)
    {
        Intent Queso= new Intent(this,Detalles_Menu.class);
        Queso.putExtra("dato", "Queso");
        startActivity(Queso);
    }

}

