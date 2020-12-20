package com.example.it_fest_hotel_clients;

import android.widget.EditText;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ValidateEditTextDate {

    private ValidateEditTextDate() {
    }

    public static boolean validateLocalDateEditText(EditText et){
        String date = et.getText().toString();
        try {
            LocalDate.parse(date);
            return true;
        } catch (DateTimeParseException e){
            et.setError("Формат: yyyy-mm-dd");
            return false;
        }
    }
}
