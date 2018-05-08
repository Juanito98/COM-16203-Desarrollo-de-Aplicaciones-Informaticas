package com.example.dai.realmexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etCU, etApellido, etSemestre;
    Button btSave;
    TextView tvAlumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etCU = (EditText) findViewById(R.id.etCU);
        etApellido = (EditText) findViewById(R.id.etApellido);
        etSemestre = (EditText) findViewById(R.id.etSemestre);
        tvAlumnos = (TextView) findViewById(R.id.tvAlumnos);

        btSave = (Button) findViewById(R.id.btSave);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alumno a = new Alumno();
                a.cu = Integer.parseInt(etCU.getText().toString());
                a.semeste = Integer.parseInt(etSemestre.getText().toString());
                a.nombre = etNombre.getText().toString();
                a.apellido = etApellido.getText().toString();

                Realm realm = ((MyApplication) getApplication()).getRealm();
                realm.beginTransaction();
                realm.copyToRealm(a);
                realm.commitTransaction();
                // Otra forma de hacerlo mejor -> realm.createObject()
            }
        });

        Realm realm = ((MyApplication) getApplication()).getRealm();
        RealmResults <Alumno> results = realm.where(Alumno.class).findAll();
        String keys = "";
        for (Alumno a : results) {
            keys += a.cu + ", ";
        }
        tvAlumnos.setText(keys);
    }
}
