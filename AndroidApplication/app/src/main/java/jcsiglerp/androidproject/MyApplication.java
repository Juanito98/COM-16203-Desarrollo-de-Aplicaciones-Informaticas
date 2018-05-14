package jcsiglerp.androidproject;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import jcsiglerp.androidproject.Model.Etiqueta;
import jcsiglerp.androidproject.Model.Prenda;
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

                        Etiqueta etiquetas[] = {
                                new Etiqueta(0, "blusa"),
                                new Etiqueta(1,"pantalon"),
                                new Etiqueta(2,"falda"),
                                new Etiqueta(3,"shorts"),
                                new Etiqueta(4, "vestido"),
                                new Etiqueta(5, "chamarra"),
                                new Etiqueta(6, "playera"),
                                new Etiqueta(7, "camisa"),
                                new Etiqueta(8, "azul"),
                        };

                        for(Etiqueta e : etiquetas)
                            realm.copyToRealm(e);

                        Prenda p = new Prenda("Camiseta con estampa americana", 200.99,"https://anf.scene7.com/is/image/anf/hol_213746_02_prod1?$product-hol-v1$&wid=1900&hei=2375");
                        p.addEtiqueta(realm.where(Etiqueta.class).findFirst());
                        //p.addEtiqueta(etiquetas[8]);
                        realm.copyToRealm(p);

                    }
                })
                .build();
        realm = Realm.getInstance(config);
    }

    public Realm getRealm() {
        return realm;
    }
}
