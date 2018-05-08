package com.example.dai.realmexample;

import android.app.Application;

import io.realm.Realm;

public class MyApplication extends Application {

    Realm realm;

    public void onCreate() {
        super.onCreate();
        // Se inicializa
        Realm.init(this);
        realm = Realm.getDefaultInstance();
    }

    public Realm getRealm() {
        return realm;
    }

}
