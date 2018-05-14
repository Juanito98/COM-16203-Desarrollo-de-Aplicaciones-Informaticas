package jcsiglerp.androidproject.buscar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import jcsiglerp.androidproject.Model.Prenda;
import jcsiglerp.androidproject.R;

public class Buscar extends AppCompatActivity implements BuscarAdapter.AddToCartClickedListener {

    EditText etBuscar;
    RecyclerView rvBusqueda;
    Prenda prendas[] = {new Prenda("Pantalon", "Pantalon azul", 150),
                        new Prenda("Playera", "Playera blanca", 200)};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        etBuscar = (EditText) findViewById(R.id.etBuscar);
        rvBusqueda = (RecyclerView) findViewById(R.id.rvBusqueda);

        etBuscar.setOnEditorActionListener(new EditText.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                buscar(Buscar.this.getCurrentFocus());
                return true;
            }
        });

        rvBusqueda.setLayoutManager(new LinearLayoutManager(this));
        rvBusqueda.setAdapter(new BuscarAdapter(this));

        List<Prenda> your_array_list = new ArrayList<Prenda>();
        your_array_list.add(prendas[0]);
        your_array_list.add(prendas[1]);

        ((BuscarAdapter)rvBusqueda.getAdapter()).setData(your_array_list);

    }

    protected void buscar(View v) {
        Toast.makeText(this, "Buscaste: " + etBuscar.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void itemClicked(Prenda prenda) {

    }
}
