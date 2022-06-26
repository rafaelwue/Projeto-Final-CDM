package com.example.projeto_final_cdm.Aplicativo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.projeto_final_cdm.Aplicativo.Adapters.HistoricoPosAdapter;
import com.example.projeto_final_cdm.R;
import com.example.projeto_final_cdm.SQLite.DBhelper;

public class HistoricoPosActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HistoricoPosAdapter historicoPosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historicopos);
        configurarRecycler();
    }

    private void configurarRecycler(){
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        DBhelper dBhelper = new DBhelper(this);
        historicoPosAdapter = new HistoricoPosAdapter(dBhelper.selectPosicoes());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}