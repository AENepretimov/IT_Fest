package com.example.it_fest_beavers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

@SuppressLint("AppCompatCustomView")
public class MyIV extends ImageView {

    private boolean isBeaver;

    public MyIV(Context context) {
        super(context);
    }

    public MyIV(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyIV(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyIV(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    public void setRandBeaver(){

        if (Math.random() < 0.3){
            this.setImageResource(R.drawable.ic_beaver); //beaver
            isBeaver = true;
        }else{
            this.setImageResource(R.drawable.ic_hole); //empty
            isBeaver = false;
        }

    }

    public void setBeaver(){
        this.setImageResource(R.drawable.ic_beaver); //beaver
        isBeaver = true;
    }

    public void setHole(){
        this.setImageResource(R.drawable.ic_hole); //beaver
        isBeaver = false;
    }

    public boolean isBeaver() {
        return isBeaver;
    }

}