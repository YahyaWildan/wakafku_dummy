package com.example.wakafku_dummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class KodeOtpActivity extends AppCompatActivity {

    private Button btnKodeOtpKirimAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kode_otp);

        btnKodeOtpKirimAction = (Button) findViewById(R.id.KodeOtp_kirim);
        btnKodeOtpKirimAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), InputDataRegisterActivity.class));
            }
        });
    }

    public void verifikasiPin(View view) {
        startActivity(new Intent(getApplicationContext(), VerifikasiPinActivity.class));
    }

    public void lupaPin(View view) {
        startActivity(new Intent(getApplicationContext(), LupaPinActivity.class));

    }
}