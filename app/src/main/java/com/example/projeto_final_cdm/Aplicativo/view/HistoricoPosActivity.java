package com.example.projeto_final_cdm.Aplicativo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.projeto_final_cdm.Aplicativo.Adapters.HistoricoPosAdapter;
import com.example.projeto_final_cdm.R;
import com.example.projeto_final_cdm.SQLite.DBhelper;

public class HistoricoPosActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HistoricoPosAdapter historicoPosAdapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historicopos);
        configurarRecycler();
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(historicoPosAdapter);
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(layoutManager.VERTICAL);
    }

    private void configurarRecycler(){
        DBhelper dBhelper = new DBhelper(this);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        historicoPosAdapter = new HistoricoPosAdapter(dBhelper.selectPosicoes());
    }
}