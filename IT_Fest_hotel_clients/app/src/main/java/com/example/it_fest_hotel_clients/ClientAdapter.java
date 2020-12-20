package com.example.it_fest_hotel_clients;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.it_fest_hotel_clients.fragments.ChangeClientFragment;
import com.example.it_fest_hotel_clients.model.Client;

import java.time.LocalDate;
import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private List<Client> clients;
    private Context context;


    public ClientAdapter(Context context, List<Client> clients) {
        this.inflater = LayoutInflater.from(context);
        this.clients = clients;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        final TextView tvName,
                tvArrivalDate,
                tvCheckOutDate;
        final LinearLayout ll_item;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ll_item = itemView.findViewById(R.id.ll_item);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvArrivalDate = (TextView) itemView.findViewById(R.id.tv_arrival_date);
            tvCheckOutDate = (TextView) itemView.findViewById(R.id.tv_check_out_date);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Client client = clients.get(position);

        if (client.getStatus() == Client.Status.RESIDES) {
            if (client.getCheckOutDate().compareTo(LocalDate.now()) < 0)
                ((MyViewHolder) holder).ll_item.setBackground(context.getDrawable(R.drawable.ic_bronze_back));
            else
                ((MyViewHolder) holder).ll_item.setBackground(context.getDrawable(R.drawable.ic_normal_back));
        } else {
            ((MyViewHolder) holder).ll_item.setBackground(context.getDrawable(R.drawable.ic_silver_back));
        }

        ((MyViewHolder) holder).tvName.setText(String.format("%s %s", client.getLastName(), client.getFirstName()));
        ((MyViewHolder) holder).tvArrivalDate.setText(String.format("Заезд:\n %s", client.getArrivalDate().toString()));
        ((MyViewHolder) holder).tvCheckOutDate.setText(String.format("Выселение:\n %s", client.getCheckOutDate()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeClientFragment changeClientFragment = new ChangeClientFragment();

                Bundle bundle = new Bundle();
                bundle.putSerializable(MainActivity.MSG_NAME, clients.get(position));
                changeClientFragment.setArguments(bundle);

                ((AppCompatActivity) context).getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fl_main, changeClientFragment)
                        .commit();
            }
        });


    }

    @Override
    public int getItemCount() {
        return clients.size();
    }


}
