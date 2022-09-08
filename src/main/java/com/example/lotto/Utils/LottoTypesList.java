package com.example.lotto.Utils;

import java.util.HashMap;
import java.util.Map;

import com.example.lotto.Model.LotoType;

public class LottoTypesList {
    Map<String, LotoType> lototypes = new HashMap<String, LotoType>();

    public LottoTypesList() {
        init();
    }

    public void init() {
        lototypes.put(Constants.DIADESORTE, Constants.diaSorte);
        lototypes.put(Constants.LOTOFACIL, Constants.lotofacil);
        lototypes.put(Constants.MEGASENA, Constants.megasena);
        lototypes.put(Constants.LOTOMANIA, Constants.lotomania);
        lototypes.put(Constants.DUPLASENA, Constants.duplasena);
        lototypes.put(Constants.QUINA, Constants.quina);
    }

    public Map<String, LotoType> getLotoType() {
        return lototypes;
    }
}
