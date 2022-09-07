package com.example.lotto.Model;

import java.util.ArrayList;

public class Dezenas {
    public String dezena;
    public int quantidade;
    public ArrayList<Integer> conquest;
    public boolean lastConquest;
    public String percentage;
    public Integer range;
    public Boolean isPrime;
    public Boolean isPair;

    public String historicPosition;
    public String primePosition;
    public String pairPosition;
    public String oddPostion;

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
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

    public Boolean getIsPrime() {
        return isPrime;
    }

    public void setIsPrime(Boolean isPrime) {
        this.isPrime = isPrime;
    }

    public Boolean getIsPair() {
        return isPair;
    }

    public void setIsPair(Boolean isPair) {
        this.isPair = isPair;
    }

    public String getHistoricPosition() {
        return historicPosition;
    }

    public void setHistoricPosition(String historicPosition) {
        this.historicPosition = historicPosition;
    }

    public String getPrimePosition() {
        return primePosition;
    }

    public void setPrimePosition(String primePosition) {
        this.primePosition = primePosition;
    }

    public String getPairPosition() {
        return pairPosition;
    }

    public void setPairPosition(String pairPosition) {
        this.pairPosition = pairPosition;
    }

    public String getOddPostion() {
        return oddPostion;
    }

    public void setOddPostion(String oddPostion) {
        this.oddPostion = oddPostion;
    }
}
