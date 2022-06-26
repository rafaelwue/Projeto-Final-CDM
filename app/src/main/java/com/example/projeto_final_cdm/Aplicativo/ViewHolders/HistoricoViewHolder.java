package com.example.projeto_final_cdm.Aplicativo.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projeto_final_cdm.R;

public class HistoricoViewHolder extends RecyclerView.ViewHolder {
    public TextView id_view;
    public TextView latitude_view;
    public TextView longitude_view;
    public TextView time_view;
    public TextView enviado_view;

    public HistoricoViewHolder(View view){
        super(view);
        id_view = (TextView) view.findViewById(R.id.id_view);
        latitude_view = (TextView) view.findViewById(R.id.latitude_view);
        longitude_view = (TextView) view.findViewById(R.id.longitude_view);
        time_view = (TextView) view.findViewById(R.id.time_view);
        enviado_view = (TextView) view.findViewById(R.id.enviado_view);
    }
}
