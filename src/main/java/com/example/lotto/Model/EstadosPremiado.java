package com.example.lotto.Model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstadosPremiado {
    @JsonProperty("nome")
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    String nome;

    @JsonProperty("uf")
    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    String uf;

    @JsonProperty("vencedores")
    public String getVencedores() {
        return this.vencedores;
    }

    public void setVencedores(String vencedores) {
        this.vencedores = vencedores;
    }

    String vencedores;

    @JsonProperty("latitude")
    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    String latitude;

    @JsonProperty("longitude")
    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    String longitude;

    @JsonProperty("cidades")
    public ArrayList<Cidade> getCidades() {
        return this.cidades;
    }

    public void setCidades(ArrayList<Cidade> cidades) {
        this.cidades = cidades;
    }

    ArrayList<Cidade> cidades;
}
