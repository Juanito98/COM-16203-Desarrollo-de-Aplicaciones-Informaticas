package jcsiglerp.androidproject.historial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;
import jcsiglerp.androidproject.Model.Pedido;
import jcsiglerp.androidproject.Model.Usuario;
import jcsiglerp.androidproject.MyApplication;
import jcsiglerp.androidproject.R;
import jcsiglerp.androidproject.comprar.ComprarAdapter;

public class Historial extends AppCompatActivity implements HistorialAdapter.viewOnClickPedidoListener {

    RecyclerView rvHistorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        rvHistorial = (RecyclerView) findViewById(R.id.rvHistorial);
        rvHistorial.setLayoutManager(new LinearLayoutManager(this));
        rvHistorial.setAdapter(new HistorialAdapter(this));

        Realm realm = ((MyApplication) getApplication()).getRealm();
        Bundle b = this.getIntent().getExtras();

        RealmResults <Pedido> results = realm.where(Pedido.class).equalTo("usuario.correo", b.get("correo").toString()).findAll();
        ((HistorialAdapter) rvHistorial.getAdapter()).setData(results);
    }

    @Override
    public void itemClicked(Pedido pedido) {

    }
}
