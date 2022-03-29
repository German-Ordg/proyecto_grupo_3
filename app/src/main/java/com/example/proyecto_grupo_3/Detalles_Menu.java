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

    public void ingresar(View view){
        //Variables
        int codigo;
        double precio;
        String tipomasa;
        String tipotamano;


        //Metodos Get
        cantidad= (EditText)findViewById(R.id.txtcantidad);
        masa= (RadioGroup)findViewById(R.id.rgmasa);
        tamano= (RadioGroup)findViewById(R.id.rgtamaño);
        mesa= (RadioGroup)findViewById(R.id.rgmesa);

        masa1= (RadioButton)findViewById(R.id.rbmuydelgada);
        masa2= (RadioButton)findViewById(R.id.rbdelgada);
        masa3= (RadioButton)findViewById(R.id.rbpanpizza);

        tam1= (RadioButton)findViewById(R.id.rbpersonal);
        tam2= (RadioButton)findViewById(R.id.rbgrande);
        tam3= (RadioButton)findViewById(R.id.rbfamiliar);





        //If Especialidad de la Pizza
        if(pizza.toString() == "Napolitana"){
            codigo=1;
            precio= 150;
        }
        else if (pizza.toString()== "Pepperoni"){
            codigo=2;
            precio= 160;
        }else if (pizza.toString()== "Suprema"){
            codigo=3;
            precio= 170;
        }else{
            codigo=4;
            precio= 150;
        }



        //If Grosor de la masa
        if(masa1.isChecked()){
            tipomasa= "Muy Delgada";
        }else if(masa2.isChecked()){
            tipomasa= "Delgada";
        }else{
            tipomasa= "Pan Pizza";
        }


        //If Tamaño de la Pizza
        if(tam1.isChecked()){
            tipotamano= "Personal";
        }else if(tam2.isChecked()){
            tipotamano= "Grande";
        }else{
            tipotamano= "Familiar";
        }

        BaseDeDatos admin= new BaseDeDatos(this, "administrador", null, 1);
        //SQLiteDatabase BaseDatos= admin.getWritableDatabase();
        base.agregardatos(codigo, Integer.parseInt(cantidad.toString()), precio, tipomasa, tipotamano);

    }

    /*public void ingresar(View view) {
        adminSQLiteOpen admin = new adminSQLiteOpen(this, "Aministrador", null, 1);
        //conexion a base de datos
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();//base de datos, estado de escritura

        String codigo = ob_codigo.getText().toString();
        String nombre = ob_nombre.getText().toString();
        String campus = ob_campus.getText().toString();

        if (!codigo.isEmpty() && !nombre.isEmpty() && !campus.isEmpty()) {

            ContentValues registro = new ContentValues();//Contenedor de registro
            registro.put("codigo", codigo);//insertar codigo en la tabla
            registro.put("nombre",nombre);//insertar nombre en la tabla
            registro.put("campus", campus);//insertar campus en la tabla

            Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();
            BaseDeDatos.insert("Registro", null, registro);
            BaseDeDatos.close();

        } else{
            Toast.makeText(this, "Todos los campus deben llenarse", Toast.LENGTH_SHORT).show();
        }
        ob_codigo.setText("");
        ob_nombre.setText("");
        ob_campus.setText("");


    }*/

}