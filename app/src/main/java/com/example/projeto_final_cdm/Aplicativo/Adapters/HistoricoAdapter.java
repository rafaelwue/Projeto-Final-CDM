package com.example.projeto_final_cdm.Aplicativo.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projeto_final_cdm.Aplicativo.Repository.LocalizacaoRepository;
import com.example.projeto_final_cdm.Aplicativo.ViewHolders.HistoricoViewHolder;
import com.example.projeto_final_cdm.R;
import com.example.projeto_final_cdm.SQLite.LocalizacaoModel;

import java.util.List;

public class HistoricoAdapter extends RecyclerView.Adapter<HistoricoViewHolder> {
    private final List<LocalizacaoModel> localizacaoModelList;

    public HistoricoAdapter(List<LocalizacaoModel> localizacaoModelList){
        this.localizacaoModelList = localizacaoModelList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_historicopos, parent, false);

        return new RecyclerView.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((TextView)holder.itemView.findViewById(R.id.rvUsers)).setText(
                LocalizacaoRepository.getInstance().getPosicoes().getValue().get(position).toString());
    }

    @Override
    public int getItemCount() {
        return LocalizacaoRepository.getInstance().getPosicoes().getValue().size();
    }
    public void refresh() {
        this.notifyDataSetChanged();
    }
}
