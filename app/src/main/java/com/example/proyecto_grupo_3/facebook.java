package com.example.proyecto_grupo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class facebook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://www.facebook.com/pizzahuthonduras/");
    }
}