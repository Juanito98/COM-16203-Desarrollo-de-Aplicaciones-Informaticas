package jcsiglerp.androidproject.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Usuario extends RealmObject{

    @PrimaryKey
    public String correo;

    public String nombre, contra, direccion;

    Carrito carrito = new Carrito();

    public Usuario() {}

    public Usuario(String nombre, String correo, String contra, String direccion) {
        this.nombre = nombre;
        this.correo = correo;
        this.contra = contra;
        this.direccion = direccion;
    }
}
