package com.example.lotto.Model;

import java.util.ArrayList;

public class ConquestStatistics {
    Integer conquestNumber;
    Boolean isAcumulated;
    String data;
    ArrayList<String> dezenas;
    String stringDezenas;
    String dezenasScheme;

    public String getStringDezenas() {
        return stringDezenas;
    }

    public void setStringDezenas(String stringDezenas) {
        this.stringDezenas = stringDezenas;
    }

    public Boolean getIsAcumulated() {
        return isAcumulated;
    }

    public void setIsAcumulated(Boolean isAcumulated) {
        this.isAcumulated = isAcumulated;
    }

    public Integer getConquestNumber() {
        return conquestNumber;
    }

    public void setConquestNumber(Integer conquestNumber) {
        this.conquestNumber = conquestNumber;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ArrayList<String> getDezenas() {
        return dezenas;
    }

    public void setDezenas(ArrayList<String> dezenas) {
        this.dezenas = dezenas;
    }

    public String getDezenasScheme() {
        return dezenasScheme;
    }

    public void setDezenasScheme(String dezenasScheme) {
        this.dezenasScheme = dezenasScheme;
    }

    @Override
    public String toString() {
        return "ConquestStatistics \nconquestNumber : " + conquestNumber + "\nAcumulou :       "
                + isAcumulated + ",\ndata :           " + data
                + ",\ndezenas :        "
                + dezenas
                + ",\ndezenas :        "
                + stringDezenas
                + ",\ndezenasScheme :  " + dezenasScheme;
    }
}
