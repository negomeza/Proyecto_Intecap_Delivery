package com.example.mylogin;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ComprarMenu extends AppCompatActivity {

    private EditText editTextCardNumber;
    private EditText editTextExpirationDate;
    private EditText editTextCVV;
    private EditText editTextDeliveryAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_menu);

        editTextCardNumber = findViewById(R.id.editTextCardNumber);
        editTextExpirationDate = findViewById(R.id.editTextExpirationDate);
        editTextCVV = findViewById(R.id.editTextCVV);
        editTextDeliveryAddress = findViewById(R.id.editTextDeliveryAddress);

        Button buttonPurchase = findViewById(R.id.buttonPurchase);
        buttonPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarCompra();
            }
        });
    }

    private void validarCompra() {
        String cardNumber = editTextCardNumber.getText().toString().trim();
        String expirationDate = editTextExpirationDate.getText().toString().trim();
        String cvv = editTextCVV.getText().toString().trim();
        String deliveryAddress = editTextDeliveryAddress.getText().toString().trim();

        if (TextUtils.isEmpty(cardNumber) || TextUtils.isEmpty(expirationDate)
                || TextUtils.isEmpty(cvv) || TextUtils.isEmpty(deliveryAddress)) {
            Toast.makeText(this, "Por favor, completa toda la información", Toast.LENGTH_SHORT).show();
        } else {
            mostrarCompraExitosa();
        }
    }

    private Button buttonPurchase;

    private void mostrarCompraExitosa() {
        // Aquí puedes mostrar una ventana emergente con una bandera verde que diga "Compra Exitosa"
        // Puedes utilizar un AlertDialog o un Toast personalizado para ello.
        // Por ejemplo, para usar un Toast:
        Toast.makeText(this, "Compra Exitosa", Toast.LENGTH_SHORT).show();


        buttonPurchase = findViewById(R.id.buttonPurchase);

        buttonPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad de registro
                Intent intent2 = new Intent(ComprarMenu.this, MapActivity.class);
                startActivity(intent2);
            }
        });

    }
}