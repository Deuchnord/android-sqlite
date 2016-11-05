package fr.deuchnord.tpandroid_tpsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerome on 05/11/16.
 */

public class StudentDb extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Students";

    static class StudentTable implements BaseColumns {
        public static final String TABLE_NAME = "Student";
        public static final String STUDENT_NAME = "name";
    }

    public StudentDb(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("CREATE TABLE Student(" + StudentTable.TABLE_NAME + " INTEGER PRIMARY KEY," +
                StudentTable.STUDENT_NAME + " VARCHAR(100))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        // Nothing to do here :)
    }

    public List<String> getStudents()
    {
        ArrayList<String> names = new ArrayList<>();

        // TODO: à compléter

        return names;
    }

    public long putStudent(String name)
    {
        // TODO: à compléter
        // Attention, cette classe doit retourner l'ID de l'étudiant nouvellement ajouté !
    }
}
