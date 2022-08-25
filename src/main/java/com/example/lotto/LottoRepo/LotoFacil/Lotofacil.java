package com.example.lotto.LottoRepo.LotoFacil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.example.lotto.LottoRepo.Interface.Lotto;
import com.example.lotto.Model.ConquestStatistics;
import com.example.lotto.Model.Dezenas;
import com.example.lotto.Model.LoteriasModel;
import com.example.lotto.Model.LotoType;
import com.example.lotto.Model.NumberSchemeMostAwarded;
import com.example.lotto.Model.RangeScheme;
import com.example.lotto.Model.RangeSchemeDetails;
import com.example.lotto.Model.SchemeMostAwarded;
import com.example.lotto.Services.HttpConnection;
import com.example.lotto.Utils.Constants;
import com.example.lotto.Utils.LotteryRangers;
import com.example.lotto.Utils.Utils;

public class Lotofacil extends Lotto {
    private HttpConnection conn = new HttpConnection();
    private Utils utils = new Utils(Constants.LOTOFACIL);

    static ArrayList<String> pairList = new ArrayList<>();
    static ArrayList<String> oddList = new ArrayList<>();
    static ArrayList<String> primosList = new ArrayList<>();
    static ArrayList<String> notPrimosList = new ArrayList<>();
    static ArrayList<RangeScheme> rangeSchemeList = new ArrayList<>();
    static ArrayList<ConquestStatistics> conquestStatisticsList = new ArrayList<>();
    static ArrayList<SchemeMostAwarded> schemeMostAwardedList = new ArrayList<>();
    static ArrayList<NumberSchemeMostAwarded> numberStringList = new ArrayList<>();
    static ArrayList<String> getAllLoteryScheme = new ArrayList<>();
    //
    private ArrayList<LoteriasModel> concursos = new ArrayList<>();
    private ArrayList<Dezenas> numbersMostAwarded = new ArrayList<>();
    private ArrayList<Dezenas> pairMostAwarded = new ArrayList<>();
    private ArrayList<Dezenas> primeNumbers = new ArrayList<>();
    private ArrayList<String> listString = new ArrayList<>();
    private ArrayList<String> numberString = new ArrayList<>();

    private ArrayList<String> preferredNumbers = new ArrayList<>();
    // private ArrayList<Dezenas> ExcludersNumbers = new ArrayList<>();
    // private ArrayList<Dezenas> withOutExcluders = new ArrayList<>();
    DecimalFormat df = new DecimalFormat("#,###");

    private String conquestType = Constants.LOTOFACIL;
    private int conquestCarateresQTD = Constants.LOTOFACILQTD;
    private LotoType lotofacil;
    private LotteryRangers ltr;
    private Integer mostAwardedQtd;
    private Integer notMostAwardeQtd;
    private Integer numberOfStart;
    private List excludeNumbers;
    private List favoriteNumbers;

    public Lotofacil() {
        System.out.println("Create " + this.getClass().getSimpleName() + " BET");
        this.concursos = conn.getAllConquestsOfSpecificLoto(conquestType);
        lotofacil = new LotoType("Lotofacil", 5, 5, 1);
        ltr = new LotteryRangers();
        initArrays();
    }

    public void getStatiticsInAllConquests() {
        for (LoteriasModel data : concursos) {
            ConquestStatistics conquestStatistics = new ConquestStatistics();

            conquestStatistics.setConquestNumber(data.getConcurso());
            conquestStatistics.setIsAcumulated(data.getAcumulou());
            conquestStatistics.setData(data.getData());
            conquestStatistics.setDezenas(data.getDezenas());
            conquestStatistics.setStringDezenas(data.getDezenas().toString().substring(1, 59));
            String getScheme = getRangeForConquest(data.getDezenas());

            conquestStatistics.setDezenasScheme(getScheme);

            conquestStatisticsList.add(conquestStatistics);

            if (getAllLoteryScheme.isEmpty()) {
                getAllLoteryScheme.add(getScheme);

            } else {
                if (!getAllLoteryScheme.contains(getScheme)) {
                    getAllLoteryScheme.add(getScheme);
                }
            }

            if (numberString.isEmpty()) {
                numberString.add(conquestStatistics.getStringDezenas());

            } else {
                if (!numberString.contains(conquestStatistics.getStringDezenas())) {
                    numberString.add(conquestStatistics.getStringDezenas());
                }
            }
        }

        for (ConquestStatistics data : conquestStatisticsList) {

            System.out.println(data.toString());
            System.out.println("\n");
        }

        getSchemeMostAwaded();
        getNumberSchemeAwaded();

        for (SchemeMostAwarded data : schemeMostAwardedList) {
            System.out.println(data.getSchema() + ": " + data.getQuantity());
        }

        for (NumberSchemeMostAwarded data : numberStringList) {
            System.out.println(data.getSchema() + ": " + data.getQuantity());
        }

    }

