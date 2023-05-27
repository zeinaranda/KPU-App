package com.dicoding.jmp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView txt_id, txt_name, txt_hp, txt_gender, txt_tanggal, txt_address;
    String id, name, hp, gender, tanggal, address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txt_id = findViewById(R.id.tv_id);
        txt_name = findViewById(R.id.tv_name);
        txt_hp = findViewById(R.id.tv_phone);
        txt_gender = findViewById(R.id.tv_gender);
        txt_tanggal = findViewById(R.id.tv_tanggal);
        txt_address = findViewById(R.id.tv_lokasi);

        id = getIntent().getStringExtra(DaftarActivity.TAG_ID);
        name = getIntent().getStringExtra(DaftarActivity.TAG_NAME);
        hp = getIntent().getStringExtra(DaftarActivity.TAG_HP);
        gender = getIntent().getStringExtra(DaftarActivity.TAG_GENDER);
        tanggal = getIntent().getStringExtra(DaftarActivity.TAG_TANGGAL);
        address = getIntent().getStringExtra(DaftarActivity.TAG_ADDRESS);


            txt_id.setText(id);
            txt_name.setText(name);
            txt_hp.setText(hp);
            txt_gender.setText(gender);
            txt_tanggal.setText(tanggal);
            txt_address.setText(address);




    }
}