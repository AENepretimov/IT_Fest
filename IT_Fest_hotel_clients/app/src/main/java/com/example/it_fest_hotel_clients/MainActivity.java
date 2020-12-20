package com.example.it_fest_hotel_clients;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.it_fest_hotel_clients.db.ClientDbHelper;
import com.example.it_fest_hotel_clients.fragments.AddClientFragment;
import com.example.it_fest_hotel_clients.fragments.ChangeClientFragment;
import com.example.it_fest_hotel_clients.model.Client;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String MSG_NAME = "msg";
    AddClientFragment addClientFragment;
    ChangeClientFragment changeClientFragment;
    FragmentTransaction transaction;
    FrameLayout frameLayout;
    RecyclerView rvClients;

    CheckBox cbShowAll;

    List<Client> clients;

    ClientDbHelper dbHelper;
    ClientAdapter clientAdapter;

    ItemTouchHelper.SimpleCallback simpleItemTouchCallback;


    public void update() {
        clients.clear();
        clients.addAll(dbHelper.getClients(cbShowAll.isChecked()));
        Collections.sort(clients, new Comparator<Client>() {
            @Override
            public int compare(Client client1, Client client2) {
                return client1.getCheckOutDate().compareTo(client2.getCheckOutDate());
            }
        });
        clientAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbShowAll = findViewById(R.id.cb_show_all);
        cbShowAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                update();
            }
        });

        dbHelper = new ClientDbHelper(this);
        clients = dbHelper.getClients(cbShowAll.isChecked());
        Collections.sort(clients, new Comparator<Client>() {
            @Override
            public int compare(Client client1, Client client2) {
                return client1.getCheckOutDate().compareTo(client2.getCheckOutDate());
            }
        });

        addClientFragment = new AddClientFragment();
        changeClientFragment = new ChangeClientFragment();

        rvClients = findViewById(R.id.rv_clients);
        clientAdapter = new ClientAdapter(this, clients);
        rvClients.setAdapter(clientAdapter);

        frameLayout = findViewById(R.id.fl_main);

        AppCompatButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.fl_main, addClientFragment);
                transaction.commit();

            }
        });

        simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN | ItemTouchHelper.UP) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                Toast.makeText(MainActivity.this, "on Move", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int position = viewHolder.getAdapterPosition();
                Client client = clients.get(position);
                if (swipeDir == ItemTouchHelper.LEFT) {
                    Toast.makeText(MainActivity.this, "Удалено", Toast.LENGTH_SHORT).show();
                    dbHelper.deleteClient(client);
                    clients.remove(position);
                    clientAdapter.notifyDataSetChanged();

                } else if (swipeDir == ItemTouchHelper.RIGHT && client.getStatus() != Client.Status.EVICTED) {
                    client.setStatus(Client.Status.EVICTED);
                    dbHelper.changeClient(client);
                    clients.remove(position);
                    clientAdapter.notifyDataSetChanged();
                }

            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(rvClients);
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        int size = fragments.size();
        if (size > 0)
            getSupportFragmentManager().beginTransaction().remove(fragments.get(size-1)).commit();
        else
            finish();
    }
}