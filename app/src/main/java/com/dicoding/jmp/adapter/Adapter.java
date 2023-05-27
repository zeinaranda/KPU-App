package com.dicoding.jmp.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dicoding.jmp.R;
import com.dicoding.jmp.model.Data;

import java.util.List;

public class Adapter extends BaseAdapter {
    private final Activity activity;
    private LayoutInflater inflater;
    private final List<Data> items;

    public Adapter(Activity activity, List<Data> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater ==null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView==null)
            convertView = inflater.inflate(R.layout.list_row, null);

        TextView id = convertView.findViewById(R.id.id);
        TextView name = convertView.findViewById(R.id.name);
        TextView hp = convertView.findViewById(R.id.hp);
        TextView gender = convertView.findViewById(R.id.gender);
        TextView tanggal = convertView.findViewById(R.id.tanggal);
        TextView address = convertView.findViewById(R.id.lokasi);

        Data data = items.get(position);
        id.setText(data.getId());
        name.setText(data.getName());
        hp.setText(data.getHp());
        gender.setText(data.getGender());
        tanggal.setText(data.getTanggal());
        address.setText(data.getAddress());

        return convertView;
    }
}

