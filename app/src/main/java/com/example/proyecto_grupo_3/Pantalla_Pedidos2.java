package com.example.proyecto_grupo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;

public class Pantalla_Pedidos2 extends AppCompatActivity {

    public static final String MESA1="mesa1";
    private Button boton1, boton2, boton3, boton4;
    int mesa1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_pedidos2);
        BaseDeDatos admin = new BaseDeDatos(this,"administrador",null,1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();
        boton1 = (Button) findViewById(R.id.btnmes1);
        boton2 = (Button) findViewById(R.id.btnmes2);
        boton3 = (Button) findViewById(R.id.btnmes3);
        boton4 = (Button) findViewById(R.id.btnmes4);
        boton1.setOnClickListener((view) ->{
            Intent intent = new Intent(this,Pantalla_Pedido_Detalle.class) ;
            mesa1=1;
            intent.putExtra(MESA1,mesa1);
            startActivity(intent);

        });
        boton2.setOnClickListener((view) ->{
            Intent intent = new Intent(this,Pantalla_Pedido_Detalle.class) ;
            mesa1=2;
            intent.putExtra(MESA1,mesa1);
            startActivity(intent);

        });
        boton3.setOnClickListener((view) ->{
            Intent intent = new Intent(this,Pantalla_Pedido_Detalle.class) ;
            mesa1=3;
            intent.putExtra(MESA1,mesa1);
            startActivity(intent);

        });
        boton4.setOnClickListener((view) ->{
            Intent intent = new Intent(this,Pantalla_Pedido_Detalle.class) ;
            mesa1=4;
            intent.putExtra(MESA1,mesa1);
            startActivity(intent);

        });
    }




}