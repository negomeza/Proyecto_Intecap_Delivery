package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;
    private Button buttonRegisterForm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Crear una instancia de la base de datos
        AppDatabase db = AppDatabaseSingleton.obtenerInstancia(this);

        // Crear un usuario de ejemplo
        Usuario usuarioEjemplo = new Usuario();
        usuarioEjemplo.setNombreUsuario("usuario_1");
        usuarioEjemplo.setContraseña("123");


        // Insertar el usuario de ejemplo en la base de datos
        UsuarioDao usuarioDao = db.usuarioDao();
        usuarioDao.insertarUsuario(usuarioEjemplo);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Ingresa el nombre de usuario y la contraseña", Toast.LENGTH_SHORT).show();
                } else {
                    // Obtener una instancia del Singleton de la base de datos
                    AppDatabase db = AppDatabaseSingleton.obtenerInstancia(MainActivity.this);

                    // Obtener el DAO de Usuario
                    UsuarioDao usuarioDao = db.usuarioDao();

                    // Verificar si el usuario existe en la base de datos
                    Usuario usuario = usuarioDao.obtenerUsuarioPorCredenciales(username, password);

                    if (usuario != null) {
                        // Inicio de sesión exitoso
                        String mensajeOriginal = "¡Bienvenido, " + username + "!";
                        int desplazamiento = 3;
                        String mensajeCifrado = Cifrar(mensajeOriginal, desplazamiento);
                        Toast.makeText(MainActivity.this, mensajeCifrado, Toast.LENGTH_LONG).show();

                        // Redirigir al usuario a la pantalla de bienvenida
                        Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                        startActivity(intent);
                    } else {
                        // Credenciales incorrectas
                        Toast.makeText(MainActivity.this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    }
                }

                /*
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Ingresa el nombre de usuario y la contraseña", Toast.LENGTH_SHORT).show();
                } else {
                     if (username.equals("usuario") && password.equals("contraseña123")) {
                        // Inicio de sesión exitoso
                        String mensajeOriginal = "¡Bienvenido, " + username + "!";
                        int desplazamiento = 3;
                        String mensajeCifrado = Cifrar(mensajeOriginal, desplazamiento);
                        Toast.makeText(MainActivity.this, mensajeCifrado, Toast.LENGTH_LONG).show();

                        // Redirigir al usuario a la pantalla de bienvenida
                        Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                        startActivity(intent);
                    } else {
                        // Credenciales incorrectas
                        Toast.makeText(MainActivity.this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    }
                }

                */

            }
        });



        buttonRegisterForm = findViewById(R.id.buttonRegisterForm);

        buttonRegisterForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad de registro
                Intent intent2 = new Intent(MainActivity.this, RegisterActivitys.class);
                startActivity(intent2);
            }
        });


    }

    public static String Cifrar(String mensaje, int desplazamiento)
    {
        StringBuilder mensajeCifrado = new StringBuilder();

        for (int i = 0; i<mensaje.length(); i++){
            char caracter = mensaje.charAt(i);

            //solo cifrar letra del alfabeto
            if(Character.isLetter(caracter)) {
                //validar si es mayuscula o minuscula
                char base = Character.isUpperCase(caracter)?'A': 'a';

                //Realizar desplazamiento
                int posicionCifrada = (caracter-base + desplazamiento)%26;

                //Convertir de nuevo a letra
                char caracterCifrado = (char) (base+posicionCifrada);

                // Agregar el mensaje cifrado
                mensajeCifrado.append(caracterCifrado);
            } else {
                //No cifrar caracteres que no sean letras
                mensajeCifrado.append(caracter);

            }
        }
        return mensajeCifrado.toString();
    }


    public static String Descifrar(String mensajeCifrado, int desplazamiento)
    {
        // para decifrar, utilizar un desplazamiento negtivo
        int desplazamientoNegativo = 26 - desplazamiento;
        return Cifrar(mensajeCifrado, desplazamientoNegativo);
    }

}
