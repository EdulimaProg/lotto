package com.example.lotto;

import com.example.lotto.LottoRepo.LotoFacil.Lotofacil;
import com.example.lotto.LottoRepo.Lotomania.Lotomania;
import com.example.lotto.Model.LotoFaixa;
import com.example.lotto.Model.LotoType;
import com.example.lotto.Utils.LotteryRangers;

public class App {

    public static void main(String[] args) {
        // Lotofacil loto = new Lotofacil();

        // lotofacil.witchRange("24");

        Lotomania loto = new Lotomania();
        // LotteryFaixas faixas = new LotteryFaixas();
        // LotoType megasena = new LotoType("Megasena", 6, 10);
        // LotoType lotofacil = new LotoType("Lotofacil", 5, 5);
        // LotoType lotomania = new LotoType("Lotofacil", 10, 10);

        // LotoFaixa faixa = faixas.createFaixas(megasena);

        // System.out.println(faixa.getLottoInFaixa());

        // faixas.megasenaFaixas();

        // lotofacil.changePeriodOfConquest(0, 10);

        // lotofacil.initConquest();

        // lotofacil.printAllArray();

        loto.changePeriodOfConquest(0, 5);

        // loto.initConquest();
        loto.createBets(12, 10);

        // loto.printAllArray();

        // lotofacil.print();
        // loto.inLastCoquest();
        // loto.inLastCoquest();
        // lotomania.print();

        // String[] lotos = {
        // "03 07 08 10 17 18 20 23 24 25 26 28 31 34 36 37 38 40 41 45 46 47 49 50 51
        // 53 55 56 58 59 61 64 68 72 74 75 76 77 81 83 84 86 87 88 89 92 93 97 98 99",
        // "02 03 05 07 09 10 13 17 18 20 21 23 24 27 28 32 33 34 37 38 40 41 45 48 51
        // 52 53 58 59 61 64 67 68 70 72 73 74 75 76 77 81 84 86 89 91 92 97 98 99 00",
        // "05 07 08 09 11 15 17 18 21 22 24 25 28 29 31 32 34 37 39 40 44 46 48 49 50
        // 51 52 53 56 58 59 61 62 64 69 70 76 78 80 81 82 84 87 88 91 94 96 97 99 00",
        // "01 02 03 05 06 07 10 12 13 14 15 17 18 21 22 23 24 26 28 29 30 35 36 38 39
        // 40 41 42 44 47 48 50 51 55 57 60 61 62 64 69 71 74 79 80 81 82 91 92 97 98",
        // "01 02 04 06 07 10 12 13 14 15 16 17 18 21 22 23 24 28 30 31 33 36 38 39 42
        // 43 44 45 48 50 51 54 57 60 61 63 69 72 74 76 81 83 86 91 93 94 95 97 99 00",
        // "01 02 03 04 05 06 07 12 13 17 18 21 22 25 30 38 39 40 41 43 44 45 48 51 57
        // 58 59 61 62 66 69 71 73 74 79 80 81 86 87 88 89 90 91 92 93 95 96 97 98 00",
        // "01 02 04 08 09 11 13 19 20 22 25 27 31 34 37 39 46 52 53 55 56 58 59 60 62
        // 64 65 66 67 68 70 72 73 75 76 78 80 82 84 85 87 88 89 90 93 95 96 97 99 00",
        // "01 05 08 11 12 16 17 19 23 25 26 32 34 35 37 40 43 44 46 49 52 53 55 56 57
        // 58 60 63 64 65 66 67 68 71 72 73 74 75 77 78 79 82 84 86 95 96 97 98 99 00",
        // "01 08 09 11 12 18 19 20 25 27 32 34 35 39 44 46 49 51 52 53 54 55 56 57 58
        // 59 62 64 65 66 68 71 73 75 77 78 80 82 84 85 87 88 89 90 93 96 97 98 99 00",
        // "02 03 04 06 07 10 13 14 15 17 21 22 24 26 28 30 31 33 36 37 38 40 42 44 45
        // 47 48 50 51 52 54 57 59 60 61 63 67 69 70 72 74 76 79 81 83 86 91 92 94 95",
        // "02 03 04 06 07 10 13 14 15 16 17 21 22 24 28 30 33 36 37 38 40 42 45 47 48
        // 50 51 52 59 60 61 63 64 67 69 70 72 73 76 77 79 81 83 84 86 91 94 95 97 99",
        // "01 03 04 06 07 10 14 15 16 17 18 20 21 22 24 28 29 30 31 32 33 36 38 40 41
        // 42 44 47 48 50 51 52 54 59 60 61 63 65 69 70 72 74 76 77 81 91 92 93 94 95",
        // };

        // for (String string : lotos) {
        // System.out.println(string.replace(" ", ","));
        // }

    }
}
