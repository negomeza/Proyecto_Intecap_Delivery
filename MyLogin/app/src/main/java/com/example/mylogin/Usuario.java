package com.example.mylogin;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "usuarios")

public class Usuario {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nombreUsuario;
    private String contraseña;

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    // Getter y Setter para el ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y Setter para el nombre de usuario
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    // Getter y Setter para la contraseña
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}

