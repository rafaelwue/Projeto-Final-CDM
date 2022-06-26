package com.example.projeto_final_cdm.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Location;
import android.widget.Toast;

import com.example.projeto_final_cdm.Aplicativo.Services.PosicaoDBServiceFirebase;
import com.example.projeto_final_cdm.Aplicativo.Services.PosicaoDBServices;
import com.example.projeto_final_cdm.Aplicativo.Services.PosicaoServices;

import java.util.ArrayList;
import java.util.List;

public class DBhelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DB_NAME = "App_Telemetria.db";
    private static final Integer DB_VERSION = 1;

    public DBhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String stm = "create table usuarios (codigo integer primary key, usuario text, email text, senha text, tipo text);";
        sqLiteDatabase.execSQL(stm);
        String stm2 = "create table usuariosPosicao(codigo integer primary key, latitude long, longitude long, dataposicao long, enviado boolean);";
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

    public void gravaPosicao(Location location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("latitude", location.getLatitude());
        values.put("longitude", location.getLongitude());
        values.put("dataposicao", location.getTime());
        values.put("enviado", true);
        long result = db.insert("usuariosPosicao", null, values);

        PosicaoDBServiceFirebase posicaoDBServiceFirebase = new PosicaoDBServiceFirebase();
        posicaoDBServiceFirebase.salvar(location);

        if (result == -1) {
            Toast.makeText(context, "Não foi possivel gravar os dados.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Dados gravados com successo.", Toast.LENGTH_SHORT).show();
        }
    }
    public List<LocalizacaoModel> selectPosicoes(){
        SQLiteDatabase db = this.getWritableDatabase();
        List<LocalizacaoModel> localizacaoList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM usuariosPosicao", null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            Double latitude = cursor.getDouble(cursor.getColumnIndex("Latitude"));
            Double longitude = cursor.getDouble(cursor.getColumnIndex("Longitude"));
            Long dataposicao = cursor.getLong(cursor.getColumnIndex("Dataposicao"));
            Boolean enviado = cursor.getInt(cursor.getColumnIndex("Enviado")) > 0;
            localizacaoList.add(new LocalizacaoModel(id, latitude, longitude, dataposicao, enviado));
        }
        cursor.close();
        return localizacaoList;
    }
}


