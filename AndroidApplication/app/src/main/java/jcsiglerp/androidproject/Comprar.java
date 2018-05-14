package jcsiglerp.androidproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

public class Comprar extends AppCompatActivity {

    RecyclerView rvCompra;
    Button btComprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar);

        rvCompra = (RecyclerView) findViewById(R.id.rvCompra);
        btComprar = (Button) findViewById(R.id.btComprar);
    }
}
