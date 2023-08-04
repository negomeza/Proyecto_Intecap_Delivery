package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Button buttonSeleccionar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        buttonSeleccionar1 = findViewById(R.id.buttonSeleccionar1);

        buttonSeleccionar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad de registro
                Intent intent2 = new Intent(MenuActivity.this, ComprarMenu.class);
                startActivity(intent2);
            }
        });

    }
}