    public void getSchemeMostAwaded() {
        for (int i = 0; i < getAllLoteryScheme.size(); i++) {
            int count = 0;
            for (ConquestStatistics data : conquestStatisticsList) {
                if (data.getDezenasScheme().equals(getAllLoteryScheme.get(i))) {
                    count = count + 1;
                }
            }
            SchemeMostAwarded schemeMostAwarded = new SchemeMostAwarded();

            schemeMostAwarded.setSchema(getAllLoteryScheme.get(i));
            schemeMostAwarded.setQuantity(count);

            schemeMostAwardedList.add(schemeMostAwarded);

        }

        Collections.sort(schemeMostAwardedList, new Comparator<SchemeMostAwarded>() {
            public int compare(SchemeMostAwarded s1, SchemeMostAwarded s2) {
                return Integer.valueOf(s2.getQuantity()).compareTo(s1.getQuantity());
            }
        });
    }

    public void getNumberSchemeAwaded() {
        for (int i = 0; i < numberString.size(); i++) {
            int count = 0;
            for (ConquestStatistics data : conquestStatisticsList) {
                if (data.getStringDezenas().equals(numberString.get(i))) {
                    count = count + 1;
                }
            }
            NumberSchemeMostAwarded number = new NumberSchemeMostAwarded();

            number.setSchema(getAllLoteryScheme.get(i));
            number.setQuantity(count);

            numberStringList.add(number);

        }

        Collections.sort(numberStringList, new Comparator<NumberSchemeMostAwarded>() {
            public int compare(NumberSchemeMostAwarded s1, NumberSchemeMostAwarded s2) {
                return Integer.valueOf(s2.getQuantity()).compareTo(s1.getQuantity());
            }
        });
    }

    public List getFavoriteNumbers() {
        return favoriteNumbers;
    }

    public void setFavoriteNumbers(List favoriteNumbers) {
        this.favoriteNumbers = favoriteNumbers;
    }

    public ArrayList<String> getListString() {
        return listString;
    }

    public List getExcludeNumbers() {
        return excludeNumbers;
    }

    public void setExcludeNumbers(List excludeNumbers) {
        this.excludeNumbers = excludeNumbers;
    }

    public Integer getNumberOfStart() {
        return numberOfStart;
    }

    public void setNumberOfStart(Integer numberOfStart) {
        this.numberOfStart = numberOfStart;
    }

    public Integer getMostAwardedQtd() {
        return mostAwardedQtd;
    }

    public void setMostAwardedQtd(Integer mostAwardedQtd) {
        this.mostAwardedQtd = mostAwardedQtd;
    }

    public Integer getNotMostAwardeQtd() {
        return notMostAwardeQtd;
    }

    public void setNotMostAwardeQtd(Integer notMostAwardeQtd) {
        this.notMostAwardeQtd = notMostAwardeQtd;
    }

    @Override
    public void initConquest() {
        getHistoricMostAwarded();
        getHistoricPrimeNumbers();
        getHistoricPairNumbers();
    }

    private void initArrays() {
        for (int i = 0; i < conquestCarateresQTD; i++) {
            if (Utils.isPair(i + 1))
                pairList.add(String.format("%02d", i + 1));
            if (!Utils.isPair(i + 1))
                oddList.add(String.format("%02d", i + 1));
            if (Utils.isPrimos(i + 1))
                primosList.add(String.format("%02d", i + 1));
        }
    }

