package com.example.lotto.Model;

public class LoteryConquestType {
    LotoType lotoType;
    LottoConquestQuantity lottoConquestQuantity;
    Boolean getAcumulated;

    public LoteryConquestType(LotoType lotoType, LottoConquestQuantity lottoConquestQuantity, Boolean getAcumulated) {
        this.lotoType = lotoType;
        this.lottoConquestQuantity = lottoConquestQuantity;
        this.getAcumulated = getAcumulated;
    }

    public LotoType getLotoType() {
        return lotoType;
    }

    public LottoConquestQuantity getLottoConquestQuantity() {
        return lottoConquestQuantity;
    }

    public Boolean getGetAcumulated() {
        return getAcumulated;
    }

}
