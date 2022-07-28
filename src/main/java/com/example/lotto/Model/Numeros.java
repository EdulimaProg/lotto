package com.example.lotto.Model;

public class Numeros {
    private String Numero;
    private Boolean isPrimo;
    private Boolean isPair;
    private Boolean isRecentlyAwarded;

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public Boolean getIsPrimo() {
        return isPrimo;
    }

    public void setIsPrimo(Boolean isPrimo) {
        this.isPrimo = isPrimo;
    }

    public Boolean getIsPair() {
        return isPair;
    }

    public void setIsPair(Boolean isPair) {
        this.isPair = isPair;
    }

    public Boolean getIsRecentlyAwarded() {
        return isRecentlyAwarded;
    }

    public void setIsRecentlyAwarded(Boolean isRecentlyAwarded) {
        this.isRecentlyAwarded = isRecentlyAwarded;
    }
}
