package com.example.wakafku_dummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InputNoPonselActivity extends AppCompatActivity {

    private Button btnActionKirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_no_ponsel);

        btnActionKirim = (Button) findViewById(R.id.input_noponsel_btn_action_lupapin);

        btnActionKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), KodeOtpActivity.class));
            }
        });
    }
}