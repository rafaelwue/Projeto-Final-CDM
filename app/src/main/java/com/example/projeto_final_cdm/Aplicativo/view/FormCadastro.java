package com.example.projeto_final_cdm.Aplicativo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.projeto_final_cdm.R;

public class FormCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);
        getSupportActionBar().hide();
    }
}