package jcsiglerp.androidproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Historial extends AppCompatActivity {

    TextView tvHistorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        tvHistorial = (TextView) findViewById(R.id.tvHistorial);
        tvHistorial.setText("Al parecer no tienes compras");
    }
}
