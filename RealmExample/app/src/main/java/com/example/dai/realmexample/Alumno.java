package com.example.dai.realmexample;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Alumno extends RealmObject {

    @PrimaryKey
    int cu;

    String nombre, apellido;
    int semeste;
}
