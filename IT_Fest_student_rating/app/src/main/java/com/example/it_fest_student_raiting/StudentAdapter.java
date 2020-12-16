package com.example.it_fest_student_raiting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.it_fest_student_raiting.fragments.ChangeStudentFragment;
import com.example.it_fest_student_raiting.model.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private List<Student> students;
    private Context context;



    public StudentAdapter(Context context, List<Student> students) {
        this.inflater = LayoutInflater.from(context);
        this.students = students;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        final TextView tv_name,
                tv_gr,
                tv_score;
        final LinearLayout ll_item;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ll_item = itemView.findViewById(R.id.ll_item);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_gr = (TextView) itemView.findViewById(R.id.tv_gr);
            tv_score = (TextView) itemView.findViewById(R.id.tv_score);
        }
    }







    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Student student = students.get(position);

        if (position == 0){
            ((MyViewHolder)holder).ll_item.setBackground(context.getDrawable(R.drawable.ic_golden_back));
        }
        if (position == 1){
            ((MyViewHolder)holder).ll_item.setBackground(context.getDrawable(R.drawable.ic_silver_back));
        }
        if (position == 2){
            ((MyViewHolder)holder).ll_item.setBackground(context.getDrawable(R.drawable.ic_bronze_back));
        }

        ((MyViewHolder)holder).tv_name.setText(student.getName());
        ((MyViewHolder)holder).tv_gr.setText("Group: " + student.getGr());
        ((MyViewHolder)holder).tv_score.setText( "Score: " + student.getScore().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeStudentFragment changeStudentFragment = new ChangeStudentFragment();

                Bundle bundle = new Bundle();
                bundle.putSerializable(MainActivity.MSG_NAME, students.get(position));
                changeStudentFragment.setArguments(bundle);

                ((AppCompatActivity)context).getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fl_main, changeStudentFragment)
                        .commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return students.size();
    }



}
