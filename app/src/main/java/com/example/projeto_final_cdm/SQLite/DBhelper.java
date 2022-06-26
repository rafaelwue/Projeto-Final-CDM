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

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TimeZone;

public class DBhelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DB_NAME = "App_Telemetria.db";
    private static final Integer DB_VERSION = 4;

    public DBhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String stm = "CREATE TABLE IF NOT EXISTS usuarios (id integer primary key AUTOINCREMENT, usuario text, email text, senha text, tipo text);";
        sqLiteDatabase.execSQL(stm);
        String stm2 = "CREATE TABLE IF NOT EXISTS usuariosPosicao(id integer primary key AUTOINCREMENT, latitude long, longitude long, dataposicao text, enviado boolean);";
        sqLiteDatabase.execSQL(stm2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS usuarios");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS usuariosPosicao");
        onCreate(sqLiteDatabase);
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

    public boolean checkUsuarios(String value){
        String query = "SELECT * FROM " + "usuarios" + " WHERE " + "usuario" + " = ?";
        String[] whereArgs = {value};

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, whereArgs);

        int count = cursor.getCount();
            cursor.close();
        return count >= 1;
    }

    public void gravaPosicao(Location location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        Date date = new Date(location.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");

        values.put("latitude", location.getLatitude());
        values.put("longitude", location.getLongitude());
        values.put("dataposicao", sdf.format(date));
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
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            Double latitude = cursor.getDouble(cursor.getColumnIndexOrThrow("latitude"));
            Double longitude = cursor.getDouble(cursor.getColumnIndexOrThrow("longitude"));
            String dataposicao = cursor.getString(cursor.getColumnIndexOrThrow("dataposicao"));
            Boolean enviado = cursor.getInt(cursor.getColumnIndexOrThrow("enviado")) > 0;
            localizacaoList.add(new LocalizacaoModel(id, latitude, longitude, dataposicao, enviado));
        }
        cursor.close();
        return localizacaoList;
    }
}


