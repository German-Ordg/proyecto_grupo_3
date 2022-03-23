package com.example.proyecto_grupo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Pantalla_Pedidos extends AppCompatActivity {

    private EditText ob_qr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_pedidos);

        //variables objetos xml a java
        ob_qr=(EditText) findViewById(R.id.txtqr);

    }

    public void ingresar(View view){
        BaseDeDatos admin = new BaseDeDatos(this,"administrador",null,1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();
        String codigo= ob_qr.getText().toString();


        if (!codigo.isEmpty()) {

            ContentValues registro = new ContentValues();//Contenedor de registro
            registro.put("codigo_qr", codigo);//insertar codigo en la tabla


            Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();
            BaseDatos.insert("Codigo_qr", null, registro);
            BaseDatos.close();

        } else{
            Toast.makeText(this, "Todos los campus deben llenarse", Toast.LENGTH_SHORT).show();
        }
        ob_qr.setText("");
    }
}