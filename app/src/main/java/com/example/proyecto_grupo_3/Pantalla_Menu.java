package com.example.proyecto_grupo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Pantalla_Menu extends AppCompatActivity {

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_menu);
    }

    public void napolitana(View view)
    {
        Intent Napolitana= new Intent(this,Detalles_Menu.class);
        startActivity(Napolitana);
    }

    public void pepperoni(View view)
    {
        Intent Pepperoni= new Intent(this,Detalles_Menu.class);
        startActivity(Pepperoni);
    }

    public void suprema(View view)
    {
        Intent Suprema = new Intent(this,Detalles_Menu.class);
        startActivity(Suprema);
    }

    public void queso(View view){
        Intent Queso= new Intent(this,Detalles_Menu.class);
        startActivity(Queso);
    }
}