    private void getHistoricMostAwarded() {
        System.out.println("Get " + Thread.currentThread().getStackTrace()[1].getMethodName());

        numbersMostAwarded.clear();

        int numberOfStart = 1;
        for (int i = 0; i < conquestCarateresQTD; i++) {
            int valueOfRepeat = 0;
            ArrayList<Integer> conquest = new ArrayList<>();
            String number = "";
            for (LoteriasModel listData : concursos) {
                if (listData.getDezenas().contains(String.format("%02d", i + numberOfStart))) {
                    valueOfRepeat = valueOfRepeat + 1;
                    conquest.add(listData.getConcurso());
                }
                number = String.format("%02d", i + numberOfStart);

            }
            Dezenas dex = new Dezenas();

            dex.setDezena(number);
            dex.setQuantidade(valueOfRepeat);
            dex.setLastConquest(utils.checkIfIsOutIsLastConquest(String.format("%02d", i + numberOfStart)));
            dex.setPercentage(df.format(utils.percentageOfAward(valueOfRepeat, concursos.size())));
            dex.setRange(witchRange(number));
            dex.setConquest(conquest);

            numbersMostAwarded.add(dex);
        }

        Collections.sort(numbersMostAwarded, new Comparator<Dezenas>() {
            public int compare(Dezenas s1, Dezenas s2) {
                return Integer.valueOf(s2.getQuantidade()).compareTo(s1.getQuantidade());
            }
        });

        int i = 1;
        for (Dezenas data : numbersMostAwarded) {
            data.setPosition("Pos :" + i);
            i++;
        }

        System.out.println("End " + Thread.currentThread().getStackTrace()[1].getMethodName());

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

    public void getNumbersOfAllConquest() {

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
            System.out.println(data.getConquest());
            System.out.println("Scheme " + data.getFaixa1().getQuantity() + "-" + data.getFaixa2().getQuantity() + "-"
                    + data.getFaixa3().getQuantity() + "-"
                    + data.getFaixa4().getQuantity() + "-" + data.getFaixa5().getQuantity());
        }
    }

