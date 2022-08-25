package com.example.lotto.Model;

public class LotoType {
    String lotoName;
    int lotoStart;
    int lotoLineSize;
    int lotoNumberSizePerLine;

    public LotoType(String lotoName, int lotoLineSize, int lotoNumberSizePerLine, int lotoStart) {
        this.lotoName = lotoName;
        this.lotoLineSize = lotoLineSize;
        this.lotoNumberSizePerLine = lotoNumberSizePerLine;
        this.lotoStart = lotoStart;
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

    public int getLotoStart() {
        return lotoStart;
    }

    public void setLotoStart(int lotoStart) {
        this.lotoStart = lotoStart;
    }
}
