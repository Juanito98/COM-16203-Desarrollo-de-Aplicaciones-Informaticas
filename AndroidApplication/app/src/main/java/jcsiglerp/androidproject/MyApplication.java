package jcsiglerp.androidproject;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {
    Realm realm;

    public void onCreate() {
        super.onCreate();
        // Se inicializa
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        realm = Realm.getInstance(config);
    }

    public Realm getRealm() {
        return realm;
    }
}
