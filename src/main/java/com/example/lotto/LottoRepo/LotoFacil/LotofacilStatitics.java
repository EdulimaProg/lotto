package com.example.lotto.LottoRepo.LotoFacil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.example.lotto.LottoRepo.Interface.LottoStatitics;
import com.example.lotto.Model.Dezenas;
import com.example.lotto.Model.LoteriasModel;
import com.example.lotto.Model.LotoType;
import com.example.lotto.Services.HttpConnection;
import com.example.lotto.Utils.Constants;
import com.example.lotto.Utils.LotteryRangers;
import com.example.lotto.Utils.Utils;

public class LotofacilStatitics extends LottoStatitics {
    private HttpConnection conn = new HttpConnection();
    private Utils utils = new Utils(Constants.LOTOFACIL);

    private String conquestType = Constants.LOTOFACIL;
    private int conquestCarateresQTD = Constants.LOTOFACILQTD;

    private LotoType lotofacil;
    private LotteryRangers ltr;
    DecimalFormat df = new DecimalFormat("#,###");

    static ArrayList<String> pairList = new ArrayList<>();
    static ArrayList<String> oddList = new ArrayList<>();
    static ArrayList<String> primosList = new ArrayList<>();
    static ArrayList<String> notPrimosList = new ArrayList<>();

    private ArrayList<Dezenas> mostNumberAwarded = new ArrayList<>();
    private ArrayList<Integer> mostNumberAwardedOnlyDezenas = new ArrayList<>();
    private ArrayList<Dezenas> mostPairAwarded = new ArrayList<>();
    private ArrayList<Dezenas> mostPairAwardedOnlyDezenas = new ArrayList<>();
    private ArrayList<Dezenas> mostprimeAwarded = new ArrayList<>();
    private ArrayList<Dezenas> mostprimeAwardedOnlyDezenas = new ArrayList<>();

    private ArrayList<LoteriasModel> concursos = new ArrayList<>();

    public LotofacilStatitics() {
        System.out.println("Create " + this.getClass().getSimpleName() + " BET");
        this.concursos = conn.getAllConquestsOfSpecificLoto(conquestType);
        lotofacil = new LotoType("Lotofacil", 5, 5);
        ltr = new LotteryRangers();
    };

    @Override
    public void initArrays() {
        for (int i = 0; i < conquestCarateresQTD; i++) {
            if (Utils.isPair(i + 1))
                pairList.add(String.format("%02d", i + 1));
            if (!Utils.isPair(i + 1))
                oddList.add(String.format("%02d", i + 1));
            if (Utils.isPrimos(i + 1))
                primosList.add(String.format("%02d", i + 1));
        }
    }

    @Override
    public void confenceMyBetWithLastResults() {
        System.out.println("incomming");

    }

    @Override
    public void getMostAwardedNumberForSpecificPeriod(Integer start, Integer end) {
        if (start == null) {
            start = 0;
        }

        if (end == null) {
            end = 14;
        }

        List<LoteriasModel> concursoSublist = concursos.subList(start, end);

        System.out.println("Get " + Thread.currentThread().getStackTrace()[1].getMethodName());

        mostNumberAwarded.clear();

        int numberOfStart = 1;
        for (int i = 0; i < conquestCarateresQTD; i++) {
            int valueOfRepeat = 0;

            String number = "";
            for (LoteriasModel listData : concursoSublist) {
                if (listData.getDezenas().contains(String.format("%02d", i + numberOfStart))) {
                    valueOfRepeat = valueOfRepeat + 1;
                }
                number = String.format("%02d", i + numberOfStart);
            }
            Dezenas dex = new Dezenas();

            dex.setDezena(number);
            dex.setQuantidade(valueOfRepeat);
            dex.setLastConquest(utils.checkIfIsOutIsLastConquest(String.format("%02d", i + numberOfStart)));
            dex.setPercentage(df.format(utils.percentageOfAward(valueOfRepeat, concursos.size())));
            dex.setRange(witchRange(number));

            mostNumberAwarded.add(dex);
        }

        Collections.sort(mostNumberAwarded, new Comparator<Dezenas>() {
            public int compare(Dezenas s1, Dezenas s2) {
                return Integer.valueOf(s2.getQuantidade()).compareTo(s1.getQuantidade());
            }
        });

    }

    @Override
    public void getMostAwardNumbersInLastConquest() {

    }

    @Override
    public void getPairNumbersOfLastconquest() {
        // TODO Auto-generated method stub

    }

    @Override
    public void getPrimeNumbersOfLastConquest() {
        // TODO Auto-generated method stub

    }

    @Override
    public void getResultOfLastConquest() {

    }

    public Integer witchRange(String number) {
        Integer rangeResponse = 0;
        for (int i = 0; i < lotofacil.getLotoLineSize(); i++) {
            if (ltr.createFaixas(lotofacil).getLottoInFaixa().get(i).contains(number)) {
                rangeResponse = (i + 1);
            }

        }
        return rangeResponse;
    }

}
