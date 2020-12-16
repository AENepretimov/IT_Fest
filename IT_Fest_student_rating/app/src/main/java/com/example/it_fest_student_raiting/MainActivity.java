package com.example.it_fest_student_raiting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.it_fest_student_raiting.db.StudentDbHelper;
import com.example.it_fest_student_raiting.db.StudentReaderContract;
import com.example.it_fest_student_raiting.fragments.AddStudentFragment;
import com.example.it_fest_student_raiting.fragments.ChangeStudentFragment;
import com.example.it_fest_student_raiting.model.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String MSG_NAME = "msg";
    AddStudentFragment addStudentFragment;
    ChangeStudentFragment changeStudentFragment;
    FragmentTransaction transaction;
    FrameLayout frameLayout;
    RecyclerView rv_students;

    List<Student> students;

    StudentDbHelper dbHelper;
    StudentAdapter studentAdapter;

    ItemTouchHelper.SimpleCallback simpleItemTouchCallback;

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void update(){
        students.clear();
        students.addAll( dbHelper.getStudents() );
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                return t1.getScore() - student.getScore();
            }
        });
        studentAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new StudentDbHelper(this);
        students = dbHelper.getStudents();
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                return t1.getScore() - student.getScore();
            }
        });

        addStudentFragment = new AddStudentFragment();
        changeStudentFragment = new ChangeStudentFragment();

        rv_students = findViewById(R.id.rv_students);
        studentAdapter = new StudentAdapter(this, students);
        rv_students.setAdapter(studentAdapter);


        frameLayout = findViewById(R.id.fl_main);


        AppCompatButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.fl_main, addStudentFragment);
                transaction.commit();

            }
        });

        simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN | ItemTouchHelper.UP) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                Toast.makeText(MainActivity.this, "on Move", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                Toast.makeText(MainActivity.this, "on Swiped ", Toast.LENGTH_SHORT).show();
                //Remove swiped item from list and notify the RecyclerView
                int position = viewHolder.getAdapterPosition();

                dbHelper.deleteStudent(students.get(position));
                students.remove(position);
                studentAdapter.notifyDataSetChanged();

            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(rv_students);


    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }
}