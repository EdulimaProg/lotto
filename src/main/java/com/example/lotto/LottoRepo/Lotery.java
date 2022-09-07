package com.example.lotto.LottoRepo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.example.lotto.Model.ConquestStatistics;
import com.example.lotto.Model.Dezenas;
import com.example.lotto.Model.LoteriasModel;
import com.example.lotto.Model.LoteryConquestType;
import com.example.lotto.Model.LotoType;
import com.example.lotto.Model.RangeScheme;
import com.example.lotto.Model.RangeSchemeDetails;
import com.example.lotto.Model.SchemeMostAwarded;
import com.example.lotto.Services.HttpConnection;
import com.example.lotto.Utils.LotteryRangers;
import com.example.lotto.Utils.Utils;

public class Lotery {
    private HttpConnection conn = new HttpConnection();
    private Utils utils;

    static ArrayList<RangeScheme> rangeSchemeList = new ArrayList<>();
    static ArrayList<ConquestStatistics> conquestStatisticsList = new ArrayList<>();
    static ArrayList<SchemeMostAwarded> schemeMostAwardeds = new ArrayList<>();
    //
    private ArrayList<LoteriasModel> concursos = new ArrayList<>();
    private ArrayList<Dezenas> conquestNumbeArrayList = new ArrayList<>();
    private List<List<String>> loteryRangeList = new ArrayList<>();

    DecimalFormat df = new DecimalFormat("#,###");

    private int conquestCarateresQTD;
    private LotoType lotofacil;
    private LotteryRangers ltr;

    LoteryConquestType loteryConquestType;

    public Lotery(LoteryConquestType loteryConquestType) {
        System.out.println("Create " + this.getClass().getSimpleName() + " BET");
        this.loteryConquestType = loteryConquestType;
        this.concursos = conn.getAllConquestsOfSpecificLoto(loteryConquestType.getLotoType().getConquestName());

        utils = new Utils(loteryConquestType.getLotoType().getConquestName());
        conquestCarateresQTD = loteryConquestType.getLotoType().getConquestQTD();

        lotofacil = loteryConquestType.getLotoType();
        ltr = new LotteryRangers();
        loteryRangeList = ltr.createFaixas(lotofacil).getLottoInFaixa();

    }

    public void initConquest() {
        getHistoricNumbers();
    }

    public void changePeriodOfConquest() {
        int init = 0;
        int end = concursos.size() - 1;
        clearAllArrays();

        if (loteryConquestType.getLottoConquestQuantity().getInitConquest() != null) {
            init = loteryConquestType.getLottoConquestQuantity().getInitConquest();
        }

        if (loteryConquestType.getLottoConquestQuantity().getEndConquest() != null) {
            end = loteryConquestType.getLottoConquestQuantity().getEndConquest();
        }
        for (LoteriasModel data : conn.getAllConquestsOfSpecificLoto(loteryConquestType.getLotoType().getConquestName())
                .subList(init, end)) {
            concursos.add(data);
        }

        getHistoricNumbers();
    }

    public void getOnlyAcumulated() {
        int init = 0;
        int end = concursos.size() - 1;
        clearAllArrays();

        if (loteryConquestType.getLottoConquestQuantity().getInitConquest() != null
                && loteryConquestType.getLottoConquestQuantity().getInitConquest() != 0) {
            init = loteryConquestType.getLottoConquestQuantity().getInitConquest();
        }

        if (loteryConquestType.getLottoConquestQuantity().getEndConquest() != null
                && loteryConquestType.getLottoConquestQuantity().getEndConquest() != 0) {
            end = loteryConquestType.getLottoConquestQuantity().getEndConquest();
        }

        for (LoteriasModel data : conn.getAllConquestsOfSpecificLoto(loteryConquestType.getLotoType().getConquestName())
                .subList(init, end)) {
            if (data.getAcumulou() == true) {
                concursos.add(data);
            }
        }

        getHistoricNumbers();
    }

