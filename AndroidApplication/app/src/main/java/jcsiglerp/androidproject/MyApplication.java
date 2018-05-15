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
                                realm.createObject(Etiqueta.class, "blusa"),
                                realm.createObject(Etiqueta.class, "pantalon"),
                                realm.createObject(Etiqueta.class, "falda"),
                                realm.createObject(Etiqueta.class, "shorts"),
                                realm.createObject(Etiqueta.class, "vestido"),
                                realm.createObject(Etiqueta.class, "chamarra"),
                                realm.createObject(Etiqueta.class, "playera"),
                                realm.createObject(Etiqueta.class, "camisa"),
                                realm.createObject(Etiqueta.class, "azul")
                        };

                        Prenda p = new Prenda("Camiseta con estampa americana", 200.99,"https://anf.scene7.com/is/image/anf/hol_213746_02_prod1?$product-hol-v1$&wid=1900&hei=2375");
                        p.addEtiqueta(etiquetas[7]);
                        p.addEtiqueta(etiquetas[8]);
                        realm.copyToRealm(p);

                        p = new Prenda("Shorts de denim superajustados", 149.99, "https://anf.scene7.com/is/image/anf/hol_200251_01_prod1?$product-hol-v1$&wid=1900&hei=2375");
                        p.addEtiqueta(etiquetas[3]);
                        p.addEtiqueta(etiquetas[8]);
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
