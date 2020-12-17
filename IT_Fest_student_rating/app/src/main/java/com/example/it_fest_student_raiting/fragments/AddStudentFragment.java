package com.example.it_fest_student_raiting.fragments;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
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
    EditText et_group, et_name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_student, container, false);
        et_name = view.findViewById(R.id.et_name);
        et_group = view.findViewById(R.id.et_group);



        AppCompatButton btn_add = (AppCompatButton) view.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_name = et_name.getText().toString();
                String txt_group = et_group.getText().toString();

                if (TextUtils.isEmpty(txt_name) || TextUtils.isEmpty(txt_group) ){
                    Snackbar.make(view, R.string.empty_data_error, Snackbar.LENGTH_SHORT)
                            .setAction("Atcion", null)
                            .show();
                }else {
                    StudentDbHelper dbHelper = new StudentDbHelper(getContext());

                    Student testStudent = new Student(0, txt_name, txt_group, 0);
                    dbHelper.addStudent(testStudent);

                    getActivity().getSupportFragmentManager().beginTransaction().remove(AddStudentFragment.this).commit();

                    dbHelper.close();
                }
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        et_name.setText("");
        et_group.setText("");
    }

    @Override
    public void onStop() {
        super.onStop();
        ((MainActivity)getActivity()).update();
    }
}