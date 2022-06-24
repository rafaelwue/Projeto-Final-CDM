package com.example.projeto_final_cdm.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBhelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DB_NAME = "App_Telemetria";
    private static final Integer DB_VERSION = 1;

    public DBhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String stm = "create table usuarios (codigo integer primary key, usuario text, email text, senha text, tipo text);";
        sqLiteDatabase.execSQL(stm);
        String stm2 = "create table usuariosPosicao(codigo integer primary key, latitude long, longitude long, dataposicao datetime, enviado boolean);";
        sqLiteDatabase.execSQL(stm2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void cadastrar(String usuario, String email, String senha, String tipo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("usuario", usuario);
        values.put("email", email);
        values.put("senha", senha);
        values.put("tipo", tipo);
        long result = db.insert("usuarios", null, values);

        if (result == -1) {
            Toast.makeText(context, "Não foi possivel gravar os dados.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Dados gravados com successo.", Toast.LENGTH_SHORT).show();
        }
    }

    public void listarUsuarios(String usuario){
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {

        }

    }
}

