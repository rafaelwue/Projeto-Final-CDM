package com.example.projeto_final_cdm.Aplicativo.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projeto_final_cdm.R;

public class UsuariosCadastradosViewHolder extends RecyclerView.ViewHolder {
    public TextView id_view;
    public TextView usuario_view;
    public TextView email_view;
    public TextView tipo_view;

    public UsuariosCadastradosViewHolder(View view){
        super(view);
        id_view = (TextView) view.findViewById(R.id.id_view);
        usuario_view = (TextView) view.findViewById(R.id.usuario_view);
        email_view = (TextView) view.findViewById(R.id.email_view);
        tipo_view = (TextView) view.findViewById(R.id.tipo_view);
    }
}
