package com.example.mylogin;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UsuarioDao {

    @Insert
    void insertarUsuario(Usuario usuario);

    @Query("SELECT * FROM usuarios WHERE nombreUsuario = :nombreUsuario AND contraseña = :contraseña")
    Usuario obtenerUsuarioPorCredenciales(String nombreUsuario, String contraseña);
}
