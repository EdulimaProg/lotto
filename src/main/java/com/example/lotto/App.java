package com.example.lotto;

import com.example.lotto.LottoRepo.LotoFacil.Lotofacil;
import com.example.lotto.LottoRepo.Lotomania.Lotomania;
import com.example.lotto.Model.LotoFaixa;
import com.example.lotto.Model.LotoType;
import com.example.lotto.Utils.LotteryRangers;

public class App {

    public static void main(String[] args) {
        Lotofacil lotofacil = new Lotofacil();

        // lotofacil.witchRange("24");

        // Lotomania lotomania = new Lotomania();
        // LotteryFaixas faixas = new LotteryFaixas();
        // LotoType megasena = new LotoType("Megasena", 6, 10);
        // LotoType lotofacil = new LotoType("Lotofacil", 5, 5);
        // LotoType lotomania = new LotoType("Lotofacil", 10, 10);

        // LotoFaixa faixa = faixas.createFaixas(megasena);

        // System.out.println(faixa.getLottoInFaixa());

        // faixas.megasenaFaixas();

        lotofacil.changePeriodOfConquest(0, 10);

        lotofacil.initConquest();

        lotofacil.printAllArray();

        // lotomania.changePeriodOfConquest(0, 2);

        // lotomania.initConquest();

        // lotomania.printAllArray();

        lotofacil.print();
        // lotomania.print();
    }
}
