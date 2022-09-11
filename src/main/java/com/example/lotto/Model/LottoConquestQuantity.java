package com.example.lotto.Model;

public class LottoConquestQuantity {
    Integer initConquest;
    Integer endConquest;

    public LottoConquestQuantity(Integer initConquest, Integer endConquest) {
        this.initConquest = initConquest;
        this.endConquest = endConquest;
    }

    public Integer getInitConquest() {
        return initConquest;
    }

    public Integer getEndConquest() {
        return endConquest;
    }

    public void setInitConquest(Integer initConquest) {
        this.initConquest = initConquest;
    }

    public void setEndConquest(Integer endConquest) {
        this.endConquest = endConquest;
    }
}
