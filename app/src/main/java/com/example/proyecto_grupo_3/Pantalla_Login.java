package com.example.proyecto_grupo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Pantalla_Login extends AppCompatActivity {

    private EditText ob_usuario,ob_contra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_login);

        ob_usuario=(EditText) findViewById(R.id.txtUsuario);
        ob_contra=(EditText) findViewById(R.id.txtContra);


    }
    public void ingresar(View view){
        BaseDeDatos admin = new BaseDeDatos(this,"administrador",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String usuario = ob_usuario.getText().toString();//obtener el usuario del teclado
        String contra = ob_contra.getText().toString();//obtener el contra del teclado

        if(!usuario.isEmpty() && !contra.isEmpty()){
            String query="select Usuario.nombre_usuario,Usuario.contrasena,Empleado_Puesto.descripcion_puesto from Usuario inner join Empleados on Empleados.codigo_empleado = Usuario.codigo_empleado inner join Empleado_Puesto on Empleado_Puesto.codigo_puesto = Empleados.codigo_puesto where Usuario.nombre_usuario='"+usuario+"'";
            Cursor fila=BaseDeDatos.rawQuery(query,null);
            if (fila.moveToFirst()){
                String clave= fila.getString(1);
                String puesto= fila.getString(2);
                if (clave.equals(contra)){
                    if (puesto.equals("Mesero")){
                        Toast.makeText(this,"mesero",Toast.LENGTH_SHORT).show();
                        BaseDeDatos.close();
                        Intent Menu= new Intent(this,Pantalla_Menu.class);
                        startActivity(Menu);
                    }
                    if (puesto.equals("Cajero")){
                        Toast.makeText(this,"Cajero ",Toast.LENGTH_SHORT).show();
                        BaseDeDatos.close();
                        Intent detalle= new Intent(this,Pantalla_Pedido_Detalle.class);
                        startActivity(detalle);

                    }else{Toast.makeText(this,"No tenes puesto "+puesto,Toast.LENGTH_SHORT).show();}


                }else{
                    ob_contra.setError("Contraseña Incorrecta");
                    BaseDeDatos.close();
                }
            }else{
                Toast.makeText(this,"Usuario incorrecto",Toast.LENGTH_SHORT).show();
                BaseDeDatos.close();
            }
        }
        else{
            Toast.makeText(this,"Ingrese Usuario y Contraseña",Toast.LENGTH_SHORT).show();
            BaseDeDatos.close();

        }
    }
}