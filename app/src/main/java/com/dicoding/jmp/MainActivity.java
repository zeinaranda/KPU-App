package com.dicoding.jmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toAdd(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    public void toDaftar(View view) {
        Intent intent = new Intent(this, DaftarActivity.class);
        startActivity(intent);
    }
    public void toInfo(View view) {
        Intent intent = new Intent(this, InformasiActivity.class);
        startActivity(intent);
    }
}