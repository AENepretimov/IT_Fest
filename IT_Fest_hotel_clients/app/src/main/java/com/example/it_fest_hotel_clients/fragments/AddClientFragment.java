package com.example.it_fest_hotel_clients.fragments;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.it_fest_hotel_clients.MainActivity;
import com.example.it_fest_hotel_clients.R;
import com.example.it_fest_hotel_clients.ValidateEditTextDate;
import com.example.it_fest_hotel_clients.db.ClientDbHelper;
import com.example.it_fest_hotel_clients.model.Client;

import java.time.LocalDate;

public class AddClientFragment extends Fragment {

    EditText etLastName;
    EditText etFirstName;
    EditText etArrivalDate;
    EditText etAmountOfDays;

    @Override
    public void onResume() {
        super.onResume();
        if (etLastName != null &&
                etFirstName != null &&
                etArrivalDate != null &&
                etAmountOfDays != null
        ) {
            etLastName.setText("");
            etFirstName.setText("");
            etArrivalDate.setText("");
            etAmountOfDays.setText("");
        }
    }

    private boolean checkEmpty() {
        boolean problem = false;
        if (TextUtils.isEmpty(etLastName.getText().toString())){
            etLastName.setError("Обязательное поле");
            problem = true;
        }
        if (TextUtils.isEmpty(etFirstName.getText().toString())){
            etFirstName.setError("Обязательное поле");
            problem = true;
        }
        if (TextUtils.isEmpty(etArrivalDate.getText().toString())){
            etArrivalDate.setError("Обязательное поле");
            problem = true;
        }
        if (TextUtils.isEmpty(etAmountOfDays.getText().toString())) {
            etAmountOfDays.setError("Обязательное поле");
            problem = true;
        }
        return problem;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_client, container, false);

        etLastName = view.findViewById(R.id.et_last_name);
        etFirstName = view.findViewById(R.id.et_first_name);
        etArrivalDate = view.findViewById(R.id.et_arrival_date);
        etAmountOfDays = view.findViewById(R.id.et_amount_of_days);

        AppCompatButton btn_add = (AppCompatButton) view.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkEmpty() & ValidateEditTextDate.validateLocalDateEditText(etArrivalDate)) {
                    ClientDbHelper dbHelper = new ClientDbHelper(getContext());
                    Client testClient = new Client(
                            0,
                            etLastName.getText().toString(),
                            etFirstName.getText().toString(),
                            LocalDate.parse(etArrivalDate.getText().toString()),
                            Integer.parseInt(etAmountOfDays.getText().toString())
                    );
                    dbHelper.addClient(testClient);

                    getActivity().getSupportFragmentManager().beginTransaction().remove(AddClientFragment.this).commit();

                    dbHelper.close();
                }
            }
        });

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        ((MainActivity) getActivity()).update();
    }
}