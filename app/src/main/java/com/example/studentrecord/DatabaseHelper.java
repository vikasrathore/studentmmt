package com.example.studentrecord;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "register.db";
    public static final String TABLE_NAME = "register";
    public static final String ID = "ID";
    public static final String NAME = "stname";
    public static final String ROLLNO = "rollno";
    public static final String CLASS = "class";
    public static final String FATHERNAME = "fathername";
    public static final String MOTHERNAME = "mothername";
    public static final String PHONENO = "phoneno";
    private static DatabaseHelper mInstance;
    private String S = "DatabaseHelper";


    private DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    public static DatabaseHelper getInstance(Context ctx) {
        if (mInstance == null) {
            mInstance = new DatabaseHelper(ctx.getApplicationContext());
        }
        return mInstance;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,stname TEXT,rollno TEXT,class TEXT,fathername TEXT,mothername TEXT,phoneno TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int newversion, int oldversion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public boolean addData(String item) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, item);
        contentValues.put(ROLLNO, item);
        contentValues.put(CLASS, item);
        contentValues.put(FATHERNAME, item);
        contentValues.put(MOTHERNAME, item);
        contentValues.put(PHONENO, item);
        long inserted = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        Log.e(S, "add Data" + item + "to" + TABLE_NAME);
        sqLiteDatabase.close();
        return inserted == -1 ? false : true;

    }

    public List<Student> getData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from register", null);
        List<Student> students = new ArrayList<Student>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndex(ID));
                String name = cursor.getString(cursor.getColumnIndex(NAME));
                String studentClass = cursor.getString(cursor.getColumnIndex(CLASS));
                String rollNumber = cursor.getString(cursor.getColumnIndex(ROLLNO));
                String father = cursor.getString(cursor.getColumnIndex(FATHERNAME));
                String mother = cursor.getString(cursor.getColumnIndex(MOTHERNAME));
                String mobile = cursor.getString(cursor.getColumnIndex(PHONENO));
                Student student = new Student(id, name, rollNumber, studentClass, father, mother, mobile);
                students.add(student);
                cursor.moveToNext();
            }
        }
        cursor.close();

        return students;
    }
}


