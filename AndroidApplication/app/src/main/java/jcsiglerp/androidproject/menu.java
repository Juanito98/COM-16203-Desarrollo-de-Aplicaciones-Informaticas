package jcsiglerp.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    protected void comprar(View v) {
        Intent m = new Intent(getApplicationContext(), Comprar.class);
        startActivity(m);
    }
}
