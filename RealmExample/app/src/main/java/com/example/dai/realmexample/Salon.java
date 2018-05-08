package com.example.dai.realmexample;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Salon extends RealmObject {
    RealmList<Alumno> alumnos;
}
