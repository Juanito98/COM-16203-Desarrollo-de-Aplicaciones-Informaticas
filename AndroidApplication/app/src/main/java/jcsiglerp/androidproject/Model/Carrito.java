package jcsiglerp.androidproject.Model;

import java.util.UUID;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Carrito extends RealmObject {
    @PrimaryKey
    public String id = UUID.randomUUID().toString();

    Usuario usuario;
    public RealmList < Prenda > contenido;
    public int precioTotal;

    public void agregarPrenda(Prenda p) {
        contenido.add(p);
        precioTotal += p.precio;
    }
}
