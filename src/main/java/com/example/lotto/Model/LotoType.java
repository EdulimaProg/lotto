package com.example.lotto.Model;

public class LotoType {
    String lotoName;
    int lotoLineSize;
    int lotoNumberSizePerLine;

    public LotoType(String lotoName, int lotoLineSize, int lotoNumberSizePerLine) {
        this.lotoName = lotoName;
        this.lotoLineSize = lotoLineSize;
        this.lotoNumberSizePerLine = lotoNumberSizePerLine;
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
}
