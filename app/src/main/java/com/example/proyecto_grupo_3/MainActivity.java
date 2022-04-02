package com.example.proyecto_grupo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner Combo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BaseDeDatos admin= new BaseDeDatos(this,"administrador", null,1);
        SQLiteDatabase BaseDatos= admin.getWritableDatabase();
    }

    public void Cliente(View view){
        Intent pagina = new Intent(this,Pantalla_Menu.class);
        startActivity(pagina);
    }
    public void Empleado(View view){
        Intent pagina = new Intent(this,Tipo_Empleado.class);
        startActivity(pagina);
    }
}