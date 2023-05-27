package com.dicoding.jmp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ListView;

import com.dicoding.jmp.helper.DbHelper;
import com.dicoding.jmp.adapter.Adapter;
import com.dicoding.jmp.model.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DaftarActivity extends AppCompatActivity {
    ListView listView;
    AlertDialog.Builder dialog;
    List<Data> itemList = new ArrayList<>();
    Adapter adapter;
    DbHelper SQLite = new DbHelper(this);

    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_HP = "hp";
    public static final String TAG_GENDER = "gender";
    public static final String TAG_TANGGAL = "tanggal";
    public static final String TAG_ADDRESS = "address";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);


        SQLite = new DbHelper(this);

        listView = findViewById(R.id.list_view);
        adapter = new Adapter(DaftarActivity.this, itemList);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final String idx = itemList.get(position).getId();
                final String namex = itemList.get(position).getName();
                final String hpx = itemList.get(position).getHp();
                final String genderx = itemList.get(position).getGender();
                final String tanggalx = itemList.get(position).getTanggal();
                final String addressx = itemList.get(position).getAddress();

                final CharSequence[] dialogItem = {"Lihat"};
                dialog = new AlertDialog.Builder(DaftarActivity.this);
                dialog.setCancelable(true);
                dialog.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(DaftarActivity.this, DetailActivity.class);
                        intent.putExtra(TAG_ID, idx);
                        intent.putExtra(TAG_NAME, namex);
                        intent.putExtra(TAG_HP, hpx);
                        intent.putExtra(TAG_GENDER, genderx);
                        intent.putExtra(TAG_TANGGAL, tanggalx);
                        intent.putExtra(TAG_ADDRESS, addressx);
                        startActivity(intent);

                    }

                }).show();
                return false;
            }
        });

        getAllData();
    }

        private void getAllData () {
            ArrayList<HashMap<String, String>> row = SQLite.getAllData();
            for (int i = 0; i < row.size(); i++) {
                String id = row.get(i).get(TAG_ID);
                String name = row.get(i).get(TAG_NAME);
                String hp = row.get(i).get(TAG_HP);
                String gender = row.get(i).get(TAG_GENDER);
                String tanggal = row.get(i).get(TAG_TANGGAL);
                String address = row.get(i).get(TAG_ADDRESS);

                Data data = new Data();
                data.setId(id);
                data.setName(name);
                data.setHp(hp);
                data.setGender(gender);
                data.setTanggal(tanggal);
                data.setAddress(address);

                itemList.add(data);
            }
            adapter.notifyDataSetChanged();
        }

        @Override
        protected void onResume () {
            super.onResume();
            itemList.clear();
            getAllData();
        }
    }

