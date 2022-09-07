package com.example.lotto.Model;

public class LotoType {
    String lotoName;
    int lotoLineSize;
    int lotoNumberSizePerLine;
    String conquestName;
    Integer conquestQTD;
    Integer lottoInit;

    public LotoType(String lotoName, int lotoLineSize, int lotoNumberSizePerLine, String conquestName,
            Integer conquestQTD, Integer lottoInit) {
        this.lotoName = lotoName;
        this.lotoLineSize = lotoLineSize;
        this.lotoNumberSizePerLine = lotoNumberSizePerLine;
        this.conquestName = conquestName;
        this.conquestQTD = conquestQTD;
        this.lottoInit = lottoInit;
    }

    public String getLotoName() {
        return lotoName;
    }

    public int getLotoLineSize() {
        return lotoLineSize;
    }

    public int getLotoNumberSizePerLine() {
        return lotoNumberSizePerLine;
    }

    public String getConquestName() {
        return conquestName;
    }

    public Integer getConquestQTD() {
        return conquestQTD;
    }

    public Integer getLottoInit() {
        return lottoInit;
    }

}
