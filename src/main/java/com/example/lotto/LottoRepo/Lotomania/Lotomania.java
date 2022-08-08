package com.example.lotto.LottoRepo.Lotomania;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import com.example.lotto.LottoRepo.Interface.Lotto;
import com.example.lotto.Model.Dezenas;
import com.example.lotto.Model.LoteriasModel;
import com.example.lotto.Model.LotoType;
import com.example.lotto.Services.HttpConnection;
import com.example.lotto.Utils.Constants;
import com.example.lotto.Utils.LotteryRangers;
import com.example.lotto.Utils.Utils;

public class Lotomania extends Lotto {
    private HttpConnection conn = new HttpConnection();
    private Utils utils = new Utils(Constants.LOTOFACIL);

    static ArrayList<String> pairList = new ArrayList<>();
    static ArrayList<String> oddList = new ArrayList<>();
    static ArrayList<String> primosList = new ArrayList<>();
    static ArrayList<String> notPrimosList = new ArrayList<>();
    //
    private ArrayList<LoteriasModel> concursos = new ArrayList<>();
    private ArrayList<Dezenas> numbersMostAwarded = new ArrayList<>();
    private ArrayList<Dezenas> pairMostAwarded = new ArrayList<>();
    private ArrayList<Dezenas> primeNumbers = new ArrayList<>();
    private ArrayList<String> listString = new ArrayList<>();
    private ArrayList<String> preferredNumbers = new ArrayList<>();
    // private ArrayList<Dezenas> ExcludersNumbers = new ArrayList<>();
    // private ArrayList<Dezenas> withOutExcluders = new ArrayList<>();
    DecimalFormat df = new DecimalFormat("#,###");

    private String conquestType = Constants.LOTOFACIL;
    private int conquestCarateresQTD = Constants.LOTOMANIAQTD;
    private LotoType lotomania;
    private LotteryRangers ltr;
    private Integer mostAwardedQtd;
    private Integer notMostAwardeQtd;
    private Integer numberOfStart;
    private List excludeNumbers;

    public Lotomania() {
        System.out.println("Create " + this.getClass().getSimpleName() + " BET");
        this.concursos = conn.getAllConquestsOfSpecificLoto(conquestType);
        lotomania = new LotoType("Lotomania", 10, 10);
        ltr = new LotteryRangers();
        initArrays();
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

        System.out.println("End " + Thread.currentThread().getStackTrace()[1].getMethodName());

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

        for (Dezenas seq : numbersMostAwarded) {
            System.out.println("---------------------------------------------");
            System.out.println(seq.getDezena());
            System.out.println(seq.getConquest());
            System.out.println("---------------------------------------------");
        }
        System.out.println("---------------------------------------------");
        System.out.println("Tiveram : " + repeatNumbers.size() + " Sairam no ultimo concurso");
        System.out.println("esses numeros foram");
        System.out.println(repeatNumbers);
        System.out.println("---------------------------------------------");

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
        for (LoteriasModel loteriasModel : concursos) {
            for (String dezena : loteriasModel.getDezenas()) {

            }
        }
    }

    public String witchRange(String number) {
        String rangeResponse = " ";
        for (int i = 0; i < lotomania.getLotoLineSize(); i++) {
            if (ltr.lotofacilFaixas().getLottoInFaixa().get(i).contains(number)) {
                rangeResponse = "Faixa " + (i + 1);
            }

        }
        return rangeResponse;
    }

    public void createBets(int betQtd, int interval) {
        int startOfBet;
        int endOfBet;
        int mstAwdQtd;
        int ntMstAwdQtd;
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
                betFormed.add(dataDezenas.getDezena());
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
                if (contains1 == false) {
                    betFormed2.add(subList2.get(index).getDezena());
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
