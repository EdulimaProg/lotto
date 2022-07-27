package com.example.lotto.Model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoteriasModel {
    @JsonProperty("loteria")
    public String getLoteria() {
        return this.loteria;
    }

    public void setLoteria(String loteria) {
        this.loteria = loteria;
    }

    String loteria;

    @JsonProperty("nome")
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    String nome;

    @JsonProperty("concurso")
    public int getConcurso() {
        return this.concurso;
    }

    public void setConcurso(int concurso) {
        this.concurso = concurso;
    }

    int concurso;

    @JsonProperty("data")
    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    String data;

    @JsonProperty("local")
    public String getLocal() {
        return this.local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    String local;

    @JsonProperty("dezenas")
    public ArrayList<String> getDezenas() {
        return this.dezenas;
    }

    public void setDezenas(ArrayList<String> dezenas) {
        this.dezenas = dezenas;
    }

    ArrayList<String> dezenas;

    @JsonProperty("premiacoes")
    public ArrayList<Premiacoes> getPremiacoes() {
        return this.premiacoes;
    }

    public void setPremiacoes(ArrayList<Premiacoes> premiacoes) {
        this.premiacoes = premiacoes;
    }

    ArrayList<Premiacoes> premiacoes;

    @JsonProperty("estadosPremiados")
    public ArrayList<EstadosPremiado> getEstadosPremiados() {
        return this.estadosPremiados;
    }

    public void setEstadosPremiados(ArrayList<EstadosPremiado> estadosPremiados) {
        this.estadosPremiados = estadosPremiados;
    }

    ArrayList<EstadosPremiado> estadosPremiados;

    @JsonProperty("acumulou")
    public boolean getAcumulou() {
        return this.acumulou;
    }

    public void setAcumulou(boolean acumulou) {
        this.acumulou = acumulou;
    }

    boolean acumulou;

    @JsonProperty("acumuladaProxConcurso")
    public String getAcumuladaProxConcurso() {
        return this.acumuladaProxConcurso;
    }

    public void setAcumuladaProxConcurso(String acumuladaProxConcurso) {
        this.acumuladaProxConcurso = acumuladaProxConcurso;
    }

    String acumuladaProxConcurso;

    @JsonProperty("dataProxConcurso")
    public String getDataProxConcurso() {
        return this.dataProxConcurso;
    }

    public void setDataProxConcurso(String dataProxConcurso) {
        this.dataProxConcurso = dataProxConcurso;
    }

    String dataProxConcurso;

    @JsonProperty("proxConcurso")
    public int getProxConcurso() {
        return this.proxConcurso;
    }

    public void setProxConcurso(int proxConcurso) {
        this.proxConcurso = proxConcurso;
    }

    int proxConcurso;

    @JsonProperty("timeCoracao")
    public Object getTimeCoracao() {
        return this.timeCoracao;
    }

    public void setTimeCoracao(Object timeCoracao) {
        this.timeCoracao = timeCoracao;
    }

    Object timeCoracao;

    @JsonProperty("mesSorte")
    public Object getMesSorte() {
        return this.mesSorte;
    }

    public void setMesSorte(Object mesSorte) {
        this.mesSorte = mesSorte;
    }

    Object mesSorte;
}

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
