package com.example.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import com.example.lotto.LottoRepo.Lotofacil;
import com.example.lotto.Model.Dezenas;
import com.example.lotto.Model.LoteriasModel;
import com.example.lotto.Services.*;
import com.example.lotto.Utils.Constants;

public class App {

    static HttpConnection conn = new HttpConnection();
    // Arrays
    static ArrayList<ArrayList<String>> listConquests = new ArrayList<ArrayList<String>>();
    static ArrayList<String> bet = new ArrayList<String>();
    static ArrayList<Dezenas> dezenasData = new ArrayList<Dezenas>();
    static ArrayList<Dezenas> sequenceList = new ArrayList<Dezenas>();

    static ArrayList<List<String>> primoDataList = new ArrayList<List<String>>();
    static ArrayList<List<String>> notPrimoDataList = new ArrayList<List<String>>();
    static ArrayList<List<String>> pairDataList = new ArrayList<List<String>>();
    static ArrayList<List<String>> oddDataList = new ArrayList<List<String>>();

    static ArrayList<Dezenas> numberPairMostAwarded = new ArrayList<Dezenas>();
    static ArrayList<Dezenas> notNumberPairMostAwarded = new ArrayList<Dezenas>();

    static ArrayList<Dezenas> numberPrimosMostAwarded = new ArrayList<Dezenas>();
    static ArrayList<Dezenas> notNumberPrimosMostAwarded = new ArrayList<Dezenas>();

    static String conquestType;
    static int conquestCarateresQTD;
    static boolean ignoreZeros = false;

    static int intervalStart;
    static int intervalEnd;

    public static void main(String[] args) {

        conquestType = Constants.LOTOFACIL;
        conquestCarateresQTD = Constants.LOTOFACILQTD;

        System.out.println("get: " + conquestType);

        intervalStart = 0;
        intervalEnd = 2;

        List<LoteriasModel> conquests = getSpecifiList(0, intervalEnd);

        // lottoToList(conquests);

        // getMostAwarded(listConquests, dezenasData);

        Lotofacil lotofacil = new Lotofacil(conn.getAllConquestsOfSpecificLoto(Constants.LOTOFACIL));

        lotofacil.getMostAwardedInSpecificInterval(intervalStart, intervalEnd);
        System.out.println("---------------------------------");
        lotofacil.printNumerosMaisSorteados();
        System.out.println("---------------------------------");
        lotofacil.getNumberMostAwardedInLastTenCoquest();
        System.out.println("---------------------------------");
        lotofacil.printNumerosMaisSorteados();
        System.out.println("---------------------------------");
        // numberSequencePerConquest(getLastAwardedConquest(), 40);

        // // createBet();
        // ArrayList<Integer> preferedNumbers = new ArrayList<Integer>();
        // preferedNumbers.add(1);
        // preferedNumbers.add(7);
        // preferedNumbers.add(15);
        // preferedNumbers.add(16);
        // preferedNumbers.add(25);
        // preferedNumbers.add(10);

        // betGenerator(preferedNumbers, 21);

        // getLastFourConquest(conquests, 4);

        // getPrimesNumberMostAwarded(getLastAwardedConquest(), intervalEnd);
        // getPrimoMostAwarded(primoDataList, conquestCarateresQTD,
        // numberPrimosMostAwarded);
        // getPrimoMostAwarded(notPrimoDataList, conquestCarateresQTD,
        // notNumberPrimosMostAwarded);

        // getPairAndOddMostAwarded(getLastAwardedConquest(), intervalEnd);
        // getPrimoMostAwarded(pairDataList, conquestCarateresQTD,
        // numberPairMostAwarded);
        // getPrimoMostAwarded(oddDataList, conquestCarateresQTD,
        // notNumberPairMostAwarded);

        // Collections.sort(dezenasData, new Comparator<Dezenas>() {
        // public int compare(Dezenas s1, Dezenas s2) {
        // return Integer.valueOf(s2.getQuantidade()).compareTo(s1.getQuantidade());
        // }
        // });

        // Collections.sort(dezenasData, new Comparator<Dezenas>() {
        // public int compare(Dezenas s1, Dezenas s2) {
        // return Integer.valueOf(s1.getQuantidade()).compareTo(s2.getQuantidade());
        // }
        // });

        // System.out.println("---------------------------------");
        // System.out.println("Pair number");
        // printArrays(numberPairMostAwarded);
        // System.out.println("---------------------------------");
        // System.out.println("Odd number");
        // printArrays(notNumberPairMostAwarded);
        // System.out.println("---------------------------------");
        // System.out.println("Prime number");
        // printArrays(numberPrimosMostAwarded);
        // System.out.println("---------------------------------");
        // System.out.println("Not prime number");
        // printArrays(notNumberPrimosMostAwarded);
        // System.out.println("---------------------------------");
        // System.out.println("number most awarded");
        // printArrays(dezenasData);
        // System.out.println("---------------------------------");
        // System.out.println("number most awarded");
        // printArrays(sequenceList, false);
        // System.out.println("---------------------------------");
    }

