package com.example.wakafku_dummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class VerifikasiPinActivity extends AppCompatActivity {

    private TextView textViewLupaPin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifikasi_pin);

        textViewLupaPin = (TextView) findViewById(R.id.verifikasi_pin_lupa_pin);
        textViewLupaPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), InputNoPonselActivity.class));
            }
        });
    }
}