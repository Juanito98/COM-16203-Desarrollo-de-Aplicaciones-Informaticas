package jcsiglerp.androidproject.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Usuario extends RealmObject{
    public String nombre;

    @PrimaryKey
    public String correo;

    public String contra, direccion;

    public Usuario(String nombre, String correo, String contra, String direccion) {
        this.nombre = nombre;
        this.correo = correo;
        this.contra = contra;
        this.direccion = direccion;
    }

    public Usuario() {}
}
