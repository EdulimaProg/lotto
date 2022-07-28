package com.example.lotto.LottoRepo.LotoFacil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.example.lotto.LottoRepo.Interface.Lotto;
import com.example.lotto.Model.Dezenas;
import com.example.lotto.Model.LoteriasModel;
import com.example.lotto.Services.HttpConnection;
import com.example.lotto.Utils.Constants;
import com.example.lotto.Utils.Utils;

public class Lotofacil extends Lotto {
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
    // private ArrayList<Dezenas> ExcludersNumbers = new ArrayList<>();
    // private ArrayList<Dezenas> withOutExcluders = new ArrayList<>();
    DecimalFormat df = new DecimalFormat("#,###");

    private String conquestType = Constants.LOTOFACIL;
    private int conquestCarateresQTD = Constants.LOTOFACILQTD;

    public Lotofacil() {
        System.out.println("Create " + this.getClass().getSimpleName() + " BET");
        this.concursos = conn.getAllConquestsOfSpecificLoto(conquestType);
        initArrays();
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
            String number = "";
            for (LoteriasModel listData : concursos) {
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
            String number = "";
            for (LoteriasModel listData : concursos) {
                if (listData.getDezenas().contains(pairList.get(i))) {
                    valueOfRepeat = valueOfRepeat + 1;
                }
                number = pairList.get(i);
            }
            Dezenas dex = new Dezenas();

            dex.setDezena(number);
            dex.setQuantidade(valueOfRepeat);
            dex.setLastConquest(utils.checkIfIsOutIsLastConquest(String.format("%02d", i + numberOfStart)));
            dex.setPercentage(df.format(utils.percentageOfAward(valueOfRepeat, concursos.size())));

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
            String number = "";
            for (LoteriasModel listData : concursos) {
                if (listData.getDezenas().contains(primosList.get(i))) {
                    valueOfRepeat = valueOfRepeat + 1;
                }
                number = primosList.get(i);
            }
            Dezenas dex = new Dezenas();

            dex.setDezena(number);
            dex.setQuantidade(valueOfRepeat);
            dex.setLastConquest(utils.checkIfIsOutIsLastConquest(String.format("%02d", i + numberOfStart)));
            dex.setPercentage(df.format(utils.percentageOfAward(valueOfRepeat, concursos.size())));

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
    public void initConquest() {
        getHistoricMostAwarded();
        getHistoricPrimeNumbers();
        getHistoricPairNumbers();
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
                    + data.getIsLastConquest() + " porcentagem de acertos "
                    + data.getPercentage() + "%");
        }
        System.out.println("----------------------------------");
        for (Dezenas data : pairMostAwarded) {
            System.out.println(data.getDezena() + " quantidade de vezes " + data.getQuantidade() + " saiu no ultimo "
                    + data.getIsLastConquest() + " porcentagem de acertos "
                    + data.getPercentage() + "%");
        }
        System.out.println("-----------------------------------");
        for (Dezenas data : primeNumbers) {
            System.out.println(data.getDezena() + " quantidade de vezes " + data.getQuantidade() + " saiu no ultimo "
                    + data.getIsLastConquest() + " porcentagem de acertos "
                    + data.getPercentage() + "%");
        }
        System.out.println("-----------------------------------");
    }

    @Override
    public void changePeriodOfConquest(int init, int end) {
        clearAllArrays();
        initArrays();
        for (LoteriasModel data : conn.getAllConquestsOfSpecificLoto(conquestType).subList(init, end)) {
            concursos.add(data);
        }
    }

    public void getNumbersMostAwardedWhitooutExcluders() {

    }

    @Override
    public void createBet(int numberOfPairs, int numberOfOdd, int numberOfPrimes) {
        // final List<String> finalBet;

        for (int i = 0; i < numberOfPrimes; i++) {
            primeNumbers.get(i).getDezena();
        }

    }

    public void getFaixaMostAwarded() {
        for (LoteriasModel loteriasModel : concursos) {
            for (String dezena : loteriasModel.getDezenas()) {

            }
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
