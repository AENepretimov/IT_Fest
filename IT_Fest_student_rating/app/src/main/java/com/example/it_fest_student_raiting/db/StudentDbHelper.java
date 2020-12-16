package com.example.it_fest_student_raiting.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.it_fest_student_raiting.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "StudentRating.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + StudentReaderContract.StudentEntry.TABLE_NAME + " (" +
                    StudentReaderContract.StudentEntry.COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    StudentReaderContract.StudentEntry.COLUMN_NAME + " TEXT, " +
                    StudentReaderContract.StudentEntry.COLUMN_GR + " TEXT, " +
                    StudentReaderContract.StudentEntry.COLUMN_SCORE + " INTEGER)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + StudentReaderContract.StudentEntry.TABLE_NAME;


    public StudentDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL( SQL_CREATE_ENTRIES );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL( SQL_DELETE_ENTRIES );
        onCreate( sqLiteDatabase );
    }

    public int changeStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(StudentReaderContract.StudentEntry.COLUMN_NAME, student.getName());
        cv.put(StudentReaderContract.StudentEntry.COLUMN_GR, student.getGr());
        cv.put(StudentReaderContract.StudentEntry.COLUMN_SCORE, student.getScore());


        return db.update(StudentReaderContract.StudentEntry.TABLE_NAME,
                cv,
                StudentReaderContract.StudentEntry.COLUMN_ID + " = ?",
                new String[]{ String.valueOf(student.getId()) });
    }

    public int deleteStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(StudentReaderContract.StudentEntry.TABLE_NAME,
                StudentReaderContract.StudentEntry.COLUMN_ID + " = " + student.getId(),
                null);
    }

    public long addStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put(StudentReaderContract.StudentEntry.COLUMN_NAME, student.getName());
        cv.put(StudentReaderContract.StudentEntry.COLUMN_GR, student.getGr());
        cv.put(StudentReaderContract.StudentEntry.COLUMN_SCORE, student.getScore());

        return db.insert(StudentReaderContract.StudentEntry.TABLE_NAME, null, cv);
    }

    public List<Student> getStudents(){

        List<Student> students = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(StudentReaderContract.StudentEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {

            int idNumber = cursor.getColumnIndex(StudentReaderContract.StudentEntry.COLUMN_ID);
            int nameNumber = cursor.getColumnIndex(StudentReaderContract.StudentEntry.COLUMN_NAME);
            int grNumber = cursor.getColumnIndex(StudentReaderContract.StudentEntry.COLUMN_GR);
            int scoreNumber = cursor.getColumnIndex(StudentReaderContract.StudentEntry.COLUMN_SCORE);

            do {
                Student student = new Student(
                        cursor.getInt(idNumber),
                        cursor.getString(nameNumber),
                        cursor.getString(grNumber),
                        cursor.getInt(scoreNumber));
                students.add(student);
            } while (cursor.moveToNext());
        } else{

        }
        cursor.close();

        return students;
    }

}
