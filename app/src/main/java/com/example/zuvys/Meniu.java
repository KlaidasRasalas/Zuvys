package com.example.zuvys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;

public class Meniu extends AppCompatActivity {

    Toolbar toolbar;
    Button button7,button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_meniu);

        toolbar = findViewById(R.id.toolbar);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Kategorija");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPaieska();

            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSuriavandenes();

            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public void openSuriavandenes() {
        Intent intent = new Intent(this, Paieska2.class);
        startActivity(intent);
    }

    public void openPaieska() {
        Intent intent = new Intent(this, Paieska.class);
        startActivity(intent);
    }
}
