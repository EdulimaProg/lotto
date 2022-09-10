package com.example.lotto.Model;

public class LotoType {
    String lotoName;
    int lotoLineSize;
    int lotoNumberSizePerLine;
    int lotoColumnSize;
    String conquestName;
    Integer conquestQTD;
    Integer lottoInit;

    public LotoType(String lotoName, int lotoLineSize, int lotoNumberSizePerLine, int lotoColumnSize,
            String conquestName, Integer conquestQTD, Integer lottoInit) {
        this.lotoName = lotoName;
        this.lotoLineSize = lotoLineSize;
        this.lotoNumberSizePerLine = lotoNumberSizePerLine;
        this.lotoColumnSize = lotoColumnSize;
        this.conquestName = conquestName;
        this.conquestQTD = conquestQTD;
        this.lottoInit = lottoInit;
    }

    public String getLotoName() {
        return lotoName;
    }

    public void setLotoName(String lotoName) {
        this.lotoName = lotoName;
    }

    public int getLotoLineSize() {
        return lotoLineSize;
    }

    public void setLotoLineSize(int lotoLineSize) {
        this.lotoLineSize = lotoLineSize;
    }

    public int getLotoNumberSizePerLine() {
        return lotoNumberSizePerLine;
    }

    public void setLotoNumberSizePerLine(int lotoNumberSizePerLine) {
        this.lotoNumberSizePerLine = lotoNumberSizePerLine;
    }

    public int getLotoColumnSize() {
        return lotoColumnSize;
    }

    public void setLotoColumnSize(int lotoColumnSize) {
        this.lotoColumnSize = lotoColumnSize;
    }

    public String getConquestName() {
        return conquestName;
    }

    public void setConquestName(String conquestName) {
        this.conquestName = conquestName;
    }

    public Integer getConquestQTD() {
        return conquestQTD;
    }

    public void setConquestQTD(Integer conquestQTD) {
        this.conquestQTD = conquestQTD;
    }

    public Integer getLottoInit() {
        return lottoInit;
    }

    public void setLottoInit(Integer lottoInit) {
        this.lottoInit = lottoInit;
    }

}
