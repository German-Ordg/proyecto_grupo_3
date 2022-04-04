package com.example.proyecto_grupo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla_Pedido_Detalle extends AppCompatActivity {
    //Variables
    private TextView Especial;
    private TextView Cantidad;
    private TextView Masa;
    private TextView Tamaño;
    private TextView Mesa;
    private TextView Total;

    int totaltotal;
    int cantidadcantidad;
    int totalfinal;
    String orden1;
    int orden;
    String producto1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_pedido_detalle);

        Especial = (TextView) findViewById(R.id.txtespecialp);
        Cantidad = (TextView) findViewById(R.id.txtcantidadp);
        Masa = (TextView) findViewById(R.id.txtmasap);
        Tamaño = (TextView) findViewById(R.id.txttamañop);
        Mesa = (TextView) findViewById(R.id.txtmesap);
        Total = (TextView) findViewById(R.id.txttotalp);

        Intent intent = getIntent();
        int mesa1 = intent.getIntExtra(Pantalla_Pedidos.MESA1, -1);
        BaseDeDatos admin = new BaseDeDatos(this, "administrador", null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();
        String codigo = String.valueOf(mesa1);

        if (!codigo.isEmpty()) {
            Cursor fila = BaseDatos.rawQuery("select codigo_orden from Pedidos where numero_mesa = "
                    + codigo +" and codigo_estado = 1", null);
            if (fila.moveToFirst()) {
                orden1 = (fila.getString(0));
            } else {
                Toast.makeText(this, "Esta mesa no ha realizado ninguna orden", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.activity_pantalla_pedidos);
            }

        } else {
            Toast.makeText(this, "Esta mesa no ha realizado ninguna orden", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_pantalla_pedidos);
        }
        Especial.setText(orden1);

        if (!orden1.isEmpty()) {
            Cursor fila = BaseDatos.rawQuery("select codigo_producto, cantidad, precio, masa, tamaño from Ordenes where codigo_orden = "
                    + orden1, null);
            if (fila.moveToFirst()) {
                producto1 = (fila.getString(0));
                Cantidad.setText(fila.getString(1));
                Total.setText(fila.getString(2));
                Masa.setText(fila.getString(3));
                Tamaño.setText(fila.getString(4));


            } else {
                Toast.makeText(this, "Esta mesa no ha realizado ninguna orden", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.activity_pantalla_pedidos);
            }

        } else {
            Toast.makeText(this, "Esta mesa no ha realizado ninguna orden", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_pantalla_pedidos);
        }

        Mesa.setText(codigo);

        String totalstring = Total.getText().toString();
        totaltotal = Integer.parseInt(totalstring);

        String cantidadstring = Cantidad.getText().toString();
        cantidadcantidad = Integer.parseInt(cantidadstring);

        totalfinal = totaltotal * cantidadcantidad;
        String imprimirtotal = String.valueOf(totalfinal);
        Total.setText(imprimirtotal);

        if (!producto1.isEmpty()) {
            Cursor fila = BaseDatos.rawQuery("select descripcion_producto from Productos where codigo_producto = "
                    + producto1, null);
            if (fila.moveToFirst()) {
                Especial.setText(fila.getString(0));

            } else {
                Toast.makeText(this, "Esta mesa no ha realizado ninguna orden", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.activity_pantalla_pedidos);
            }

        } else {
            Toast.makeText(this, "Esta mesa no ha realizado ninguna orden", Toast.LENGTH_SHORT).show();

        }
    }

    public void Salir(View view){
        Intent salida = new Intent(this,MainActivity.class);
        startActivity(salida);
    }
}