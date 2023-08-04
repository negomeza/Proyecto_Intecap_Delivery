package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class WelcomeActivity extends AppCompatActivity {
    private Button buttonOrderFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        buttonOrderFood = findViewById(R.id.buttonOrderFood);

        buttonOrderFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad de registro
                Intent intent2 = new Intent(WelcomeActivity.this, RestaurantListActivity.class);
                startActivity(intent2);
            }
        });

    }

}
