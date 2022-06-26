package com.example.projeto_final_cdm.Aplicativo.view;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projeto_final_cdm.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToLocalizacao(View view) {
        Intent intent = new Intent(MainActivity.this, LocationActivity.class);
        startActivity(intent);
        finish();
    }

    public void goToCadastroUsuario(View view) {
        Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
        startActivity(intent);
        finish();
    }

    public void goToUsuarios(View view) {
        Intent intent = new Intent(MainActivity.this, HistoricoPosActivity.class);
        startActivity(intent);
        finish();
    }

}