    private void getHistoricNumbers() {
        System.out.println("Get " + Thread.currentThread().getStackTrace()[1].getMethodName());

        conquestNumbeArrayList.clear();

        int numberOfStart = loteryConquestType.getLotoType().getLottoInit();
        for (int i = 0; i < conquestCarateresQTD; i++) {
            int valueOfRepeat = 0;
            ArrayList<Integer> conquest = new ArrayList<>();
            String numberString = "";
            Integer number = 0;
            for (LoteriasModel listData : concursos) {
                if (listData.getDezenas().contains(String.format("%02d", i + numberOfStart))) {
                    valueOfRepeat = valueOfRepeat + 1;
                    conquest.add(listData.getConcurso());
                }
                number = i + numberOfStart;
                numberString = String.format("%02d", i + numberOfStart);
            }
            Dezenas dex = new Dezenas();

            dex.setDezena(numberString);
            dex.setQuantidade(valueOfRepeat);
            dex.setLastConquest(utils.checkIfIsOutIsLastConquest(String.format("%02d", i + numberOfStart)));
            dex.setPercentage(df.format(utils.percentageOfAward(valueOfRepeat, concursos.size())));
            dex.setRange(witchRange(numberString));
            dex.setIsPair(Utils.isPair(number));
            dex.setIsPrime(Utils.isPrimos(number));
            dex.setConquest(conquest);

            conquestNumbeArrayList.add(dex);

        }
        orderingNumbers();

        System.out.println("End " + Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    public void orderingNumbers() {
        Collections.sort(conquestNumbeArrayList, new Comparator<Dezenas>() {
            public int compare(Dezenas s1, Dezenas s2) {
                return Integer.valueOf(s2.getQuantidade()).compareTo(s1.getQuantidade());
            }
        });

        int h = 1;
        for (Dezenas data : conquestNumbeArrayList) {
            data.setHistoricPosition("Pos :" + String.format("%02d", h));
            h++;
        }

        int p = 1;
        for (Dezenas data : conquestNumbeArrayList) {
            if (data.getIsPair() == true) {
                data.setPairPosition("Pos :" + String.format("%02d", p));
                p++;
            } else {
                data.setPairPosition("N/A");
            }
        }

        int o = 1;
        for (Dezenas data : conquestNumbeArrayList) {
            if (data.getIsPair() == false) {
                data.setOddPostion("Pos :" + String.format("%02d", o));
                o++;
            } else {
                data.setOddPostion("N/A");
            }
        }

        int pm = 1;
        for (Dezenas data : conquestNumbeArrayList) {
            if (data.getIsPrime() == true) {
                data.setPrimePosition("Pos :" + String.format("%02d", pm));
                pm++;
            } else {
                data.setPairPosition("N/A");
            }

        }
    }

    public void getHistoricPrimeNumbers() {
        System.out.println("Get " + Thread.currentThread().getStackTrace()[1].getMethodName());

        for (Dezenas data : conquestNumbeArrayList) {
            if (data.getIsPrime()) {
                System.out
                        .println(data.getPrimePosition() + " " + data.getDezena() + " quantidade de vezes "
                                + data.getQuantidade() + " saiu no ultimo "
                                + data.getIsLastConquest() + " porcentagem de acertos " + data.getPercentage() + "% "
                                + data.getRange());
            }
        }

        System.out.println("End " + Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    public void getHistoricPairNumbers(Boolean getOdd) {
        System.out.println("Get " + Thread.currentThread().getStackTrace()[1].getMethodName());

        for (Dezenas data : conquestNumbeArrayList) {
            if (getOdd != null && getOdd == true) {
                if (!data.getIsPair()) {
                    System.out.println(data.getOddPostion() + " " + data.getDezena() + " quantidade de vezes "
                            + data.getQuantidade() + " saiu no ultimo "
                            + data.getIsLastConquest() + " porcentagem de acertos " + data.getPercentage()
                            + "% "
                            + data.getRange());
                }
            } else {
                if (data.getIsPair()) {
                    System.out.println(data.getPairPosition() + " " + data.getDezena() + " quantidade de vezes "
                            + data.getQuantidade() + " saiu no ultimo "
                            + data.getIsLastConquest() + " porcentagem de acertos " + data.getPercentage()
                            + "% "
                            + data.getRange());
                }
            }
        }
        System.out.println("End " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void getStatiticsInAllConquests() {
        for (LoteriasModel data : concursos) {
            ConquestStatistics conquestStatistics = new ConquestStatistics();

            conquestStatistics.setConquestNumber(data.getConcurso());
            conquestStatistics.setIsAcumulated(data.getAcumulou());
            conquestStatistics.setData(data.getData());
            conquestStatistics.setDezenas(data.getDezenas());
            conquestStatistics.setDezenasScheme(getRangeForConquest(data.getDezenas()));

            conquestStatisticsList.add(conquestStatistics);
        }

        for (ConquestStatistics data : conquestStatisticsList) {

            System.out.println(data.toString());
            System.out.println("\n");
        }
    }

    private String getRangeForConquest(ArrayList<String> data) {
        int range1 = 0;
        int range2 = 0;
        int range3 = 0;
        int range4 = 0;
        int range5 = 0;

        RangeScheme rangeScheme = new RangeScheme();

        for (int i = 0; i < data.size(); i++) {
            switch (witchRange(data.get(i))) {
                case 1:
                    range1 = range1 + 1;
                    break;
                case 2:
                    range2 = range2 + 1;
                    break;
                case 3:
                    range3 = range3 + 1;
                    break;
                case 4:
                    range4 = range4 + 1;
                    break;
                case 5:
                    range5 = range5 + 1;
                    break;
                default:
                    break;
            }
        }

        rangeScheme.setFaixa1(new RangeSchemeDetails(1, range1));
        rangeScheme.setFaixa2(new RangeSchemeDetails(2, range2));
        rangeScheme.setFaixa3(new RangeSchemeDetails(3, range3));
        rangeScheme.setFaixa4(new RangeSchemeDetails(4, range4));
        rangeScheme.setFaixa5(new RangeSchemeDetails(5, range5));

        String response = rangeScheme.getFaixa1().getQuantity() + "-" + rangeScheme.getFaixa2().getQuantity() + "-"
                + rangeScheme.getFaixa3().getQuantity() + "-"
                + rangeScheme.getFaixa4().getQuantity() + "-" + rangeScheme.getFaixa5().getQuantity();

        return response;

    }

    public void getRangeScheme() {

        for (LoteriasModel data : concursos) {
            int range1 = 0;
            int range2 = 0;
            int range3 = 0;
            int range4 = 0;
            int range5 = 0;

            RangeScheme rangeScheme = new RangeScheme();

            for (int i = 0; i < data.getDezenas().size(); i++) {
                switch (witchRange(data.getDezenas().get(i))) {
                    case 1:
                        range1 = range1 + 1;
                        break;
                    case 2:
                        range2 = range2 + 1;
                        break;
                    case 3:
                        range3 = range3 + 1;
                        break;
                    case 4:
                        range4 = range4 + 1;
                        break;
                    case 5:
                        range5 = range5 + 1;
                        break;
                    default:
                        break;
                }
            }

            rangeScheme.setConquest(data.getConcurso());
            rangeScheme.setFaixa1(new RangeSchemeDetails(1, range1));
            rangeScheme.setFaixa2(new RangeSchemeDetails(2, range2));
            rangeScheme.setFaixa3(new RangeSchemeDetails(3, range3));
            rangeScheme.setFaixa4(new RangeSchemeDetails(4, range4));
            rangeScheme.setFaixa5(new RangeSchemeDetails(5, range5));

            rangeSchemeList.add(rangeScheme);

        }

        for (RangeScheme data : rangeSchemeList) {
            System.out.println("-----------------------------------------------------");
            System.out.println("Conquest: " + data.getConquest());
            System.out.println("Range Scheme");
            System.out.println("Scheme " + data.getFaixa1().getQuantity() + "-" + data.getFaixa2().getQuantity() + "-"
                    + data.getFaixa3().getQuantity() + "-"
                    + data.getFaixa4().getQuantity() + "-" + data.getFaixa5().getQuantity());
        }
        System.out.println("-----------------------------------------------------");
    }

    public void print() {
        System.out.println(concursos.size());
    }

    public void printAllArray() {
        System.out.println("----------------------------------");
        System.out.println("Print Historic numbers \n");
        for (Dezenas data : conquestNumbeArrayList) {
            System.out.println(data.getDezena() + " quantidade de vezes " + data.getQuantidade() + " saiu no ultimo "
                    + data.getIsLastConquest() + " porcentagem de acertos " + data.getPercentage() + "% "
                    + data.getRange());
        }

        Collections.sort(conquestNumbeArrayList, new Comparator<Dezenas>() {
            public int compare(Dezenas s1, Dezenas s2) {
                return Integer.valueOf(s1.getQuantidade()).compareTo(s2.getQuantidade());
            }
        });
        System.out.println("----------------------------------");
        System.out.println("Print Inveted Historic numbers \n");
        for (Dezenas data : conquestNumbeArrayList) {

            System.out.println(data.getDezena() + " quantidade de vezes " + data.getQuantidade() + " saiu no ultimo "
                    + data.getIsLastConquest() + " porcentagem de acertos " + data.getPercentage() + "% "
                    + data.getRange());
        }
        System.out.println("----------------------------------");
        System.out.println("Print pair numbers \n");
        for (Dezenas data : conquestNumbeArrayList) {
            if (data.getIsPair()) {
                System.out
                        .println(data.getDezena() + " quantidade de vezes " + data.getQuantidade() + " saiu no ultimo "
                                + data.getIsLastConquest() + " porcentagem de acertos " + data.getPercentage() + "% "
                                + data.getRange());
            }

        }
        System.out.println("-----------------------------------");
        System.out.println("Print odd numbers \n");
        for (Dezenas data : conquestNumbeArrayList) {
            if (data.getIsPair() == false) {
                System.out
                        .println(data.getDezena() + " quantidade de vezes " + data.getQuantidade() + " saiu no ultimo "
                                + data.getIsLastConquest() + " porcentagem de acertos " + data.getPercentage() + "% "
                                + data.getRange());
            }

        }
        System.out.println("-----------------------------------");
        System.out.println("Print prime numbers \n");
        for (Dezenas data : conquestNumbeArrayList) {
            if (data.getIsPrime()) {
                System.out
                        .println(data.getDezena() + " quantidade de vezes " + data.getQuantidade() + " saiu no ultimo "
                                + data.getIsLastConquest() + " porcentagem de acertos " + data.getPercentage() + "% "
                                + data.getRange());
            }

        }
        System.out.println("-----------------------------------");

    }

    public void getSpecificRange(Integer range) {
        for (Dezenas data : conquestNumbeArrayList) {
            if (data.getRange() == range) {
                System.out.println(data.getHistoricPosition() + ": " + data.getDezena() + " quantidade de vezes "
                        + data.getQuantidade() + " saiu no ultimo " + data.getIsLastConquest()
                        + " porcentagem de acertos "
                        + data.getPercentage() + "% " + "Faixa :" + data.getRange());
            }
        }

    }

    public void getAllRange() {
        for (int i = 0; i < 5; i++) {
            for (Dezenas data : conquestNumbeArrayList) {
                if (data.getRange() == i + 1) {
                    System.out.println(data.getHistoricPosition() + ": " + data.getDezena() + " quantidade de vezes "
                            + data.getQuantidade() + " saiu no ultimo "
                            + utils.getIsLastConquest(data.getIsLastConquest())
                            + " porcentagem de acertos "
                            + data.getPercentage() + "% " + "Faixa :" + String.format("%02d", data.getRange()));
                }
            }
            System.out.println("-----------------------------------");
        }
    }

    public void inLastCoquest() {
        int prmo = 0;
        int ntprmo = 0;
        int pair = 0;
        int odd = 0;

        ArrayList<String> primoAwarded = new ArrayList<String>();
        ArrayList<String> pairAwarded = new ArrayList<String>();
        ArrayList<String> oddAwarded = new ArrayList<String>();

        LoteriasModel lastConquestData = concursos.get(0);
        System.out.println("No ultimo concurso: " + lastConquestData.getConcurso());
        System.out.println("as Dezenas Sorteadas foram: " + lastConquestData.getDezenas());

        for (String data_val : lastConquestData.getDezenas()) {
            if (Utils.isPair(Integer.parseInt(data_val))) {
                pair = pair + 1;
                oddAwarded.add(data_val);
            } else {
                odd = odd + 1;
                pairAwarded.add(data_val);
            }
        }

        if (pair < odd) {
            System.out.println("Foram Sorteadas Mais Numeros impares");
            System.out.println("---- PLACAR ----");
            System.out.println("Pair " + pair + "x" + odd + " Odd ");
            System.out.println("---------------------------------------------");
            System.out.println(oddAwarded);
            System.out.println("---------------------------------------------");
            System.out.println(pairAwarded);
            System.out.println("---------------------------------------------");

        } else {
            System.out.println("Foram Sorteadas Mais Numeros Pares");
            System.out.println("---- PLACAR ----");
            System.out.println("Pair " + pair + "x" + odd + " Odd ");
            System.out.println("---------------------------------------------");
            System.out.println(pairAwarded);
            System.out.println("---------------------------------------------");
            System.out.println(oddAwarded);
            System.out.println("---------------------------------------------");
        }

        for (String data_val : lastConquestData.getDezenas()) {
            if (Utils.isPrimos(Integer.parseInt(data_val))) {
                prmo = prmo + 1;
                primoAwarded.add(data_val);
            } else {
                ntprmo = ntprmo + 1;
            }
        }

        if (prmo < ntprmo) {
            System.out.println("Foram Sorteadas Mais Numeros Não Primos");
            System.out.println("---- PLACAR ----");
            System.out.println("Primo " + prmo + " x " + ntprmo + " Not Primo");
            System.out.println("---------------------------------------------");
            System.out.println(primoAwarded);
        } else {
            System.out.println("Foram Sorteadas Mais Numeros Primos");
            System.out.println("---- PLACAR ----");
            System.out.println("Primo " + prmo + " x " + ntprmo + " Nor Primo");
        }

        // for (Dezenas seq : conquestNumbeArrayList) {
        // System.out.println("---------------------------------------------");
        // System.out.println(seq.getDezena());
        // System.out.println(seq.getConquest());
        // System.out.println("---------------------------------------------");
        // }

        for (RangeScheme data : rangeSchemeList.subList(0, 1)) {
            System.out.println(data.getConquest());
            System.out.println("Scheme " + data.getFaixa1().getQuantity() + "-" + data.getFaixa2().getQuantity() + "-"
                    + data.getFaixa3().getQuantity() + "-"
                    + data.getFaixa4().getQuantity() + "-" + data.getFaixa5().getQuantity());
        }
        // System.out.println("---------------------------------------------");
        // System.out.println("Tiveram : " + repeatNumbers.size() + " Sairam no ultimo
        // concurso");
        // System.out.println("esses numeros foram");
        // System.out.println(repeatNumbers);
        // System.out.println("---------------------------------------------");

    }

    // Mover para geral
    public Integer witchRange(String String) {
        Integer rangeResponse = 0;
        for (int i = 0; i < lotofacil.getLotoLineSize(); i++) {
            if (loteryRangeList.get(i).contains(String)) {
                rangeResponse = (i + 1);
            }

        }
        return rangeResponse;
    }

    private void clearAllArrays() {
        concursos.clear();
    }

}
