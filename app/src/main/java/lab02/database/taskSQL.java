package lab02.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Silwest on 09.04.14.
 */
public class taskSQL {
    private SQLiteDatabase database;
    private databaseSQL database_helper;

    public taskSQL(Context context) {
        database_helper = new databaseSQL(context);
        this.database = database_helper.getWritableDatabase();
    }

    public void closeDataBase(){
        database.close();
    }

    public void addEntry(String text){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", text);
        database.insert("entry", null, contentValues);
    }

    public void deleteEntry(int entry_id){
        database.delete("entry", "_id = " + entry_id, null);
    }
    public List<Tasks> getEntries(){
        List<Tasks> entryList = new ArrayList<Tasks>();

        String[] tableCoumns = new String[] {"_id", "name"};

        //Query database

        Cursor cursor = database.query("entry", tableCoumns, null, null, null, null, null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            Tasks task = new Tasks();

            task.setID(cursor.getInt(0));
            task.setText(cursor.getString(1));

            entryList.add(task);
            cursor.moveToNext();
        }
        return entryList;
    }
}
