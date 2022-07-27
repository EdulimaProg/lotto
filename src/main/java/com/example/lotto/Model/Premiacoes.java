package com.example.lotto.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Premiacoes {
    @JsonProperty("acertos")
    public String getAcertos() {
        return this.acertos;
    }

    public void setAcertos(String acertos) {
        this.acertos = acertos;
    }

    String acertos;

    @JsonProperty("vencedores")
    public int getVencedores() {
        return this.vencedores;
    }

    public void setVencedores(int vencedores) {
        this.vencedores = vencedores;
    }

    int vencedores;

    @JsonProperty("premio")
    public String getPremio() {
        return this.premio;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }

    String premio;
}
