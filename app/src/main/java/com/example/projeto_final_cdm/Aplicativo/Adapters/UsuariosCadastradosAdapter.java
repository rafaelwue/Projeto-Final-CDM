package com.example.projeto_final_cdm.Aplicativo.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projeto_final_cdm.Aplicativo.Model.UsuariosModel;
import com.example.projeto_final_cdm.Aplicativo.ViewHolders.UsuariosCadastradosViewHolder;
import com.example.projeto_final_cdm.R;


import java.util.List;

public class UsuariosCadastradosAdapter extends RecyclerView.Adapter<UsuariosCadastradosViewHolder> {
    private final List<UsuariosModel> usuariosModelList;

    public UsuariosCadastradosAdapter(List<UsuariosModel> usuariosModelList) {
        this.usuariosModelList = usuariosModelList;
    }

    @NonNull
    @Override
    public UsuariosCadastradosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UsuariosCadastradosViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_usuarios_cad, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UsuariosCadastradosViewHolder holder, int position) {
        holder.id_view.setText(usuariosModelList.get(position).getId().toString());
        holder.usuario_view.setText(usuariosModelList.get(position).getUsuario());
        holder.email_view.setText(usuariosModelList.get(position).getEmail());
        holder.tipo_view.setText(usuariosModelList.get(position).getTipo());
    }

    @Override
    public int getItemCount() {
        return usuariosModelList.size();
    }
}
