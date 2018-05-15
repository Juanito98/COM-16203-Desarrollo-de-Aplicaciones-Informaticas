package jcsiglerp.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import jcsiglerp.androidproject.Model.Usuario;

public class Registrarse extends AppCompatActivity {

    EditText nombre, correo, contra, direccion;
    Button btRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        nombre = (EditText) findViewById(R.id.etNombre);
        correo = (EditText) findViewById(R.id.etCorreo);
        contra = (EditText) findViewById(R.id.etContra);
        direccion = (EditText) findViewById(R.id.etDireccion);
        btRegistro = (Button) findViewById(R.id.btRegistrarse);

        btRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario a = new Usuario(nombre.getText().toString(), correo.getText().toString(), contra.getText().toString(), direccion.getText().toString());
                Realm realm = ((MyApplication) getApplication()).getRealm();
                if(realm.where(Usuario.class).equalTo("correo", a.correo).count() > 0) {
                    Toast.makeText(Registrarse.this, "Este correo ya fue usado", Toast.LENGTH_LONG).show();
                } else {
                    realm.beginTransaction();
                    realm.copyToRealm(a);
                    realm.commitTransaction();
                    Intent intent = new Intent(Registrarse.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
