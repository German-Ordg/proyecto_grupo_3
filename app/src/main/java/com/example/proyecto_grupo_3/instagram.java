package com.example.proyecto_grupo_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class instagram extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        WebSettings settings = myWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://www.instagram.com/pizzahuthn/");
    }
}