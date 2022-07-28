package com.example.lotto.Model;

public class Dezenas {
    public String dezena;
    public int quantidade;
    public boolean lastConquest;
    public String percentage;

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public boolean getIsLastConquest() {
        return lastConquest;
    }

    public void setLastConquest(boolean lastConquest) {
        this.lastConquest = lastConquest;
    }

    public void setDezena(String dezena) {
        this.dezena = dezena;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDezena() {
        return dezena;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
