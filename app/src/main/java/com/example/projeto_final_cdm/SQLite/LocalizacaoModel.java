package com.example.projeto_final_cdm.SQLite;

public class LocalizacaoModel {
    private Integer id;
    private Double latitude, longitude;
    private String time;
    private Boolean enviado;

    public LocalizacaoModel(Integer id, Double latitude, Double longitude, String time, Boolean enviado) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
        this.enviado = enviado;
    }

    public Integer getId() {
        return id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getEnviado() {
        return enviado;
    }

    public void setEnviado(Boolean enviado) {
        this.enviado = enviado;
    }
}

