package com.example.it_fest_covid_situation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.it_fest_covid_situation.model.Player;
import com.example.it_fest_covid_situation.situations.MorningActivity;

public class RegisterActivity extends AppCompatActivity {

    public static final String MSG_NAME = "player";
    private EditText et_name;
    private CheckBox cb_man, cb_woman;
    private Button btn_start;

    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_name = findViewById(R.id.et_name);
        cb_man = findViewById(R.id.cb_man);
        cb_woman = findViewById(R.id.cb_woman);

        cb_woman.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cb_man.setChecked(!b);
            }
        });

        cb_man.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cb_woman.setChecked(!b);
            }
        });

        btn_start = findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Player player;

                if (cb_man.isChecked()){
                    player = new Player(true, 0, et_name.getText().toString());
                }else {
                    player = new Player(false, 0, et_name.getText().toString());
                }

                Intent i = new Intent(RegisterActivity.this, MorningActivity.class);
                i.putExtra(MSG_NAME, player);
                startActivity(i);
                finish();
            }
        });
    }


}