package fr.domurado.escalier;

import android.app.Application;

import fr.domurado.escalier.database.MyMigration;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class EscalierApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration config = new RealmConfiguration.Builder(this)
                .name("escalier.realm")
                .schemaVersion(2)
                .migration(new MyMigration())
                .build();
        Realm.setDefaultConfiguration(config);
    }
}
