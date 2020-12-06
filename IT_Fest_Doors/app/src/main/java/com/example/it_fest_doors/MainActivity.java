package com.example.it_fest_doors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private Button btnStart;

    //private ArrayList<Boolean> isCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*isCar = new ArrayList<>();
        isCar.add( true );
        isCar.add( false );
        isCar.add( false );
        Collections.shuffle(isCar);*/

        btnStart = (Button) findViewById(R.id.btn_start);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer doorNumber = (int) (Math.random() * 3 + 1);

                Intent i = new Intent(MainActivity.this, Choice1Activity.class);
                //i.putExtra(MSG_NAME, doorNumber);
                startActivity( i );

            }
        });

    }

    /*public ArrayList<Boolean> getIsCar(){
        return isCar;
    }*/

}