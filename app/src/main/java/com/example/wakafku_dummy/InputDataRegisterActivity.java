package com.example.wakafku_dummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InputDataRegisterActivity extends AppCompatActivity {
    private Button btnInputDataDaftarAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data_register);

        btnInputDataDaftarAction = (Button) findViewById(R.id.InputData_btn_actiondaftar);

        btnInputDataDaftarAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PinActivity.class));
            }
        });
    }
}