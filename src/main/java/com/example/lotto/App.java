package com.example.lotto;

import com.example.lotto.LottoRepo.LotoFacil.Lotofacil;
import com.example.lotto.LottoRepo.Lotomania.Lotomania;

public class App {

    public static void main(String[] args) {
        // Lotofacil lotofacil = new Lotofacil();

        Lotomania lotomania = new Lotomania();

        // lotofacil.changePeriodOfConquest(0, 40);

        // lotofacil.initConquest();

        // lotofacil.printAllArray();

        // lotomania.changePeriodOfConquest(0, 2);

        lotomania.initConquest();

        lotomania.printAllArray();

        // lotofacil.print();
        // lotomania.print();
    }
}
