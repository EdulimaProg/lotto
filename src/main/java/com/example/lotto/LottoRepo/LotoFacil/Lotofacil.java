package com.example.lotto.LottoRepo.LotoFacil;

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

import org.apache.commons.codec.binary.Base64OutputStream;

import com.example.lotto.LottoRepo.Interface.Lotto;
import com.example.lotto.Model.Dezenas;
import com.example.lotto.Model.LoteriasModel;
import com.example.lotto.Model.LotoType;
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
    //
    private ArrayList<LoteriasModel> concursos = new ArrayList<>();
    private ArrayList<Dezenas> numbersMostAwarded = new ArrayList<>();
    private ArrayList<Dezenas> pairMostAwarded = new ArrayList<>();
    private ArrayList<Dezenas> primeNumbers = new ArrayList<>();
    private ArrayList<String> listString = new ArrayList<>();
    // private ArrayList<Dezenas> ExcludersNumbers = new ArrayList<>();
    // private ArrayList<Dezenas> withOutExcluders = new ArrayList<>();
    DecimalFormat df = new DecimalFormat("#,###");

    private String conquestType = Constants.LOTOFACIL;
    private int conquestCarateresQTD = Constants.LOTOFACILQTD;
    private LotoType lotofacil;
    private LotteryRangers ltr;

    public Lotofacil() {
        System.out.println("Create " + this.getClass().getSimpleName() + " BET");
        this.concursos = conn.getAllConquestsOfSpecificLoto(conquestType);
        lotofacil = new LotoType("Lotofacil", 5, 5);
        ltr = new LotteryRangers();
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

    public void changePerMonth(String month) {
        clearAllArrays();
        initArrays();

        switch (month) {
        case "Janeiro":
            for (LoteriasModel data : conn.getAllConquestsOfSpecificLoto(conquestType)) {
                System.out.println();
                concursos.add(data);
            }
            break;

        case "Fevereiro":
            for (LoteriasModel data : conn.getAllConquestsOfSpecificLoto(conquestType)) {
                concursos.add(data);
            }
            break;

        case "Marco":
            for (LoteriasModel data : conn.getAllConquestsOfSpecificLoto(conquestType)) {
                concursos.add(data);
            }
            break;

        case "Abril":
            for (LoteriasModel data : conn.getAllConquestsOfSpecificLoto(conquestType)) {
                concursos.add(data);
            }
            break;

        case "Maio":
            for (LoteriasModel data : conn.getAllConquestsOfSpecificLoto(conquestType)) {
                concursos.add(data);
            }
            break;

        case "Junho":
            for (LoteriasModel data : conn.getAllConquestsOfSpecificLoto(conquestType)) {
                concursos.add(data);
            }
            break;

        case "Julho":
            for (LoteriasModel data : conn.getAllConquestsOfSpecificLoto(conquestType)) {
                concursos.add(data);
            }
            break;

        case "Agosto":
            for (LoteriasModel data : conn.getAllConquestsOfSpecificLoto(conquestType)) {
                concursos.add(data);
            }
            break;

        case "Setembro":
            for (LoteriasModel data : conn.getAllConquestsOfSpecificLoto(conquestType)) {
                concursos.add(data);
            }
            break;

        case "Outubro":
            for (LoteriasModel data : conn.getAllConquestsOfSpecificLoto(conquestType)) {
                concursos.add(data);
            }
            break;

        case "Novembro":
            for (LoteriasModel data : conn.getAllConquestsOfSpecificLoto(conquestType)) {
                concursos.add(data);
            }
            break;

        case "Dezembro":
            for (LoteriasModel data : conn.getAllConquestsOfSpecificLoto(conquestType)) {
                concursos.add(data);
            }
            break;

        default:
            break;
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

    public String witchRange(String number) {
        String rangeResponse = " ";
        for (int i = 0; i < lotofacil.getLotoLineSize(); i++) {
            if (ltr.lotofacilFaixas().getLottoInFaixa().get(i).contains(number)) {
                rangeResponse = "Faixa " + (i + 1);
            }

        }
        return rangeResponse;
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

    public void formbet() {

        numbersMostAwarded.clear();
        changePeriodOfConquest(0, 5);
        getHistoricMostAwarded();
        String bet1 = "";
        transformInString(bet1);
        numbersMostAwarded.clear();
        changePeriodOfConquest(5, 10);
        getHistoricMostAwarded();
        String bet2 = "";
        transformInString(bet2);
        numbersMostAwarded.clear();
        changePeriodOfConquest(10, 15);
        getHistoricMostAwarded();
        String bet3 = "";
        transformInString(bet3);
        numbersMostAwarded.clear();
        changePeriodOfConquest(15, 20);
        getHistoricMostAwarded();
        String bet4 = "";
        transformInString(bet4);
        numbersMostAwarded.clear();
        changePeriodOfConquest(20, 25);
        getHistoricMostAwarded();
        String bet5 = "";
        transformInString(bet5);
        numbersMostAwarded.clear();
        changePeriodOfConquest(25, 30);
        getHistoricMostAwarded();
        String bet6 = "";
        transformInString(bet6);
        numbersMostAwarded.clear();
        changePeriodOfConquest(30, 35);
        getHistoricMostAwarded();
        String bet7 = "";
        transformInString(bet7);
        numbersMostAwarded.clear();
        changePeriodOfConquest(35, 40);
        getHistoricMostAwarded();
        String bet8 = "";
        transformInString(bet8);
        numbersMostAwarded.clear();
        changePeriodOfConquest(40, 45);
        getHistoricMostAwarded();
        String bet9 = "";
        transformInString(bet9);
        numbersMostAwarded.clear();
        changePeriodOfConquest(45, 50);
        getHistoricMostAwarded();
        String bet10 = "";
        transformInString(bet10);
        numbersMostAwarded.clear();
        changePeriodOfConquest(50, 55);
        getHistoricMostAwarded();
        String bet11 = "";
        transformInString(bet11);
        numbersMostAwarded.clear();
        changePeriodOfConquest(55, 60);
        getHistoricMostAwarded();
        String bet12 = "";
        transformInString(bet12);

        for (String string : listString) {
            System.out.println(string);
        }

    }

    public void transformInString(String bet) {
        List<Dezenas> subList = numbersMostAwarded.subList(0, 16);

        Collections.sort(subList, new Comparator<Dezenas>() {
            public int compare(Dezenas s1, Dezenas s2) {
                return Integer.valueOf(s1.getDezena()).compareTo(Integer.valueOf(s2.getDezena()));
            }
        });
        for (Dezenas dataDezenas : subList) {
            if (bet == "") {
                bet = dataDezenas.getDezena();
            } else {
                bet = bet + "," + dataDezenas.getDezena();
            }

        }
        listString.add(bet);

    }

}
