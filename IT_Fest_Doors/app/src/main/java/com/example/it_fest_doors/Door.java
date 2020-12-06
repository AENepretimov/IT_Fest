package com.example.it_fest_doors;

import android.widget.ImageView;

import java.io.Serializable;

public class Door implements Serializable {

    private boolean isCar;

    public boolean isCar() {
        return isCar;
    }

    public void setCar(boolean car) {
        isCar = car;
    }

    public void open(ImageView iv){
        iv.setImageResource( isCar ? R.drawable.ic_black_car : R.drawable.ic_goat );
    }

}
