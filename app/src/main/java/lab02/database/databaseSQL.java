package lab02.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Silwest on 09.04.14.
 */
public class databaseSQL extends SQLiteOpenHelper{

    public databaseSQL(Context context){
        super(context, "entry_db", null, 1);
    }
    public databaseSQL(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE entry (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int old_ver, int new_ver) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS entry");
        onCreate(sqLiteDatabase);
    }
}
