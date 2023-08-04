package com.example.mylogin;

import android.content.Context;
import androidx.room.Room;

public class AppDatabaseSingleton {

    private static AppDatabase instancia;

    public static AppDatabase obtenerInstancia(Context context) {
        if (instancia == null) {
            instancia = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "comida_rapida_db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instancia;
    }
}

