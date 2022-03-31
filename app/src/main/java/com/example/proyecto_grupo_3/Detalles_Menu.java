package com.example.proyecto_grupo_3;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.se.omapi.Reader;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.sql.Connection;

import com.example.proyecto_grupo_3.BaseDeDatos;

import java.sql.ResultSet;
import java.sql.SQLData;


public class Detalles_Menu extends AppCompatActivity {

    private TextView pizza;

    private EditText cantidad;
    private RadioGroup masa;
    private RadioGroup tamano;
    private RadioGroup mesa;

    private RadioButton masa1;
    private RadioButton masa2;
    private RadioButton masa3;

    private RadioButton tam1;
    private RadioButton tam2;
    private RadioButton tam3;

    private RadioButton mesa1;
    private RadioButton mesa2;
    private RadioButton mesa3;
    private RadioButton mesa4;

    //BaseDeDatos base= new BaseDeDatos();
    BaseDeDatos base;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_menu);

        pizza= (TextView) findViewById(R.id.txtdato);

        String dato= getIntent().getStringExtra("dato");

        pizza.setText(dato);
    }

    public void ingresar(View view) {
        //Variables
        int codigo = 0;
        int codigo_orden=0;
        float precio = 0;
        String tipomasa = "";
        String tipotamano = "";
        int numeromesa;

        //Metodos Get
        cantidad = (EditText) findViewById(R.id.txtcantidad);
        masa = (RadioGroup) findViewById(R.id.rgmasa);
        tamano = (RadioGroup) findViewById(R.id.rgtamaño);
        mesa = (RadioGroup) findViewById(R.id.rgmesa);

        masa1 = (RadioButton) findViewById(R.id.rbmuydelgada);
        masa2 = (RadioButton) findViewById(R.id.rbdelgada);
        masa3 = (RadioButton) findViewById(R.id.rbpanpizza);

        tam1 = (RadioButton) findViewById(R.id.rbpersonal);
        tam2 = (RadioButton) findViewById(R.id.rbgrande);
        tam3 = (RadioButton) findViewById(R.id.rbfamiliar);

        mesa1 = (RadioButton) findViewById(R.id.rbmesa1);
        mesa2 = (RadioButton) findViewById(R.id.rbmesa2);
        mesa3 = (RadioButton) findViewById(R.id.rbmesa3);
        mesa4 = (RadioButton) findViewById(R.id.rbmesa4);

        int numero = Integer.parseInt(cantidad.getText().toString());


        /*BaseDeDatos bd = new BaseDeDatos(this, "administrador", null, 1);
        SQLiteDatabase base = bd.getReadableDatabase();

        Cursor cursor= base.rawQuery("select max(codigo_orden +1) from Ordenes", null);

        codigo_orden= Integer.parseInt(cursor.getString(0));

        Pantalla_Menu menu= new Pantalla_Menu();*/

        //If Especialidad de la Pizza
        if (pizza.length() == 10) {
            codigo = 1;
            precio = 150;
        } else if (pizza.length() == 9) {
            codigo = 2;
            precio = 160;
        } else if (pizza.length() == 7) {
            codigo = 3;
            precio = 170;
        } else if (pizza.length() == 5) {
            codigo = 4;
            precio = 150;
        }
        else
        {
            Toast.makeText(this,"ERROR", Toast.LENGTH_SHORT).show();
        }


        //If Grosor de la masa
        if (masa1.isChecked()) {
            tipomasa = "Muy Delgada";
        } else if (masa2.isChecked()) {
            tipomasa = "Delgada";
        } else if (masa3.isChecked()) {
            tipomasa = "Pan Pizza";
        }

        //If Tamaño de la Pizza
        if (tam1.isChecked()) {
            tipotamano = "Personal";
        } else if (tam2.isChecked()) {
            tipotamano = "Grande";
        } else if (tam3.isChecked()) {
            tipotamano = "Familiar";
        }

        if(mesa1.isChecked()){
            numeromesa= 1;
        }else if(mesa2.isChecked()){
            numeromesa= 2;
        }else if(mesa3.isChecked()){
            numeromesa= 3;
        }else{
            numeromesa=4;
        }



        //Base en modo escritura
        BaseDeDatos admin = new BaseDeDatos(this, "administrador", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();


       //Ingresar Ordenes
       if (numero != 0 && !tipomasa.isEmpty() && !tipotamano.isEmpty()) {
            ContentValues ordenes = new ContentValues();
            Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();
            ordenes.put("codigo_producto ", codigo);
            ordenes.put("cantidad", numero);
            ordenes.put("precio", precio);
            ordenes.put("masa", tipomasa);
            ordenes.put("tamaño", tipotamano);

            Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();
            BaseDeDatos.insert("Ordenes", null, ordenes);


           Cursor c = BaseDeDatos.rawQuery("SELECT max(codigo_orden) from Ordenes", null);

           if (c != null) {
               c.moveToFirst();
               do {
                   //Asignamos el valor en nuestras variables para usarlos en lo que necesitemos
                   @SuppressLint("Range") String orden = c.getString(c.getColumnIndex("max(codigo_orden)"));

           //Ingresar Pedidos
           ContentValues pedidos = new ContentValues();
           Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();
           pedidos.put("codigo_orden", orden);
           pedidos.put("codigo_estado", 1);
           pedidos.put("numero_mesa", numeromesa);

           Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();
           BaseDeDatos.insert("Pedidos", null, pedidos);

           //Cerrar Base de Datos
            BaseDeDatos.close();
               } while (c.moveToNext());
           }

            //Validacion Campos Vacios
            }if(masa1.isChecked()==false){masa1.setError("Seleccione una opcion");}
                if(masa2.isChecked()==false){masa2.setError("Seleccione una opcion");}
                if(masa3.isChecked()==false){masa3.setError("Seleccione una opcion");}

                if(tam1.isChecked()==false){tam1.setError("Seleccione una opcion");}
                if(tam2.isChecked()==false){tam2.setError("Seleccione una opcion");}
                if(tam3.isChecked()==false){tam3.setError("Seleccione una opcion");}

                if(mesa1.isChecked()==false){mesa1.setError("Seleccione una opcion");}
                if(mesa2.isChecked()==false){mesa2.setError("Seleccione una opcion");}
                if(mesa3.isChecked()==false){mesa3.setError("Seleccione una opcion");}
                if(mesa4.isChecked()==false){mesa4.setError("Seleccione una opcion");

       }
    }
}
