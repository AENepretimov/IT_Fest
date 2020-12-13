package com.example.mkmediaplayer;

import android.content.Context;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;

import java.io.IOException;

public class MyVideo extends SurfaceView implements SurfaceHolder.Callback, MediaPlayer.OnPreparedListener {
    private final MediaPlayer mediaPlayer = new MediaPlayer();
    private SurfaceHolder holder;
    private String urlAddress;

    private boolean isStart;


    public MyVideo(Context context, AttributeSet attrs) {
        super(context, attrs);
        initHolder();
    }

    private void initHolder() {
        holder = this.getHolder();
        holder.addCallback(this);
        this.setOnClickListener(clickListener());
    }

    private View.OnClickListener clickListener(){
        return new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart)
                    pause();
                else
                    start();
                isStart = !isStart;
            }
        };
    }

    private void start() {
        mediaPlayer.start();
    }

    private void pause() {
        mediaPlayer.pause();
    }

    public void stop(){
        mediaPlayer.stop();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            setMeasuredDimension(widthMeasureSpec, (int)(widthMeasureSpec*3/4.0));
        else
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        if (!TextUtils.isEmpty(urlAddress)){
            try {
                mediaPlayer.setOnPreparedListener(this);
                mediaPlayer.setDisplay(holder);
                mediaPlayer.setDataSource(urlAddress);
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mediaPlayer.seekTo(1);
    }

    public void setAddress(String urlVideo) {
        this.urlAddress = urlVideo;
    }

    public void seekTo(int progress) {
        mediaPlayer.seekTo((int)(progress/100.0*mediaPlayer.getDuration()));
    }
}
