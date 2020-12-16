package com.example.it_fest_student_raiting.fragments;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.it_fest_student_raiting.MainActivity;
import com.example.it_fest_student_raiting.R;
import com.example.it_fest_student_raiting.db.StudentDbHelper;
import com.example.it_fest_student_raiting.db.StudentReaderContract;
import com.example.it_fest_student_raiting.model.Student;
import com.google.android.material.snackbar.Snackbar;

public class AddStudentFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_student, container, false);



        AppCompatButton btn_add = (AppCompatButton) view.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentDbHelper dbHelper = new StudentDbHelper( getContext() );

                EditText et_name = getView().findViewById(R.id.et_name);
                EditText et_group = getView().findViewById(R.id.et_group);
                Student testStudent = new Student(0, et_name.getText().toString(), et_group.getText().toString(), 0);
                dbHelper.addStudent(testStudent);

                getActivity().getSupportFragmentManager().beginTransaction().remove(AddStudentFragment.this).commit();

                dbHelper.close();
            }
        });

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        ((MainActivity)getActivity()).update();
    }
}