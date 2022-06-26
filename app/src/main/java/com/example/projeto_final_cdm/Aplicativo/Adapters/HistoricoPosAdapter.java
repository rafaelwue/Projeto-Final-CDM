package com.example.projeto_final_cdm.Aplicativo.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projeto_final_cdm.Aplicativo.ViewHolders.HistoricoViewHolder;
import com.example.projeto_final_cdm.R;
import com.example.projeto_final_cdm.SQLite.LocalizacaoModel;

import java.util.List;

public class HistoricoPosAdapter extends RecyclerView.Adapter<HistoricoViewHolder> {

    private final List<LocalizacaoModel> localizacaoModelList;

    public HistoricoPosAdapter(List<LocalizacaoModel> localizacaoModelList) {
        this.localizacaoModelList = localizacaoModelList;
    }

    @NonNull
    @Override
    public HistoricoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistoricoViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_historico_pos, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HistoricoViewHolder holder, int position) {
        holder.id_view.setText(localizacaoModelList.get(position).getId());
        holder.latitude_view.setText(localizacaoModelList.get(position).getLatitude().intValue());
        holder.longitude_view.setText(localizacaoModelList.get(position).getLongitude().intValue());
        holder.time_view.setText(localizacaoModelList.get(position).getTime().intValue());
        holder.enviado_view.setText(localizacaoModelList.get(position).getEnviado().toString());
    }

    @Override
    public int getItemCount() {
        return localizacaoModelList != null ? localizacaoModelList.size() : 0;
    }
}
