package com.example.lotto.Model;

import java.util.List;

public class LotoFaixa {
    private String LottoName;
    private List<List<String>> lottoInFaixa;
    private int LottoFaixaQtd;

    public String getLottoName() {
        return LottoName;
    }

    public void setLottoName(String lottoName) {
        LottoName = lottoName;
    }

    public List<List<String>> getLottoInFaixa() {
        return lottoInFaixa;
    }

    public void setLottoInFaixa(List<List<String>> lottoInFaixa) {
        this.lottoInFaixa = lottoInFaixa;
    }

    public int getLottoFaixaQtd() {
        return LottoFaixaQtd;
    }

    public void setLottoFaixaQtd(int lottoFaixaQtd) {
        LottoFaixaQtd = lottoFaixaQtd;
    }
}
