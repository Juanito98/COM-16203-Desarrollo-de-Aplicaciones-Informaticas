package jcsiglerp.androidproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import jcsiglerp.androidproject.Model.Pedido;
import jcsiglerp.androidproject.Model.Prenda;

public class Buscar extends AppCompatActivity {

    EditText etBuscar;
    ListView lvBusqueda;
    Prenda prendas[] = {new Prenda("Pantalon", "Pantalon azul", 150),
                        new Prenda("Playera", "Playera blanca", 200)};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        etBuscar = (EditText) findViewById(R.id.etBuscar);
        lvBusqueda = (ListView) findViewById(R.id.lvBusqueda);

        etBuscar.setOnEditorActionListener(new EditText.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                buscar(Buscar.this.getCurrentFocus());
                return true;
            }
        });

        List<Prenda> your_array_list = new ArrayList<Prenda>();
        your_array_list.add(prendas[0]);
        your_array_list.add(prendas[1]);

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<Prenda> arrayAdapter = new ArrayAdapter<Prenda>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );

        lvBusqueda.setAdapter(arrayAdapter);
    }

    protected void buscar(View v) {
        Toast.makeText(this, "Buscaste: " + etBuscar.getText().toString(), Toast.LENGTH_SHORT).show();
    }

}
