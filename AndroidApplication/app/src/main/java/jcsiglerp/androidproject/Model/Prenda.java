package jcsiglerp.androidproject.Model;

import java.util.UUID;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Prenda extends RealmObject {
    @PrimaryKey
    String id = UUID.randomUUID().toString();

    public String nombre;
    RealmList < Etiqueta > etiquetas;
    public String descripcion;
    public int precio;

    public Prenda() {}

    public Prenda(String nombre, String descripcion, int precio) {
        this.nombre = nombre;
        this.etiquetas = etiquetas;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public void addEtiqueta(Etiqueta etiqueta) {
        this.etiquetas.add(etiqueta);
    }
}
