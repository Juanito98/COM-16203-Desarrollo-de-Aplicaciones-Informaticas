package com.example.dai.applicationwebview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nom;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom = (EditText) findViewById(R.id.etNombre);
        boton = (Button) findViewById(R.id.btSiguiente);
    }

    public void aceptar(View v) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        Bundle b = new Bundle();
        b.putString("Nombre", nom.getText().toString());
        intent.putExtras(b);
        startActivity(intent);
    }
}
