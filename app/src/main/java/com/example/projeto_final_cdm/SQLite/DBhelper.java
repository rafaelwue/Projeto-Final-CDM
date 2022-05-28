package com.example.projeto_final_cdm.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "App_Telemetria";
    private static final Integer DB_VERSION = 1;

    public DBhelper(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
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
}

