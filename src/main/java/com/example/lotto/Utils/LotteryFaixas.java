package com.example.lotto.Utils;

import java.util.*;

import com.example.lotto.Model.LotoFaixa;

public class LotteryFaixas {

    public LotoFaixa lotofacilFaixas() {
        List<List<String>> dataList = new ArrayList<>();
        LotoFaixa data = new LotoFaixa();

        data.setLottoName("LotoFacil");
        data.setLottoFaixaQtd(5);

        List<String> faixa1 = Arrays.asList("01", "02", "03", "04", "05");
        List<String> faixa2 = Arrays.asList("01", "02", "03", "04", "05");
        List<String> faixa3 = Arrays.asList("01", "02", "03", "04", "05");
        List<String> faixa4 = Arrays.asList("01", "02", "03", "04", "05");
        List<String> faixa5 = Arrays.asList("01", "02", "03", "04", "05");

        dataList.add(faixa1);
        dataList.add(faixa2);
        dataList.add(faixa3);
        dataList.add(faixa4);
        dataList.add(faixa5);

        data.setLottoInFaixa(dataList);

        return data;
    }

}
