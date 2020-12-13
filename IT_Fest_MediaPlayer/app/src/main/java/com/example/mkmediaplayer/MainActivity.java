package com.example.mkmediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.mkmediaplayer.model.Video;

public class MainActivity extends AppCompatActivity {

    private MyVideo myVideo;
    private SeekBar seekBar;
    private Video video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        video = (Video) (getIntent().getSerializableExtra(StartActivity.MSG_NAME));

        ((TextView) findViewById(R.id.tv_video_name)).setText(video.getNameVideo());

        myVideo = findViewById(R.id.my_video);
        myVideo.setAddress(video.getUrlVideo());

        seekBar = findViewById(R.id.seek_bar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                myVideo.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        myVideo.stop();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}