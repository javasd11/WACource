package com.example.classwork10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.classwork10.model.Student;

import java.util.ArrayList;

/**
 * Created by ReznichenkoV on 06.07.2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context context) {
        super(context, "myDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Student.TABLE_NAME + " ("
                + Student.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Student.COLUMN_FIRSTNAME + "  TEXT NOT NULL,"
                + Student.COLUMN_LASTNAME + " TEXT NOT NULL,"
                + Student.COLUMN_AGE + " INTEGER NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE Students RENAME TO Student_old");

        db.execSQL("CREATE TABLE " + Student.TABLE_NAME + " ("
                + Student.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Student.COLUMN_FIRSTNAME + "  TEXT NOT NULL,"
                + Student.COLUMN_LASTNAME + " TEXT NOT NULL,"
                + Student.COLUMN_AGE + " INTEGER NOT NULL," +
                "Email TEXT NOT NULL)");

        db.execSQL("INSERT INTO Students (_id, FirstName, LastName, Age,Email) " +
                "SELECT _id, FirstName, LastName, Age,'' FROM Student_old");

        db.execSQL("DROP TABLE Students_old");
    }

    public long insert(Student student) {
        long id = 0;
        SQLiteDatabase db = getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(Student.COLUMN_FIRSTNAME, student.FirstName);
            values.put(Student.COLUMN_LASTNAME, student.LastName);
            values.put(Student.COLUMN_AGE, student.Age);

            id = db.insert(Student.TABLE_NAME, null, values);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public ArrayList<Student> geStudents() {
        ArrayList<Student> students = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.query(Student.TABLE_NAME, null, null, null, null, null, null);
            if (cursor.moveToNext()) {
                while (!cursor.isAfterLast()) {
                    Student student = new Student();
                    student.id = cursor.getLong(cursor.getColumnIndex(Student.COLUMN_ID));
                    student.FirstName = cursor.getString(cursor.getColumnIndex(Student.COLUMN_FIRSTNAME));
                    student.LastName = cursor.getString(cursor.getColumnIndex(Student.COLUMN_LASTNAME));
                    student.Age = cursor.getLong(cursor.getColumnIndex(Student.COLUMN_AGE));

                    students.add(student);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return students;
    }

    public Student getStudent(int idParam) {
        Student student = new Student();
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().query(Student.TABLE_NAME,
                    new String[]{Student.COLUMN_ID, Student.COLUMN_FIRSTNAME, Student.COLUMN_LASTNAME, Student.COLUMN_AGE},
                    Student.COLUMN_ID + idParam, null, null, null, null);

            if (cursor.moveToFirst()) {
                student.id = cursor.getLong(cursor.getColumnIndex(Student.COLUMN_ID));
                student.FirstName = cursor.getString(cursor.getColumnIndex(Student.COLUMN_FIRSTNAME));
                student.LastName = cursor.getString(cursor.getColumnIndex(Student.COLUMN_LASTNAME));
                student.Age = cursor.getLong(cursor.getColumnIndex(Student.COLUMN_AGE));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
            }
        }


        return student;
    }


}
