package jcsiglerp.androidproject.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Etiqueta extends RealmObject {
    @PrimaryKey
    int id;

    public String nombre;

    public Etiqueta(){}

    public Etiqueta(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
