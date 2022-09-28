package com.example.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.lotto.LottoRepo.Lotery;
import com.example.lotto.Model.LoteryConquestType;
import com.example.lotto.Model.LotoType;
import com.example.lotto.Model.LottoConquestQuantity;
import com.example.lotto.Model.ResultType;
import com.example.lotto.Utils.Constants;
import com.example.lotto.Utils.LottoTypesList;

public class App {
        static LottoTypesList lottoTypesList;
        static LotoType lotoType;
        static LottoConquestQuantity qtd;
        static LoteryConquestType loteryConquestType;

        // Teste
        static ArrayList<Integer> integerList = new ArrayList<>();

        public static void configure() {
                // ResultType resultType = new ResultType(false, false, false, 0, 0, false);
                lottoTypesList = new LottoTypesList();
                lotoType = lottoTypesList.getLotoType().get(Constants.LOTOMANIA);

                qtd = new LottoConquestQuantity(0, 200);
                loteryConquestType = new LoteryConquestType(lotoType, qtd, false);
        }

        public static void main(String[] args) {
                configure();

                Lotery loto = new Lotery(loteryConquestType);

                // loto.getOnlyAcumulated();
                loto.initArrays();

                // loto.getAllRange();
                // loto.findInbet("05");
                List<String> data = Arrays.asList("01", "03", "05", "22", "24");
                // loto.findBet(data);
                // loto.printResultLuckMonth();

                // loto.printStatitics();
                loto.inLastCoquest();
                // 09 20 34 35 36 47
                // 14 19 22 37 58 59
                // 04 08 15 23 38 49
                // 19 24 32 42 43 49

        }

}