package com.example.cricketchirpsthermometer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CalculateTemperature extends AppCompatActivity {

    private EditText etNumbOfChirps;
    private Button btnCelsius;
    private Button btnFahrenheit;
    private final int CALCULATE = 1;

    private DecimalFormat df;
    private Double calculatedTemperature;
    private Integer numberOfChirps;
    private String strSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_temperature);

        etNumbOfChirps = findViewById(R.id.etNumbOfChirps);
        btnCelsius = findViewById(R.id.btnCelsius);
        btnFahrenheit = findViewById(R.id.btnFahrenheit);
        df = new DecimalFormat("##0.0");

        btnCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etNumbOfChirps.getText().toString();

                if (input.isEmpty()) {
                    Toast.makeText(CalculateTemperature.this, "Please enter the number of chirps!", Toast.LENGTH_SHORT).show();
                } else {
                    numberOfChirps = Integer.parseInt(input.trim());
                    calculatedTemperature = numberOfChirps / 3.0 + 4;
                    strSend = df.format(calculatedTemperature) + getString(R.string.degreesCelsius);
                    Intent intent = new Intent(CalculateTemperature.this, com.example.cricketchirpsthermometer.FinalTemperature.class);
                    intent.putExtra("temp", strSend);
                    startActivityForResult(intent, CALCULATE);
                }
            }
        });

        btnFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etNumbOfChirps.getText().toString();

                if (input.isEmpty()) {
                    Toast.makeText(CalculateTemperature.this, "Please enter the number of chirps!", Toast.LENGTH_SHORT).show();
                } else {
                    numberOfChirps = Integer.parseInt(input.trim());
                    calculatedTemperature = numberOfChirps + 40.0;
                    strSend = df.format(calculatedTemperature) + getString(R.string.degreesFahrenheit);
                    Intent intent = new Intent(CalculateTemperature.this, com.example.cricketchirpsthermometer.FinalTemperature.class);
                    intent.putExtra("temp", strSend);
                    startActivityForResult(intent, CALCULATE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CALCULATE) {
            if (resultCode == RESULT_CANCELED) {
                etNumbOfChirps.getText().clear();
            }
        }
    }
}