package com.example.proyecto_grupo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Pantalla_Pedido_Detalle extends AppCompatActivity {
    //Variables
    private TextView Especial;
    private TextView Cantidad;
    private TextView Masa;
    private TextView Tamaño;
    private TextView Mesa;
    private TextView Total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_pedido_detalle);
    }

    public void select(View view) {
        //Base en modo escritura
        BaseDeDatos admin = new BaseDeDatos(this, "administrador", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        Cursor c = BaseDeDatos.rawQuery("SELECT cantidad,precio,masa,tamaño from Ordenes", null);

        Cantidad.setText(c.getString(2));
        Total.setText(c.getString(3));
        Masa.setText(c.getString(4));
        Tamaño.setText(c.getString(5));

        if (c != null) {
            c.moveToFirst();
            do {
                //Asignamos el valor en nuestras variables para usarlos en lo que necesitemos
                @SuppressLint("Range") String cantidad = c.getString(c.getColumnIndex("cantidad"));
                @SuppressLint("Range") String precio = c.getString(c.getColumnIndex("precio"));
                @SuppressLint("Range") String masa = c.getString(c.getColumnIndex("masa"));
                @SuppressLint("Range") String tamaño = c.getString(c.getColumnIndex("tamaño"));
            } while (c.moveToNext());

            Cursor d = BaseDeDatos.rawQuery("SELECT codigo_producto from Productos", null);

            if (d != null) {
                d.moveToFirst();
                do {
                    //Asignamos el valor en nuestras variables para usarlos en lo que necesitemos
                    @SuppressLint("Range") String especialidad = c.getString(c.getColumnIndex("codigo_producto"));
                } while (d.moveToNext());

                Cursor e = BaseDeDatos.rawQuery("SELECT numero_mesa from Pedidos", null);

                if (e != null) {
                    e.moveToFirst();
                    do {
                        //Asignamos el valor en nuestras variables para usarlos en lo que necesitemos
                        @SuppressLint("Range") String mesa = c.getString(c.getColumnIndex("numero_mesa"));
                    } while (e.moveToNext());

                    Especial = (TextView) findViewById(R.id.txtespecialp);
                    Cantidad = (TextView) findViewById(R.id.txtespecialp);
                    Masa = (TextView) findViewById(R.id.txtespecialp);
                    Tamaño = (TextView) findViewById(R.id.txtespecialp);



                }
            }
        }

    }

}