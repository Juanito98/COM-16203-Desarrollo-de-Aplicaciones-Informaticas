package jcsiglerp.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void login(View w) {
        Intent m = new Intent(getApplicationContext(), Buscar.class);
        startActivity(m);
    }

    protected void signup(View w) {
        Intent m = new Intent(getApplicationContext(), Registrarse.class);
        startActivity(m);
    }
}
