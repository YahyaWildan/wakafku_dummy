package com.example.wakafku_dummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private Button btnActionLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnActionLogin = (Button) findViewById(R.id.login_btn_action);
        btnActionLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), KodeOtpActivity.class));
            }
        });


    }

    public void Daftar(View view) {
        startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
    }
}