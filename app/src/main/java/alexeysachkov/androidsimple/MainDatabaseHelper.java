package alexeysachkov.androidsimple;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by asachkov on 20.03.2016.
 */
public class MainDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "android.simple.db";
    public static final int VERSION = 1;

    public  MainDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Category.getCreateTableSQL());
        db.execSQL(Note.getCreateTableSQL());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
