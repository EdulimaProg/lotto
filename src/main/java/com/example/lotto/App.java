package com.example.lotto;

import com.example.lotto.LottoRepo.Lotery;
import com.example.lotto.Model.LoteryConquestType;
import com.example.lotto.Model.LotoType;
import com.example.lotto.Model.LottoConquestQuantity;
import com.example.lotto.Utils.Constants;

public class App {

        public static void main(String[] args) {
                // LotoType lotoType = new LotoType("Lotofacil", 5, 5, Constants.LOTOFACIL,
                // Constants.LOTOFACILQTD);
                // LottoConquestQuantity lottoConquestQuantity = new LottoConquestQuantity(0,
                // 14);

                // LotoType lotoType = new LotoType("Lotomania", 10, 10, Constants.LOTOMANIA,
                // Constants.LOTOMANIAQTD, 0);
                // LottoConquestQuantity lottoConquestQuantity = new LottoConquestQuantity(0,
                // 14);

                LotoType lotoType = new LotoType("dia-de-sorte", 4, 10, Constants.DIADESORTE, Constants.DIADESORTEQTD,
                                1);
                LottoConquestQuantity lottoConquestQuantity = new LottoConquestQuantity(0, 20);

                LoteryConquestType loteryConquestType = new LoteryConquestType(lotoType, lottoConquestQuantity, false);
                Lotery loto = new Lotery(loteryConquestType);

                // loto.getOnlyAcumulated();

                loto.getLuckMonth();

                // loto.printAllArray();

        }
}