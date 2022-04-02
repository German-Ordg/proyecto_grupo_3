package com.example.proyecto_grupo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class Pantalla_Codigo_Mesa extends AppCompatActivity {

    ImageView instagram;
    ImageView twitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_codigo_mesa);
    }

    public void conectarInstagram(View view) {
        Intent instagram = new Intent(this, instagram.class);
        startActivity(instagram);
    }

    public void conectarFacebook(View view) {
        Intent facebook = new Intent(this, facebook.class);
        startActivity(facebook);
    }

    public void conectarTwitter(View view) {
        Intent twitter = new Intent(this, twitter.class);
        startActivity(twitter);
    }

    public void irescaner(View view) {
        Intent escaner = new Intent(this, escaner.class);
        startActivity(escaner);
    }
}