    private static void conferenceBet() {
        ArrayList<String> awardedList = conn.getLatestConquest(conquestType).getDezenas();
    }

    private static int getLastAwardedConquest() {
        return conn.getLatestConquest(conquestType).getConcurso();
    }

    private static void betGenerator(ArrayList<Integer> preferedNumbers, int lottoSize) {
        Random random = new Random();
        ArrayList<Integer> intergerList = new ArrayList<Integer>();

        System.out.println(intergerList.size());

        intergerList.addAll(preferedNumbers);

        System.out.println(intergerList.size());

        while (intergerList.size() != lottoSize) {
            int number = random.nextInt(26);
            if (!intergerList.contains(number)) {
                if (number != 0) {
                    intergerList.add(number);
                }

            }

        }

        Collections.sort(intergerList);

        System.out.println(intergerList);

    }

    private static boolean isPrimos(int numero) {
        for (int j = 2; j < numero; j++) {
            if (numero % j == 0)
                return false;
        }
        return true;
    }

    public static boolean isPair(int numero) {
        if (numero % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void getMostAwarded(List<ArrayList<String>> list, ArrayList<Dezenas> dezenasData) {
        System.out.println("criando array getMostAwarded");
        int numberOfStart;

        if (conquestCarateresQTD == 99) {
            numberOfStart = 0;
        } else {
            numberOfStart = 1;
        }

        for (int i = 0; i < conquestCarateresQTD; i++) {
            int valueOfRepeat = 0;
            String number = "";
            for (ArrayList<String> listData : list) {
                if (listData.contains(String.format("%02d", i + numberOfStart))) {
                    valueOfRepeat = valueOfRepeat + 1;
                }
                number = String.format("%02d", i + numberOfStart);
            }
            Dezenas dex = new Dezenas();

            dex.setDezena(number);
            dex.setQuantidade(valueOfRepeat);
            dex.setLastConquest(checkIfIsOutIsLastConquest(String.format("%02d", i + numberOfStart)));

            dezenasData.add(dex);
        }
        System.out.println("Fim criacão do array getMostAwarded");

        Collections.sort(dezenasData, new Comparator<Dezenas>() {
            public int compare(Dezenas s1, Dezenas s2) {
                return Integer.valueOf(s2.getQuantidade()).compareTo(s1.getQuantidade());
            }
        });

    }

    public static void getPrimoMostAwarded(ArrayList<List<String>> primoDataList, int type,
            ArrayList<Dezenas> dezenasData) {
        System.out.println("criando array getPrimoMostAwarded");
        int numberOfStart;

        if (type == 99) {
            numberOfStart = 0;
        } else {
            numberOfStart = 1;
        }

        for (int i = 0; i < type; i++) {
            int valueOfRepeat = 0;
            for (List<String> listData : primoDataList) {
                if (listData.contains(String.format("%02d", i + numberOfStart))) {
                    valueOfRepeat = valueOfRepeat + 1;
                }
            }
            Dezenas dex = new Dezenas();

            dex.setDezena(String.format("%02d", i + numberOfStart));
            dex.setQuantidade(valueOfRepeat);
            dex.setLastConquest(checkIfIsOutIsLastConquest(String.format("%02d", i + numberOfStart)));

            dezenasData.add(dex);
        }
        System.out.println("fim criacao getPrimoMostAwarded");

        Collections.sort(dezenasData, new Comparator<Dezenas>() {
            public int compare(Dezenas s1, Dezenas s2) {
                return Integer.valueOf(s2.getQuantidade()).compareTo(s1.quantidade);
            }
        });

    }

    public static boolean checkIfIsOutIsLastConquest(String value) {
        if (conn.getLatestConquest(Constants.LOTOMANIA).getDezenas().contains(value)) {
            return true;
        }
        return false;
    }

    public static List<LoteriasModel> getSpecifiList(int start, int end) {
        return conn.getAllConquestsOfSpecificLoto(conquestType).subList(start, end);
    }

    public static LoteriasModel getSpecificLottoConquest(String conquestNumber) {
        return conn.getCoquestNumber(conquestType, conquestNumber);
    }

    public static void lottoToList(List<LoteriasModel> conquests) {

        for (LoteriasModel data : conquests) {
            ArrayList<String> lotoNumbers = new ArrayList<String>();
            // System.out.println(data.getDezenas());
            for (String lotoData : data.getDezenas()) {
                lotoNumbers.add(lotoData);
                // if (isPrimos(Integer.parseInt(lotoData))) {
                // lotoNumbers.add(lotoData);
                // }
            }
            listConquests.add(lotoNumbers);
        }
    }

    public static void getLastFourConquest(List<LoteriasModel> conquest, int conquestInterval) {

        for (int i = 0; i < conquestInterval; i++) {

            System.out.println(conn.getCoquestNumber(conquestType, String.valueOf(conquest.get(0).getConcurso() - i))
                    .getDezenas());
        }
    }

    public static void getPrimesNumberMostAwarded(int conquestInit, int conquestInterval) {
        System.out.println("criando array getPrimesNumberMostAwarded");
        primoDataList.clear();
        notPrimoDataList.clear();

        for (int i = 0; i < conquestInterval; i++) {
            ArrayList<String> data = conn.getCoquestNumber(conquestType, String.valueOf(conquestInit - i)).getDezenas();
            ArrayList<String> primoData = new ArrayList<String>();
            ArrayList<String> notPrimoData = new ArrayList<String>();

            for (String data_val : data) {
                if (isPrimos(Integer.parseInt(data_val))) {
                    primoData.add(data_val);
                } else {
                    notPrimoData.add(data_val);
                }
            }
            primoDataList.add(primoData);
            notPrimoDataList.add(notPrimoData);
        }

        System.out.println("Fim criacão do arry getPrimesNumberMostAwarded");

    }

    public static void getPairAndOddMostAwarded(int conquestInit, int conquestInterval) {
        System.out.println("criando array getPairAndOddMostAwarded");
        pairDataList.clear();
        oddDataList.clear();

        for (int i = 0; i < conquestInterval; i++) {
            ArrayList<String> data = conn.getCoquestNumber(conquestType, String.valueOf(conquestInit - i)).getDezenas();
            ArrayList<String> primoData = new ArrayList<String>();
            ArrayList<String> notPrimoData = new ArrayList<String>();

            for (String data_val : data) {
                if (isPair(Integer.parseInt(data_val))) {
                    primoData.add(data_val);
                } else {
                    notPrimoData.add(data_val);
                }
            }
            pairDataList.add(primoData);
            oddDataList.add(notPrimoData);
        }
        System.out.println("Fim criacão do arry getPairAndOddMostAwarded");

    }

    private static void printArrays(ArrayList<Dezenas> array) {
        if (ignoreZeros) {
            for (Dezenas data : array) {
                if (data.getQuantidade() != 0) {
                    System.out.println(data.getDezena() + " quantidade de vezes " + data.getQuantidade());
                }
            }
        } else {
            for (Dezenas data : array) {
                System.out.println(data.getDezena() + " quantidade de vezes " + data.getQuantidade());
            }
        }
    }

    public static void numberSequencePerConquest(int conquestInit, int conquestInterval) {

        System.out.println("criacão do arry sequence list");

        ArrayList<LoteriasModel> dataLottoList = new ArrayList<LoteriasModel>();

        for (int i = 0; i < conquestInterval; i++) {
            dataLottoList.add(getSpecificLottoConquest(String.valueOf(conquestInit - i)));
        }

        for (int i = 0; i < Constants.LOTOFACILQTD; i++) {
            for (LoteriasModel data : dataLottoList) {
                System.out.println("concurso" + data.getConcurso());
                System.out.println(data);
            }
        }

        System.out.println("Fim criacão do arry sequence list");

    }

}
