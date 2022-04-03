package com.example.proyecto_grupo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Pantalla_Pedidos extends AppCompatActivity {

    public static final String MESA1="mesa1";
    private Button boton1, boton2, boton3, boton4;
    int mesa1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_pedidos);
        BaseDeDatos admin = new BaseDeDatos(this, "administrador", null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();
        boton1 = (Button) findViewById(R.id.btnmes1);
        boton2 = (Button) findViewById(R.id.btnmes2);
        boton3 = (Button) findViewById(R.id.btnmes3);
        boton4 = (Button) findViewById(R.id.btnmes4);

        boton1.setOnClickListener((view) ->{
            Cursor c = BaseDatos.rawQuery("select codigo_estado FROM Pedidos where numero_mesa = 1 ", null);
            c.moveToFirst();
            do {
                //Asignamos el valor en nuestras variables para usarlos en lo que necesitemos
                @SuppressLint("Range") int cod_estado = c.getInt(c.getColumnIndex("codigo_estado"));
                if (cod_estado == 1) {
                    Intent intent = new Intent(this, Pantalla_Pedido_Detalle.class);
                    mesa1 = 1;
                    intent.putExtra(MESA1, mesa1);
                    startActivity(intent);
                }else if (cod_estado == 2)
                {
                    Toast.makeText(this, "La orden ya fue atendida", Toast.LENGTH_SHORT).show();
                }
            } while (c.moveToNext());
        });

        boton2.setOnClickListener((view) ->{
            Cursor c = BaseDatos.rawQuery("select codigo_estado FROM Pedidos where numero_mesa = 2 ", null);
            c.moveToFirst();
            do {
                //Asignamos el valor en nuestras variables para usarlos en lo que necesitemos
                @SuppressLint("Range") int cod_estado = c.getInt(c.getColumnIndex("codigo_estado"));
                if (cod_estado == 1) {
                    Intent intent = new Intent(this, Pantalla_Pedido_Detalle.class);
                    mesa1 = 2;
                    intent.putExtra(MESA1, mesa1);
                    startActivity(intent);
                }else if (cod_estado == 2)
                {
                    Toast.makeText(this, "La orden ya fue atendida", Toast.LENGTH_SHORT).show();
                }
            } while (c.moveToNext());

        });

        boton3.setOnClickListener((view) ->{
            Cursor c = BaseDatos.rawQuery("select codigo_estado FROM Pedidos where numero_mesa = 3 ", null);
            c.moveToFirst();
            do {
                //Asignamos el valor en nuestras variables para usarlos en lo que necesitemos
                @SuppressLint("Range") int cod_estado = c.getInt(c.getColumnIndex("codigo_estado"));
                if (cod_estado == 1) {
                    Intent intent = new Intent(this, Pantalla_Pedido_Detalle.class);
                    mesa1 = 3;
                    intent.putExtra(MESA1, mesa1);
                    startActivity(intent);
                }else if (cod_estado == 2)
                {
                    Toast.makeText(this, "La orden ya fue atendida", Toast.LENGTH_SHORT).show();
                }
            } while (c.moveToNext());
        });

        boton4.setOnClickListener((view) ->{
            Cursor c = BaseDatos.rawQuery("select codigo_estado FROM Pedidos where numero_mesa = 4 ", null);
            c.moveToFirst();
            do {
                //Asignamos el valor en nuestras variables para usarlos en lo que necesitemos
                @SuppressLint("Range") int cod_estado = c.getInt(c.getColumnIndex("codigo_estado"));
                if (cod_estado == 1) {
                    Intent intent = new Intent(this, Pantalla_Pedido_Detalle.class);
                    mesa1 = 4;
                    intent.putExtra(MESA1, mesa1);
                    startActivity(intent);
                }else if (cod_estado == 2)
                {
                    Toast.makeText(this, "La orden ya fue atendida", Toast.LENGTH_SHORT).show();
                }
            } while (c.moveToNext());
        });

    }}


