package com.example.lotto.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.example.lotto.Model.Dezenas;
import com.example.lotto.Services.HttpConnection;

public class Utils {
    private String conquest;
    static HttpConnection conn = new HttpConnection();

    public Utils(String conquest) {
        this.conquest = conquest;
    }

    public static boolean isPrimos(int numero) {
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

    public void getPrimoMostAwarded(ArrayList<List<String>> primoDataList, int type, ArrayList<Dezenas> dezenasData) {
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

    public void getPairAndOddMostAwarded(ArrayList<List<String>> pairDataList, ArrayList<List<String>> oddDataList,
            int conquestInit, int conquestInterval) {
        System.out.println("criando array getPairAndOddMostAwarded");

        for (int i = 0; i < conquestInterval; i++) {
            ArrayList<String> data = conn.getCoquestNumber(conquest, String.valueOf(conquestInit - i)).getDezenas();
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

    public void getPrimesAndNotPrimes(ArrayList<List<String>> primoDataList, ArrayList<List<String>> notPrimoDataList,
            int conquestInit, int conquestInterval) {
        System.out.println("criando array getPrimesNumberMostAwarded");

        for (int i = 0; i < conquestInterval; i++) {
            ArrayList<String> data = conn.getCoquestNumber(conquest, String.valueOf(conquestInit - i)).getDezenas();
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

    public boolean checkIfIsOutIsLastConquest(String value) {
        if (conn.getLatestConquest(conquest).getDezenas().contains(value)) {
            return true;
        }
        return false;
    }

    public double percentageOfAward(int awards, int conquest) {
        double percentage = Double.valueOf(awards) / Double.valueOf(conquest);
        return percentage * 100;
    }

    public String getIsLastConquest(Boolean value) {
        if (value) {
            return "SIM";

        }
        return "NÂO";
    }
}
