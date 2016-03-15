package fr.domurado.escalier;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class EscalierApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration config = new RealmConfiguration.Builder(this)
                .name("escalier.realm")
                .schemaVersion(1)
                .build();
        Realm.setDefaultConfiguration(config);
    }
}
