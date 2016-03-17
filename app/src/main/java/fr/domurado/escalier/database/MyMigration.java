package fr.domurado.escalier.database;


import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

public class MyMigration implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

        RealmSchema schema = realm.getSchema();

        // Migrate to version 2 : add a field in Round
        if (oldVersion == 1) {
            schema.get("Round")
                    .addField("up", boolean.class);
            oldVersion++;
        }
    }
}
