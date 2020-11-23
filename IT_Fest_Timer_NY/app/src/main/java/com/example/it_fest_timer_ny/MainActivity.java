package com.example.it_fest_timer_ny;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String tag = "Main";

    private MalibuCountDownTimer countDownTimer;
    private long startTime;
    private final long interval = 1000;

    private TextView text;
    //private FrameLayout frameLayout; 7
    private ImageView iv_santa1, iv_santa2, iv_santa3;
    private ImageView iv_backGround;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_santa1 = (ImageView) findViewById(R.id.iv_santa1);
        iv_santa2 = (ImageView) findViewById(R.id.iv_santa2);
        iv_santa3 = (ImageView) findViewById(R.id.iv_santa3);

        iv_backGround = (ImageView) findViewById(R.id.iv_mainImage);
        iv_backGround.setImageResource(R.drawable.ic_christmas_tree);

        text = (TextView) findViewById(R.id.tv_timer_show);

        //Long timeNow = testTime();
        Long timeNow = Calendar.getInstance().getTimeInMillis();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.getInstance().get(Calendar.YEAR) + 1, 0, 1,
                0, 0, 0);
        Long timeNY = calendar.getTimeInMillis();

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(timeNY);

        startTime = timeNY - timeNow;

        countDownTimer = new MalibuCountDownTimer(startTime, interval);
        countDownTimer.start();
    }

    private long testTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.getInstance().get(Calendar.YEAR),
                11,
                31,
                23,
                59,
                50);
        return calendar.getTimeInMillis();
    }

    // CountDownTimer class
    public class MalibuCountDownTimer extends CountDownTimer {

        private boolean changePosition = true;

        public MalibuCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {

            text.setText("HAPPY NEW YEAR!!!" + "\n" + "MY DEAR FRIENDS!!!");

            iv_backGround.setImageResource(R.drawable.ic_salute);
            iv_santa1.setImageResource(R.drawable.ic_salute);
            iv_santa2.setImageResource(R.drawable.ic_salute);
            iv_santa3.setImageResource(R.drawable.ic_salute);
        }

        @Override
        public void onTick(long millisUntilFinished) {

            if (changePosition) {
                iv_santa1.setScaleX(-1f);
                iv_santa2.setScaleX(-1f);
                iv_santa3.setScaleX(-1f);
            } else {
                iv_santa1.setScaleX(1f);
                iv_santa2.setScaleX(1f);
                iv_santa3.setScaleX(1f);
            }
            changePosition = !changePosition;

            int days = (int) (millisUntilFinished / (1000 * 60 * 60 * 24));
            int seconds = (int) (millisUntilFinished / 1000) % 60;
            int minutes = (int) ((millisUntilFinished / (1000 * 60)) % 60);
            int hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);

            iv_backGround.setScaleY(1 - (days / (float) 366));
            iv_backGround.setScaleX(1 - (days / (float) 366));

            text.setText("Time :" +
                    " " + String.valueOf(days) +
                    " " + String.valueOf(hours) +
                    " " + String.valueOf(minutes) +
                    " " + String.valueOf(seconds));
        }
    }


}