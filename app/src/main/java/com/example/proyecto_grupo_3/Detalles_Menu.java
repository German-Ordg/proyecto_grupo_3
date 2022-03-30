package com.example.proyecto_grupo_3;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto_grupo_3.BaseDeDatos;


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
        float precio = 0;
        String tipomasa = "";
        String tipotamano = "";


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

        String dato = getIntent().getStringExtra("dato");
        int numero = Integer.parseInt(cantidad.getText().toString());

        //If Especialidad de la Pizza
        if (dato == "Napolitana") {
            codigo = 1;
            precio = 150;
        } else if (dato == "Pepperoni") {
            codigo = 2;
            precio = 160;
        } else if (dato == "Suprema") {
            codigo = 3;
            precio = 170;
        } else if (dato == "Queso") {
            codigo = 4;
            precio = 150;
        }
        else
        {
            codigo = 5;
            precio = 150;
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

        BaseDeDatos admin = new BaseDeDatos(this, "administrador", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();


       if (numero != 0 && !tipomasa.isEmpty() && !tipotamano.isEmpty()) {
            ContentValues ordenes = new ContentValues();
           Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();
            ordenes.put("codigo_producto", codigo);
            ordenes.put("cantidad", numero);
            ordenes.put("precio", precio);
            ordenes.put("masa", tipomasa);
            ordenes.put("tamaño", tipotamano);

            Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();
            BaseDeDatos.insert("Ordenes", null, ordenes);
            BaseDeDatos.close();
            }else if(codigo == 0 || cantidad==null || precio==0 || tipomasa=="" || tipotamano==""){
               Toast.makeText(this,"Todos los campos deben llenarse", Toast.LENGTH_SHORT).show();
            }
        }
    }
