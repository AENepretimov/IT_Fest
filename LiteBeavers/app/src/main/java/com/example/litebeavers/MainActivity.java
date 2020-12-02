package com.example.litebeavers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView ivBvr1, ivBvr2, ivBvr3;
    private boolean isBeaver1, isBeaver2, isBeaver3;

    private Button btnStart;
    private TextView tvScore;
    private Integer mScore = 0;

    private MyTimer myTimer;
    private final Long mInterval = 1000 * 1L, mStartTime = 1000 * 30L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivBvr1 = (ImageView) findViewById(R.id.iv_bvr1);
        ivBvr2 = (ImageView) findViewById(R.id.iv_bvr2);
        ivBvr3 = (ImageView) findViewById(R.id.iv_bvr3);

        tvScore = (TextView) findViewById(R.id.tv_score);

        ivBvr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBeaver1){
                    mScore++;
                    tvScore.setText( mScore.toString() );
                }

            }
        });

        ivBvr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBeaver2){
                    mScore++;
                    tvScore.setText( mScore.toString() );
                }

            }
        });

        ivBvr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isBeaver3){
                    mScore++;
                    tvScore.setText( mScore.toString() );
                }

            }
        });

        btnStart = (Button) findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnStart.setClickable(false);

                mScore = 0;
                tvScore.setText( mScore.toString() );

                myTimer = new MyTimer(mStartTime, mInterval);
                myTimer.start();
            }
        });

    }

    private boolean setRandBeaver(ImageView iv){

        if (Math.random() < 0.3){
            iv.setImageResource(R.drawable.ic_beaver);
            return true;
        }else {
            iv.setImageResource(R.drawable.ic_hole);
            return false;
        }

    }

    private class MyTimer extends CountDownTimer{

        public MyTimer(long millisInFuture, long countDownInterval) {

            super(millisInFuture, countDownInterval);

        }

        @Override
        public void onTick(long l) {

            isBeaver1 = setRandBeaver(ivBvr1);
            isBeaver2 = setRandBeaver(ivBvr2);
            isBeaver3 = setRandBeaver(ivBvr3);

            btnStart.setText( String.valueOf(l / 1000) );

        }

        @Override
        public void onFinish() {

            ivBvr1.setImageResource(R.drawable.ic_hole);
            ivBvr2.setImageResource(R.drawable.ic_hole);
            ivBvr3.setImageResource(R.drawable.ic_hole);

            isBeaver1 = false;
            isBeaver2 = false;
            isBeaver3 = false;

            btnStart.setText("Try again?!");
            btnStart.setClickable(true);

        }
    }


}