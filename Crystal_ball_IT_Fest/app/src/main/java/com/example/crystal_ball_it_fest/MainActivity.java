package com.example.crystal_ball_it_fest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ImageView ivCrystal;
    private TextView tvPredict;

    private ArrayList<String> predictList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivCrystal = (ImageView) findViewById(R.id.iv_crystal);
        tvPredict = (TextView) findViewById(R.id.tv_predict);

        ivCrystal.setImageResource(R.drawable.ic_crystall_ball);


        predictList = new ArrayList<>();
        predictList.add("Yes");
        predictList.add("No");
        predictList.add("May be");

        tvPredict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Collections.shuffle(predictList);
                tvPredict.setText( predictList.get( 0 ) );

            }
        });

    }
}