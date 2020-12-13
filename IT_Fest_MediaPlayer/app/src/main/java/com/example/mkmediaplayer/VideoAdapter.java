package com.example.mkmediaplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mkmediaplayer.model.Video;

import java.util.List;

public class VideoAdapter extends ArrayAdapter<Video> {

    public VideoAdapter(@NonNull Context context, int resource, @NonNull List<Video> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Video video = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView tvNumber = convertView.findViewById(R.id.tv_number),
                tvModule = convertView.findViewById(R.id.tv_module),
                tvName = convertView.findViewById(R.id.tv_name);

        tvNumber.setText(video.getNumber().toString());
        tvModule.setText(video.getNameModule());
        tvName.setText(video.getNameVideo());

        return convertView;
    }
}
