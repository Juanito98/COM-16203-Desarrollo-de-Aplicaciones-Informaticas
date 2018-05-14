package jcsiglerp.androidproject;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import jcsiglerp.androidproject.Model.Usuario;

public class MyApplication extends Application {
    Realm realm;

    public void onCreate() {
        super.onCreate();
        // Se inicializa
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .initialData(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                    }
                })
                .build();
        realm = Realm.getInstance(config);
    }

    public Realm getRealm() {
        return realm;
    }
}
