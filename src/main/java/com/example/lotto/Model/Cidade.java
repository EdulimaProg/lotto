package com.example.lotto.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cidade {
    @JsonProperty("cidade")
    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    String cidade;

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
}
