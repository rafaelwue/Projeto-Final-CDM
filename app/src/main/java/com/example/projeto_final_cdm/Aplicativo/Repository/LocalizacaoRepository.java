package com.example.projeto_final_cdm.Aplicativo.Repository;

import android.content.Context;
import android.location.Location;

import androidx.lifecycle.MutableLiveData;

import com.example.projeto_final_cdm.Aplicativo.Services.PosicaoServices;

import java.util.ArrayList;
import java.util.List;

public class LocalizacaoRepository {
    private static LocalizacaoRepository instance;
    private MutableLiveData<List<Location>> dados;
    private Context context;

    private LocalizacaoRepository(Context context){
        this.context = context;
        dados = new MutableLiveData<>();
        dados.setValue(new ArrayList<>());
    }

    public static LocalizacaoRepository getInstance(Context context){
        if(instance == null){
            instance = new LocalizacaoRepository(context);
        }
        return instance;
    }

    public static LocalizacaoRepository getInstance(){
        return instance;
    }

    public MutableLiveData<List<Location>> getPosicoes(){
        return dados;
    }

    public void incluir (Location loc, float dist){
        int d = (int) dist;
        PosicaoServices.getInstance(context).gravar(loc);
        dados.getValue().add(loc);
        dados.setValue(dados.getValue());
    }

    public Context getContext(){
        return this.context;
    }
}
