

















 package com.example.it_fest_hotel_clients.db;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.it_fest_hotel_clients.model.Client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Clients.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ClientReaderContract.ClientEntry.TABLE_NAME + " (" +
                    ClientReaderContract.ClientEntry.COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    ClientReaderContract.ClientEntry.COLUMN_AMOUNT_OF_DAYS + " INTEGER, " +
                    ClientReaderContract.ClientEntry.COLUMN_STATUS + " INTEGER, " +
                    ClientReaderContract.ClientEntry.COLUMN_FIRST_NAME + " TEXT, " +
                    ClientReaderContract.ClientEntry.COLUMN_LAST_NAME + " TEXT, " +
                    ClientReaderContract.ClientEntry.COLUMN_ARRIVAL_DATE + " TEXT, " +
                    ClientReaderContract.ClientEntry.COLUMN_CHECK_OUT_DATE + " TEXT)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ClientReaderContract.ClientEntry.TABLE_NAME;


    public ClientDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL( SQL_CREATE_ENTRIES );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL( SQL_DELETE_ENTRIES );
        onCreate( sqLiteDatabase );
    }

    public int changeClient(Client client){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(ClientReaderContract.ClientEntry.COLUMN_FIRST_NAME, client.getFirstName());
        cv.put(ClientReaderContract.ClientEntry.COLUMN_LAST_NAME, client.getLastName());
        cv.put(ClientReaderContract.ClientEntry.COLUMN_ARRIVAL_DATE, client.getArrivalDate().toString());
        cv.put(ClientReaderContract.ClientEntry.COLUMN_AMOUNT_OF_DAYS, client.getAmountOfDays());
        cv.put(ClientReaderContract.ClientEntry.COLUMN_CHECK_OUT_DATE, client.getCheckOutDate().toString());
        cv.put(ClientReaderContract.ClientEntry.COLUMN_STATUS, client.getStatus().ordinal());


        return db.update(ClientReaderContract.ClientEntry.TABLE_NAME,
                cv,
                ClientReaderContract.ClientEntry.COLUMN_ID + " = ?",
                new String[]{ String.valueOf(client.getId()) });
    }

    public int deleteClient(Client client){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(ClientReaderContract.ClientEntry.TABLE_NAME,
                ClientReaderContract.ClientEntry.COLUMN_ID + " = " + client.getId(),
                null);
    }

    public long addClient(Client client){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put(ClientReaderContract.ClientEntry.COLUMN_FIRST_NAME, client.getFirstName());
        cv.put(ClientReaderContract.ClientEntry.COLUMN_LAST_NAME, client.getLastName());
        cv.put(ClientReaderContract.ClientEntry.COLUMN_STATUS, client.getStatus().ordinal());
        cv.put(ClientReaderContract.ClientEntry.COLUMN_ARRIVAL_DATE, client.getArrivalDate().toString());
        cv.put(ClientReaderContract.ClientEntry.COLUMN_AMOUNT_OF_DAYS, client.getAmountOfDays());
        cv.put(ClientReaderContract.ClientEntry.COLUMN_CHECK_OUT_DATE, client.getCheckOutDate().toString());

        return db.insert(ClientReaderContract.ClientEntry.TABLE_NAME, null, cv);
    }

    public List<Client> getAllClients(){
        return getClients(true);
    }

    public List<Client> getOnlyResidesClients(){
        return getClients(false);
    }

    public List<Client> getClients(boolean showAll){

        List<Client> clients = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(ClientReaderContract.ClientEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {

            int idNumber = cursor.getColumnIndex(ClientReaderContract.ClientEntry.COLUMN_ID);
            int status = cursor.getColumnIndex(ClientReaderContract.ClientEntry.COLUMN_STATUS);
            int amountOfDays = cursor.getColumnIndex(ClientReaderContract.ClientEntry.COLUMN_AMOUNT_OF_DAYS);
            int lastName = cursor.getColumnIndex(ClientReaderContract.ClientEntry.COLUMN_LAST_NAME);
            int firstName = cursor.getColumnIndex(ClientReaderContract.ClientEntry.COLUMN_FIRST_NAME);
            int arrivalDate = cursor.getColumnIndex(ClientReaderContract.ClientEntry.COLUMN_ARRIVAL_DATE);
            int checkOutDate = cursor.getColumnIndex(ClientReaderContract.ClientEntry.COLUMN_CHECK_OUT_DATE);


            do {
                Client.Status statusVal = Client.Status.values()[cursor.getInt(status)];
                if (showAll||statusVal == Client.Status.RESIDES) {
                    Client client = new Client(
                            cursor.getInt(idNumber),
                            cursor.getString(lastName),
                            cursor.getString(firstName),
                            LocalDate.parse(cursor.getString(arrivalDate)),
                            cursor.getInt(amountOfDays),
                            LocalDate.parse(cursor.getString(checkOutDate)),
                            statusVal
                            );
                    clients.add(client);
                }
            } while (cursor.moveToNext());
        } else{

        }
        cursor.close();

        return clients;
    }

}
