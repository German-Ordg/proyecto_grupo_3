package com.example.proyecto_grupo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner Combo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BaseDeDatos admin= new BaseDeDatos(this,"administrador",null,1);
        SQLiteDatabase BaseDatos= admin.getWritableDatabase();



        /*ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.Combo, android.R.layout.simple_spinner_item);
        Combo.setAdapter(adapter);*/

    }

    public void Menu(View view){
        Intent menu = new Intent(this,Pantalla_Menu.class);
        startActivity(menu);
    }
}