package com.example.it_fest_beavers;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //view
    private MyIV iv00, iv01, iv02;
    private MyIV iv10, iv11, iv12;
    private MyIV iv20, iv21, iv22;
    private MyIV[][] mTable;

    private Button btnStart;
    private TextView tvResult;

    //counter for result
    private Integer mScore;

    //timer
    private MyTimer mTimer;
    private final static Long START_TIME = 1000 * 30L;
    private final static Long INTERVAL = 1000 * 1L;

    private BeaverClickListener beaverClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MyTimer mTimer = new MyTimer(START_TIME, INTERVAL);

        //initialise beavers
        //first row
        iv00 = (MyIV) findViewById(R.id.iv_00);
        iv01 = (MyIV) findViewById(R.id.iv_01);
        iv02 = (MyIV) findViewById(R.id.iv_02);
        //second row
        iv10 = (MyIV) findViewById(R.id.iv_10);
        iv11 = (MyIV) findViewById(R.id.iv_11);
        iv12 = (MyIV) findViewById(R.id.iv_12);
        //third row
        iv20 = (MyIV) findViewById(R.id.iv_20);
        iv21 = (MyIV) findViewById(R.id.iv_21);
        iv22 = (MyIV) findViewById(R.id.iv_22);

        mTable = new MyIV[][]
                {{iv00, iv01, iv02},
                 {iv10, iv11, iv12},
                 {iv20, iv21, iv22}};

        for (int i = 0; i < mTable.length; i++) {
            for (int i1 = 0; i1 < mTable[i].length; i1++) {
                mTable[i][i1].setHole();
            }
        }

        //initialise text for score
        tvResult = (TextView) findViewById(R.id.tv_result);

        //initialise start button
        btnStart = (Button) findViewById(R.id.btn_start);

        beaverClickListener = new BeaverClickListener();

        //to start actions
        btnStart.setOnClickListener(new View.OnClickListener() {

            private boolean isFirst = true;

            @Override
            public void onClick(View view) {

                btnStart.setClickable(false);

                if (isFirst) {
                    for (int i = 0; i < mTable.length; i++) {
                        for (int i1 = 0; i1 < mTable[i].length; i1++) {
                            mTable[i][i1].setOnClickListener(beaverClickListener);
                        }
                    }
                    isFirst = false;
                }else {
                    for (int i = 0; i < mTable.length; i++) {
                        for (int i1 = 0; i1 < mTable[i].length; i1++) {
                            mTable[i][i1].setClickable(true);
                        }
                    }
                }

                mTimer.start();
                mScore = 0;
                tvResult.setText( mScore.toString() );

            }
        });


    }

    private class BeaverClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            if ( ( (MyIV)view ).isBeaver() ){
                mScore++;
                tvResult.setText( mScore.toString() );
            }

        }

    }

    private class MyTimer extends CountDownTimer {

        public MyTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {

            for (int i = 0; i < mTable.length; i++) {
                for (int i1 = 0; i1 < mTable[i].length; i1++) {
                    mTable[i][i1].setRandBeaver();
                }
            }

            btnStart.setText( String.valueOf( l / 1000 ) );

        }

        @Override
        public void onFinish() {

            for (int i = 0; i < mTable.length; i++) {
                for (int i1 = 0; i1 < mTable[i].length; i1++) {
                    mTable[i][i1].setBeaver();
                    mTable[i][i1].setClickable(false);
                }
            }

            tvResult.setText( mScore.toString() );

            btnStart.setText( "TRY AGAIN ?!" );
            btnStart.setClickable(true);

        }
    }

}