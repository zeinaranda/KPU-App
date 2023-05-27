package com.dicoding.jmp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dicoding.jmp.helper.DbHelper;

public class AddActivity extends AppCompatActivity {
    EditText txt_id, txt_name, txt_hp, txt_gender, txt_tanggal, txt_address;
    Button btn_submit, btn_cancel;
    DbHelper SQLite = new DbHelper(this);
    String id, name, hp, gender, tanggal, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txt_id = findViewById(R.id.et_id);
        txt_name = findViewById(R.id.et_nama);
        txt_hp = findViewById(R.id.et_hp);
        txt_gender = findViewById(R.id.et_jeniskelamin);
        txt_tanggal = findViewById(R.id.et_tanggal);
        txt_address = findViewById(R.id.et_alamat);

        btn_submit = findViewById(R.id.btn_submit);

        id = getIntent().getStringExtra(DaftarActivity.TAG_ID);
        name = getIntent().getStringExtra(DaftarActivity.TAG_NAME);
        hp = getIntent().getStringExtra(DaftarActivity.TAG_HP);
        gender = getIntent().getStringExtra(DaftarActivity.TAG_GENDER);
        tanggal = getIntent().getStringExtra(DaftarActivity.TAG_TANGGAL);
        address = getIntent().getStringExtra(DaftarActivity.TAG_ADDRESS);

        if (id == null || id == "") {
            setTitle("Add Data");
        } else {
            setTitle("Edit Data");
            txt_id.setText(id);
            txt_name.setText(name);
            txt_hp.setText(hp);
            txt_gender.setText(gender);
            txt_tanggal.setText(tanggal);
            txt_address.setText(address);
        }

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    txt_id.getText().toString().equals("");
                        save();

                } catch (Exception e) {
                    Log.e("Submit", e.toString());
                }
            }
        });

    }

    public void blank() {
        //mengosongkan form
        txt_name.requestFocus();
        txt_id.setText("");
        txt_name.setText("");
        txt_address.setText("");
        txt_gender.setText("");
        txt_tanggal.setText("");
        txt_hp.setText("");
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                blank();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void save(){
        if (txt_name.getText().toString().isEmpty() ||
                txt_hp.getText().toString().isEmpty() ||
                txt_gender.getText().toString().isEmpty() ||
                txt_tanggal.getText().toString().isEmpty() ||
                txt_address.getText().toString().isEmpty()) {
            Toast.makeText(this, "name dan address tidak boleh kosong",
                    Toast.LENGTH_SHORT).show();
        }
        else{
            SQLite.insert(txt_name.getText().toString().trim(), txt_hp.getText().toString().trim(),
                    txt_gender.getText().toString().trim(), txt_tanggal.getText().toString().trim(),
                    txt_address.getText().toString().trim());
            blank();
            finish();
        }
    }


    public void toMaps(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}