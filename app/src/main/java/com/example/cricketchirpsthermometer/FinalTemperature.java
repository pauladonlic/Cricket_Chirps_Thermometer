package com.example.cricketchirpsthermometer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinalTemperature extends AppCompatActivity {

    private TextView tvFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_temperature);

        tvFinal = findViewById(R.id.tvFinal);

        String temp = getIntent().getStringExtra("temp");
        tvFinal.setText(temp);
    }
}