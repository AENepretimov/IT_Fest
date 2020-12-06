package com.example.it_fest_doors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WinActivity extends AppCompatActivity {

    private Button btnTryAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        btnTryAgain = (Button) findViewById(R.id.btn_try_again);
        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(WinActivity.this, MainActivity.class);
                startActivity(i);

            }
        });

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, R.string.back_button, Toast.LENGTH_SHORT).show();
    }

}