package com.example.it_fest_doors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Choice1Activity extends AppCompatActivity {

    private ImageView ivDoor10, ivDoor11, ivDoor12;
    private Button btnNext;
    private boolean isLose;
    private Integer doorNumber;

    public static final String MSG_NAME = "doors";

    private ArrayList<Door> doors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice1);

        doorNumber = (int) (Math.random() * 3);

        ivDoor10 = (ImageView) findViewById(R.id.iv_door10);
        ivDoor11 = (ImageView) findViewById(R.id.iv_door11);
        ivDoor12 = (ImageView) findViewById(R.id.iv_door12);

        doors = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            doors.add( new Door() );
        }
        doors.get( doorNumber ).setCar( true );

        btnNext = (Button) findViewById(R.id.btn_go_to_choise2);

        btnNext.setEnabled( false );

        ivDoor10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Math.random() > 0.5){
                    if ( doors.get(1).isCar() ){
                        isLose = true;
                        doors.get(1).open( ivDoor11 );
                        btnNext.setText("Try again?");
                    }else {
                        isLose = false;
                        doors.get(1).open( ivDoor11 );
                    }
                    doors.remove(1);
                }else {
                    if ( doors.get(2).isCar() ){
                        isLose = true;
                        doors.get(2).open(ivDoor12);
                        btnNext.setText("Try again?");
                    }else {
                        isLose = false;
                        doors.get(2).open(ivDoor12);
                    }
                    doors.remove(2);
                }
                btnNext.setEnabled(true);

            }
        });

        ivDoor11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Math.random() > 0.5){
                    if ( doors.get(0).isCar() ){
                        isLose = true;
                        doors.get(0).open( ivDoor10 );
                        btnNext.setText("Try again?");
                    }else {
                        isLose = false;
                        doors.get(0).open( ivDoor10 );
                    }
                    doors.remove(0);
                }else {
                    if ( doors.get(2).isCar() ){
                        isLose = true;
                        doors.get(2).open(ivDoor12);
                        btnNext.setText("Try again?");
                    }else {
                        isLose = false;
                        doors.get(2).open(ivDoor12);
                    }
                    doors.remove(2);
                }
                btnNext.setEnabled(true);

            }
        });

        ivDoor12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Math.random() > 0.5){
                    if ( doors.get(1).isCar() ){
                        isLose = true;
                        doors.get(1).open( ivDoor11 );
                        btnNext.setText("Try again?");
                    }else {
                        isLose = false;
                        doors.get(1).open( ivDoor11 );
                    }
                    doors.remove(1);
                }else {
                    if ( doors.get(0).isCar() ){
                        isLose = true;
                        doors.get(0).open(ivDoor10);
                        btnNext.setText("Try again?");
                    }else {
                        isLose = false;
                        doors.get(0).open(ivDoor10);
                    }
                    doors.remove(0);
                }
                btnNext.setEnabled(true);

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i;
                if (isLose){
                    i = new Intent(Choice1Activity.this, MainActivity.class);
                    startActivity(i);
                }else {
                    i = new Intent(Choice1Activity.this, Choice2Activity.class);
                    i.putExtra( MSG_NAME, doors );
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