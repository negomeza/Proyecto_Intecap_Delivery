package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivitys extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonRegister;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inicializar vistas
        editTextUsername = findViewById(R.id.editTextUsernameRegister);
        editTextPassword = findViewById(R.id.editTextPasswordRegister);
        buttonRegister = findViewById(R.id.buttonRegisterUser);

        // Obtener una instancia de la base de datos
        db = AppDatabaseSingleton.obtenerInstancia(this);

        // Agregar clic listener al botón de registro
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el nombre de usuario y la contraseña ingresados por el usuario
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Verificar si los campos están vacíos
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegisterActivitys.this, "Ingresa el nombre de usuario y la contraseña", Toast.LENGTH_SHORT).show();
                } else {
                    // Crear un nuevo objeto de Usuario con los datos ingresados
                    Usuario nuevoUsuario = new Usuario();
                    nuevoUsuario.setNombreUsuario(username);
                    nuevoUsuario.setContraseña(password);

                    // Obtener el DAO de Usuario
                    UsuarioDao usuarioDao = db.usuarioDao();

                    // Insertar el nuevo usuario en la base de datos
                    usuarioDao.insertarUsuario(nuevoUsuario);

                    // Mostrar un mensaje de éxito
                    Toast.makeText(RegisterActivitys.this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show();

                    // Cerrar la actividad de registro y volver a MainActivity u otra actividad
                    finish();
                }
            }
        });
    }
}
