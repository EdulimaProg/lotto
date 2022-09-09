package com.example.lotto;

import java.util.HashMap;
import java.util.Map;

import com.example.lotto.LottoRepo.Lotery;
import com.example.lotto.Model.LoteryConquestType;
import com.example.lotto.Model.LotoType;
import com.example.lotto.Model.LottoConquestQuantity;
import com.example.lotto.Utils.Constants;
import com.example.lotto.Utils.LottoTypesList;

public class App {
        static LottoTypesList lottoTypesList;
        static LotoType lotoType;
        static LottoConquestQuantity qtd;
        static LoteryConquestType loteryConquestType;

        public static void configure() {
                lottoTypesList = new LottoTypesList();
                lotoType = lottoTypesList.getLotoType().get(Constants.QUINA);

                qtd = new LottoConquestQuantity(0, 14);
                loteryConquestType = new LoteryConquestType(lotoType, qtd, false);
        }

        public static void main(String[] args) {
                configure();

                Lotery loto = new Lotery(loteryConquestType);

                // loto.getOnlyAcumulated();
                loto.initArrays();

                loto.getAllRange();

                // loto.inLastCoquest();
                // 09 20 34 35 36 47
                // 14 19 22 37 58 59
                // 04 08 15 23 38 49
                // 19 24 32 42 43 49

        }

}