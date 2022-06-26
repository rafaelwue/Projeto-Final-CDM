package com.example.projeto_final_cdm.Aplicativo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.projeto_final_cdm.Aplicativo.Adapters.UsuariosCadastradosAdapter;
import com.example.projeto_final_cdm.R;
import com.example.projeto_final_cdm.SQLite.DBhelper;

public class UsuariosCadastradosActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    UsuariosCadastradosAdapter usuariosCadastradosAdapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios_cadastrados);
        getSupportActionBar().hide();

        configurarRecycler();
        progressBar = findViewById(R.id.progressBarUsers);
        progressBar.setVisibility(View.GONE);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(usuariosCadastradosAdapter);
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(layoutManager.VERTICAL);
    }

    private void configurarRecycler(){
        DBhelper dBhelper = new DBhelper(this);
        recyclerView = (RecyclerView)findViewById(R.id.RecyclerViewUsers);
        usuariosCadastradosAdapter = new UsuariosCadastradosAdapter(dBhelper.selectUsuarios());
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(UsuariosCadastradosActivity.this, MainActivity.class));
        return;
    }
}
