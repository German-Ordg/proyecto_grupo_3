package com.example.proyecto_grupo_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDeDatos extends SQLiteOpenHelper {


    public BaseDeDatos(@Nullable Context context, @Nullable String name,
                       @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //metodo create
    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("create table Codigo_qr(numero_mesa integer PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "codigo_qr text not null)");
        BaseDeDatos.execSQL("create table Categoria_Producto(codigo_categoria integer PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "descripcion_categoria text not null)");
        BaseDeDatos.execSQL("create table Productos(codigo_producto integer PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "codigo_categoria integer not null, descripcion_producto text not null, precio_actual real not null," +
                " foreign key(codigo_categoria) references Categoria_Producto(codigo_categoria))");
        BaseDeDatos.execSQL("create table Ordenes(codigo_orden integer PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "codigo_producto integer not null, cantidad integer not null, precio real not null," +
                " masa text not null, tamaño text not null," +
                " foreign key(codigo_producto) references Productos(codigo_producto))");
        BaseDeDatos.execSQL("create table Estado(codigo_estado integer primary key AUTOINCREMENT NOT NULL," +
                "descripcion_estado text not null)");
        BaseDeDatos.execSQL("create table Empleado_Puesto(codigo_puesto integer primary key AUTOINCREMENT NOT NULL," +
                "descripcion_puesto text not null)");
        BaseDeDatos.execSQL("create table Empleados(codigo_empleado integer primary key AUTOINCREMENT NOT NULL," +
                "codigo_puesto integer not null,nombre_empleado text not null,apellido_empleado text not null," +
                "numero_identidad_empleado text not null," +
                "fecha_nacimiento text,fecha_ingreso text not null,num_telefono text,genero text," +
                "foreign key(codigo_puesto)references Empleado_Puesto(codigo_puesto))");
        BaseDeDatos.execSQL("create table Usuario(nombre_usuario text primary key," +
                "codigo_empleado integer not null,codigo_estado integer not null," +
                "contrasena text not null,correo_electronico text not null," +
                "foreign key (codigo_empleado) references Empleados(codigo_empleado)," +
                "foreign key (codigo_estado) references Estado(codigo_estado))");
        BaseDeDatos.execSQL("create table Pedidos(codigo_pedido integer PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "codigo_orden integer not null, codigo_estado integer not null, numero_mesa integer not null," +
                " foreign key(codigo_estado) references Estado(codigo_estado)," +
                "foreign key(numero_mesa) references Codigo_qr(numero_mesa)," +
                "foreign key(codigo_orden) references Ordenes(codigo_orden))");


        }

        //metodo upgrade
        @Override
        public void onUpgrade (SQLiteDatabase BaseDeDatos,int OldVersion, int NewVersion){
        }
}
