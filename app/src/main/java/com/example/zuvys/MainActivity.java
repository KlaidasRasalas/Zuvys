package com.example.zuvys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button,button1,button3,button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIkeltiZuvi();

            }
        });

    button1 = findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openPaieska();

        }
    });
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openClassifierActivity();

            }
        });
        button4 = findViewById(R.id.button9);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNuotrauka();

            }
        });
}

    public void openIkeltiZuvi() {
        Intent intent = new Intent(this, IkeltiZuvi.class);
        startActivity(intent);
    }

    public void openPaieska() {
        Intent intent = new Intent(this, Meniu.class);
        startActivity(intent);
    }

    public void openClassifierActivity() {
        Intent liveIntent = new Intent(this, com.example.zuvys.ClassifierActivity.class);
        startActivity(liveIntent);

    }

    public void openNuotrauka() {
        Intent intent = new Intent(this, Nuotrauka.class);
        startActivity(intent);
    }

}