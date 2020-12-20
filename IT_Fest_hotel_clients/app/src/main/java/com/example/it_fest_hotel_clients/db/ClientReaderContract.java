package com.example.it_fest_hotel_clients.db;

import android.provider.BaseColumns;

public class ClientReaderContract {

    private ClientReaderContract(){}

    public static class ClientEntry implements BaseColumns{
        public static final String TABLE_NAME = "clients";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_AMOUNT_OF_DAYS = "amount_of_days";
        public static final String COLUMN_LAST_NAME = "last_name";
        public static final String COLUMN_FIRST_NAME = "first_name";
        public static final String COLUMN_ARRIVAL_DATE = "arrival_date";
        public static final String COLUMN_CHECK_OUT_DATE = "check_out_date";
        public static final String COLUMN_STATUS = "status";

    }


}
