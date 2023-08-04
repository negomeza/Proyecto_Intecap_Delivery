package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class RestaurantListActivity extends AppCompatActivity {
    private Button buttonOrderMac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        buttonOrderMac = findViewById(R.id.buttonOrderMac);

        buttonOrderMac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad de registro
                Intent intent2 = new Intent(RestaurantListActivity.this, MenuActivity.class);
                startActivity(intent2);
            }
        });
    }
}