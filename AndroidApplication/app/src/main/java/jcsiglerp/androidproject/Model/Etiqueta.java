package jcsiglerp.androidproject.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Etiqueta extends RealmObject {
    @PrimaryKey
    public String nombre;
}
