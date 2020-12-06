package com.example.it_fest_doors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Choice2Activity extends AppCompatActivity {

    private ImageView ivDoor20, ivDoor21;
    private Button btnNext;
    private boolean isLose;

    private ArrayList<Door> doors;

    private Integer doorNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice2);

        Intent i = getIntent();
        if ( i.hasExtra( Choice1Activity.MSG_NAME ) ){
            doors = (ArrayList<Door>)i.getSerializableExtra(Choice1Activity.MSG_NAME);
        }

        ivDoor20 = (ImageView) findViewById(R.id.iv_door20);
        ivDoor21 = (ImageView) findViewById(R.id.iv_door21);

        btnNext = (Button) findViewById(R.id.btn_go_to_final);
        btnNext.setEnabled( false );

        ivDoor20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doors.get(1).open(ivDoor21);

                if (doors.get(1).isCar()) {
                    isLose = true;
                    btnNext.setText( R.string.try_again );
                }else {
                    isLose = false;
                }

                btnNext.setEnabled(true);
            }
        });

        ivDoor21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doors.get(0).open(ivDoor20);

                if (doors.get(0).isCar()) {
                    isLose = true;
                    btnNext.setText( R.string.try_again );
                }else {
                    isLose = false;
                }

                btnNext.setEnabled(true);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i;
                if (isLose){
                    i = new Intent(Choice2Activity.this, MainActivity.class);
                    startActivity(i);
                }else {
                    i = new Intent(Choice2Activity.this, WinActivity.class);
                    startActivity(i);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, R.string.back_button, Toast.LENGTH_SHORT).show();
    }

}