    private void getHistoricPairNumbers() {
        System.out.println("Get " + Thread.currentThread().getStackTrace()[1].getMethodName());

        pairMostAwarded.clear();

        int numberOfStart = 1;
        for (int i = 0; i < pairList.size(); i++) {
            int valueOfRepeat = 0;
            ArrayList<Integer> conquest = new ArrayList<>();
            String number = "";
            for (LoteriasModel listData : concursos) {
                if (listData.getDezenas().contains(pairList.get(i))) {
                    valueOfRepeat = valueOfRepeat + 1;
                    conquest.add(listData.getConcurso());
                }
                number = pairList.get(i);
            }
            Dezenas dex = new Dezenas();

            dex.setDezena(number);
            dex.setQuantidade(valueOfRepeat);
            dex.setLastConquest(utils.checkIfIsOutIsLastConquest(String.format("%02d", i + numberOfStart)));
            dex.setPercentage(df.format(utils.percentageOfAward(valueOfRepeat, concursos.size())));
            dex.setRange(witchRange(number));
            dex.setConquest(conquest);

            pairMostAwarded.add(dex);
        }

        Collections.sort(pairMostAwarded, new Comparator<Dezenas>() {
            public int compare(Dezenas s1, Dezenas s2) {
                return Integer.valueOf(s2.getQuantidade()).compareTo(s1.getQuantidade());
            }
        });

        System.out.println("End " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    private void getHistoricPrimeNumbers() {
        System.out.println("Get " + Thread.currentThread().getStackTrace()[1].getMethodName());

        primeNumbers.clear();

        int numberOfStart = 1;
        for (int i = 0; i < primosList.size(); i++) {
            int valueOfRepeat = 0;
            ArrayList<Integer> conquest = new ArrayList<>();

            String number = "";
            for (LoteriasModel listData : concursos) {
                if (listData.getDezenas().contains(primosList.get(i))) {
                    valueOfRepeat = valueOfRepeat + 1;
                    conquest.add(listData.getConcurso());
                }
                number = primosList.get(i);
            }
            Dezenas dex = new Dezenas();

            dex.setDezena(number);
            dex.setQuantidade(valueOfRepeat);
            dex.setLastConquest(utils.checkIfIsOutIsLastConquest(String.format("%02d", i + numberOfStart)));
            dex.setPercentage(df.format(utils.percentageOfAward(valueOfRepeat, concursos.size())));
            dex.setRange(witchRange(number));
            dex.setConquest(conquest);

            primeNumbers.add(dex);
        }

        Collections.sort(primeNumbers, new Comparator<Dezenas>() {
            public int compare(Dezenas s1, Dezenas s2) {
                return Integer.valueOf(s2.getQuantidade()).compareTo(s1.getQuantidade());
            }
        });

        System.out.println("End " + Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    @Override
    public void print() {
        System.out.println(pairList);
        System.out.println(oddList);
        System.out.println(primosList);
        System.out.println(concursos.size());
    }

    @Override
    public void printAllArray() {
        for (Dezenas data : numbersMostAwarded) {
            System.out.println(data.getDezena() + " quantidade de vezes " + data.getQuantidade() + " saiu no ultimo "
                    + data.getIsLastConquest() + " porcentagem de acertos " + data.getPercentage() + "% "
                    + data.getRange());
        }

        Collections.sort(numbersMostAwarded, new Comparator<Dezenas>() {
            public int compare(Dezenas s1, Dezenas s2) {
                return Integer.valueOf(s1.getQuantidade()).compareTo(s2.getQuantidade());
            }
        });
        System.out.println("----------------------------------");
        for (Dezenas data : numbersMostAwarded) {
            System.out.println(data.getDezena() + " quantidade de vezes " + data.getQuantidade() + " saiu no ultimo "
                    + data.getIsLastConquest() + " porcentagem de acertos " + data.getPercentage() + "% "
                    + data.getRange());
        }
        System.out.println("----------------------------------");
        for (Dezenas data : pairMostAwarded) {
            System.out.println(data.getDezena() + " quantidade de vezes " + data.getQuantidade() + " saiu no ultimo "
                    + data.getIsLastConquest() + " porcentagem de acertos " + data.getPercentage() + "% "
                    + data.getRange());
        }
        System.out.println("-----------------------------------");
        for (Dezenas data : primeNumbers) {
            System.out.println(data.getDezena() + " quantidade de vezes " + data.getQuantidade() + " saiu no ultimo "
                    + data.getIsLastConquest() + " porcentagem de acertos " + data.getPercentage() + "% "
                    + data.getRange());
        }
        System.out.println("-----------------------------------");

        System.out.println("-----------------------------------");

    }

    public void getSpecificRange(Integer range) {
        for (Dezenas data : numbersMostAwarded) {
            if (data.getRange() == range) {
                System.out.println(data.getPosition() + ": " + data.getDezena() + " quantidade de vezes "
                        + data.getQuantidade() + " saiu no ultimo " + data.getIsLastConquest()
                        + " porcentagem de acertos "
                        + data.getPercentage() + "% " + "Faixa :" + data.getRange());
            }
        }

    }

    public void getOnlyAcumulated(int init, int end) {
        clearAllArrays();
        initArrays();
        for (LoteriasModel data : conn.getAllConquestsOfSpecificLoto(conquestType).subList(init, end)) {
            if (data.getAcumulou() == true) {
                concursos.add(data);
            }
        }
    }

    public void getAllRange() {
        for (int i = 0; i < 5; i++) {
            for (Dezenas data : numbersMostAwarded) {
                if (data.getRange() == i + 1) {
                    System.out.println(data.getPosition() + ": " + data.getDezena() + " quantidade de vezes "
                            + data.getQuantidade() + " saiu no ultimo " + data.getIsLastConquest()
                            + " porcentagem de acertos "
                            + data.getPercentage() + "% " + "Faixa :" + data.getRange());
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
        ArrayList<String> repeatNumbers = new ArrayList<String>();

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

        // for (Dezenas seq : numbersMostAwarded) {
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

    @Override
    public void changePeriodOfConquest(int init, int end) {
        clearAllArrays();
        initArrays();
        for (LoteriasModel data : conn.getAllConquestsOfSpecificLoto(conquestType).subList(init, end)) {
            concursos.add(data);
        }
    }

    public void getFaixaMostAwarded() {
        int range1 = 0;
        int range2 = 0;
        int range3 = 0;
        int range4 = 0;
        int range5 = 0;

        RangeScheme rangeScheme = new RangeScheme();

        for (LoteriasModel data : concursos) {
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
        }

        rangeScheme.setFaixa1(new RangeSchemeDetails(1, range1));
        rangeScheme.setFaixa2(new RangeSchemeDetails(2, range2));
        rangeScheme.setFaixa3(new RangeSchemeDetails(3, range3));
        rangeScheme.setFaixa4(new RangeSchemeDetails(4, range4));
        rangeScheme.setFaixa5(new RangeSchemeDetails(5, range5));

        rangeSchemeList.add(rangeScheme);
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

    public void createBets(int betQtd, int interval) {
        int startOfBet;
        int endOfBet;
        int mstAwdQtd;
        int ntMstAwdQtd;
        List favNumbers;
        List numbersExcList;

        if (mostAwardedQtd != null) {
            mstAwdQtd = mostAwardedQtd;
            ntMstAwdQtd = notMostAwardeQtd;
        } else {
            mstAwdQtd = 8;
            ntMstAwdQtd = 7;
        }

        if (excludeNumbers == null) {
            numbersExcList = new ArrayList<>();
        } else {
            numbersExcList = excludeNumbers;
        }

        if (favoriteNumbers == null) {
            favNumbers = new ArrayList<>();
        } else {
            favNumbers = favoriteNumbers;
        }

        if (numberOfStart == null) {
            startOfBet = 0;
            endOfBet = interval;
        } else {
            startOfBet = numberOfStart;
            endOfBet = interval + numberOfStart;
        }

        for (int i = 0; i < betQtd; i++) {
            numbersMostAwarded.clear();
            changePeriodOfConquest(startOfBet, endOfBet);
            getHistoricMostAwarded();
            String bet = "";
            List<Dezenas> subList = new ArrayList<>();
            List<Dezenas> subList1 = new ArrayList<>();
            List<Dezenas> subList2 = new ArrayList<>();
            List<String> betFormed = new ArrayList<>();
            List<String> betFormed2 = new ArrayList<>();

            if (numbersExcList.isEmpty()) {
                subList = numbersMostAwarded.subList(0, 20);
            } else {
                for (Dezenas string : numbersMostAwarded.subList(0, 20)) {
                    if (excludeNumbers.contains(string.getDezena()) == false) {
                        subList.add(string);
                    }
                }
            }

            Collections.sort(subList, new Comparator<Dezenas>() {
                public int compare(Dezenas s1, Dezenas s2) {
                    return Integer.valueOf(s1.getDezena()).compareTo(Integer.valueOf(s2.getDezena()));
                }
            });

            subList1.addAll(subList);

            for (Dezenas dataDezenas : subList1.subList(0, mstAwdQtd)) {
                if (favNumbers.contains(dataDezenas.getDezena()) == false) {
                    betFormed.add(dataDezenas.getDezena());
                }
                // if (bet == "") {
                // bet = dataDezenas.getDezena();
                // } else {
                // bet = bet + "," + dataDezenas.getDezena();
                // }

            }

            Collections.sort(subList, new Comparator<Dezenas>() {
                public int compare(Dezenas s1, Dezenas s2) {
                    return Integer.valueOf(s2.getDezena()).compareTo(Integer.valueOf(s1.getDezena()));
                }
            });

            subList2.addAll(subList);

            int index = 0;
            while (betFormed2.size() < ntMstAwdQtd) {
                Boolean contains1 = betFormed.contains(subList2.get(index).getDezena());
                Boolean contains2 = favNumbers.contains(subList2.get(index).getDezena());
                if (contains1 == false) {
                    if (contains2 == false) {
                        betFormed2.add(subList2.get(index).getDezena());
                    }
                }
                index = index + 1;
            }

            for (Dezenas dataDezenas : subList2.subList(0, ntMstAwdQtd)) {

                // if (bet == "") {
                // bet = dataDezenas.getDezena();
                // } else {
                // bet = bet + "," + dataDezenas.getDezena();
                // }

            }

            startOfBet = startOfBet + interval;
            endOfBet = endOfBet + interval;

            betFormed.addAll(betFormed2);
            betFormed.addAll(favNumbers);
            Collections.sort(betFormed, new Comparator<String>() {
                public int compare(String s1, String s2) {
                    return Integer.valueOf(s1).compareTo(Integer.valueOf(s2));
                }
            });
            for (String data : betFormed) {
                if (bet == "") {
                    bet = data;
                } else {
                    bet = bet + "," + data;
                }
            }

            listString.add(bet);
        }

        for (int i = 0; i < listString.size(); i++) {
            System.out.println(listString.get(i));
        }

    }

    private void clearAllArrays() {
        pairList.clear();
        oddList.clear();
        primosList.clear();
        notPrimosList.clear();

        concursos.clear();
        pairMostAwarded.clear();
        pairMostAwarded.clear();
        primeNumbers.clear();
    }

}
