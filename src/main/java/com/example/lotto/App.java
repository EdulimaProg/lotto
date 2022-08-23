package com.example.lotto;

import com.example.lotto.LottoRepo.LotoFacil.Lotofacil;
import com.example.lotto.LottoRepo.LotoFacil.LotofacilStatitics;
import com.example.lotto.LottoRepo.Lotomania.Lotomania;

public class App {

    public static void main(String[] args) {
        Lotofacil loto = new Lotofacil();
        LotofacilStatitics lotto = new LotofacilStatitics();
        // Lotomania loto = new Lotomania();

        loto.changePeriodOfConquest(0, 14);

        // loto.getOnlyAcumulated(0, 14);

        loto.initConquest();

        loto.getStatiticsInAllConquests();

        // loto.getNumbersOfAllConquest();

        // loto.printAllArray();

        // loto.inLastCoquest();
        // loto.getSpecificRange(1);

        loto.getAllRange();

        // TODO sistema para tirar espaçoes vaizio e coloar virgulas
        // 01,03,04,05,07,08,10,11,12,13,15,16,18,21,22
        // 01,02,03,04,05,07,09,10,12,14,15,16,20,21,23
        // 01,02,06,11,12,14,15,16,17,18,20,21,22,23,24
        // 01,02,03,04,05,06,07,09,10,11,12,17,18,21,22
        // 02,03,05,07,08,09,11,12,16,18,19,20,21,22,24
        // 01,02,04,05,06,07,08,12,14,16,17,18,22,23,24
        // 01,02,05,06,11,12,13,14,16,18,20,21,22,23,24
        // 01,02,03,04,05,06,07,08,09,11,12,14,15,16,21
        // 01,02,03,04,05,07,09,10,11,13,14,19,20,22,23
        // 02,03,04,05,06,08,09,11,12,14,17,18,19,20,22
        // 01,02,05,06,08,10,11,12,13,14,16,20,21,23,24
        // 1

        // for (String string : lotos) {
        // System.out.println(string.replace(" ", ","));
        // }

    }
}