package com.example.projeto_final_cdm.Aplicativo.Model;

public class UsuariosModel {
    private Integer id;
    private String usuario, email, senha, tipo;

    public UsuariosModel(Integer id, String usuario, String email, String senha, String tipo) {
        this.id = id;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}



