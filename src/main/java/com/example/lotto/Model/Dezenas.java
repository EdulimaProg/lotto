package com.example.lotto.Model;

import java.util.ArrayList;

public class Dezenas {
    public String dezena;
    public int quantidade;
    public ArrayList<Integer> conquest;
    public boolean lastConquest;
    public String percentage;
    public String range;
    public String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

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

    public boolean isLastConquest() {
        return lastConquest;
    }

    public ArrayList<Integer> getConquest() {
        return conquest;
    }

    public void setConquest(ArrayList<Integer> conquest) {
        this.conquest = conquest;
    }
}
