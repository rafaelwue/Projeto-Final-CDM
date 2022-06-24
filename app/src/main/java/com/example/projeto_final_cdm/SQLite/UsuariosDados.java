package com.example.projeto_final_cdm.SQLite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class UsuariosDados {
    DBhelper dbhelper;

    public boolean cadastrar(String usuario, String email, String senha, String tipo) {
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("usuario", usuario);
        values.put("email", email);
        values.put("senha", senha);
        values.put("tipo", tipo);

        long result = db.insert("usuarios", null, values);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
}
