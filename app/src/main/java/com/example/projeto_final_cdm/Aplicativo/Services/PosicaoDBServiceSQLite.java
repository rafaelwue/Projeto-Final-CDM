package com.example.projeto_final_cdm.Aplicativo.Services;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;

import com.example.projeto_final_cdm.SQLite.DBhelper;

import java.util.List;

public class PosicaoDBServiceSQLite implements PosicaoDBServices{
    DBhelper dbHelper;

    public PosicaoDBServiceSQLite(Context context) {
        dbHelper = new DBhelper(context);
    }
    @Override
    public void salvar(Location loc) {
        SQLiteDatabase writableDatabase = dbHelper.getWritableDatabase();
        // aqui faz a mágica
        //writableDatabase.execSQL();

    }

    @Override
    public List<Localizacao> getAllLocalizacao() {
        return null;
    }

    @Override
    public List<Localizacao> getAllLocalizacaoData(long inicio, long fim) {
        return null;
    }

    @Override
    public List<Localizacao> getAllLocalizacaoNaoEnviadas() {
        return null;
    }
}
