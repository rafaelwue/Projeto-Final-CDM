package com.example.projeto_final_cdm.Aplicativo.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projeto_final_cdm.R;

public class HistoricoViewHolder extends RecyclerView.ViewHolder {
    public TextView latitude_view;
    public TextView longitude_view;
    public TextView time;
    public TextView enviado;

    public HistoricoViewHolder(View view){
        super(view);
        latitude_view = (TextView) view.findViewById(R.id.latitude_view);
        longitude_view = (TextView) view.findViewById(R.id.longitude_view);
        time = (TextView) view.findViewById(R.id.time);
        enviado = (TextView) view.findViewById(R.id.enviado);
    }
}
