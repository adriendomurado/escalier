package fr.domurado.escalier;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;
import android.test.mock.MockContext;

import org.junit.Test;
import org.junit.runner.RunWith;

import fr.domurado.escalier.database.EscalierOpenHelper;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Test
    public void dbTest() {
        EscalierOpenHelper escalierOpenHelper = new EscalierOpenHelper(InstrumentationRegistry.getTargetContext());
        SQLiteDatabase db = escalierOpenHelper.getWritableDatabase();
        assertEquals(1,db.getVersion());
    }
}