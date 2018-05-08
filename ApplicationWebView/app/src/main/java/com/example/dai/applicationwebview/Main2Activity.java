package com.example.dai.applicationwebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView nombre;
    private WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nombre = (TextView) findViewById(R.id.tvHola);
        wb = (WebView) findViewById(R.id.wvHola);
        Bundle b = this.getIntent().getExtras();
        nombre.setText("Hola " + b.get("Nombre"));

        wb.loadUrl("https://www.itam.mx/");
        wb.getSettings().setJavaScriptEnabled(true);
        wb.setWebViewClient(new WebViewClient());
    }
}
