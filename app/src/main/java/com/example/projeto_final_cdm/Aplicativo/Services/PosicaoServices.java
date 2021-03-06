package com.example.projeto_final_cdm.Aplicativo.Services;

import android.content.Context;
import android.location.Location;

public class PosicaoServices {

        private static PosicaoServices instance;
        private PosicaoDBServices dbLocal;
        private PosicaoDBServices dbRemoto;
        private Context context;

        private PosicaoServices(Context context) {
            dbRemoto = new PosicaoDBServiceFirebase();
            dbLocal = new PosicaoDBServiceSQLite(context);
            this.context = context;

        }
        public static PosicaoServices getInstance(Context context) {
            if (instance == null) {
                instance = new PosicaoServices(context);
            }
            return instance;
        }

        public void gravar(Location localizacao) {
            if (dbRemoto != null) {
                dbRemoto.salvar(localizacao);
            }
            if (dbLocal != null) {
                dbLocal.salvar(localizacao);
            }
        }
}

