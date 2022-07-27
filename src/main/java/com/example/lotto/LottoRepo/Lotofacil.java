package com.example.lotto.LottoRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.example.lotto.Model.Dezenas;
import com.example.lotto.Model.LoteriasModel;
import com.example.lotto.Services.HttpConnection;
import com.example.lotto.Utils.Constants;

public class Lotofacil {
    private HttpConnection conn = new HttpConnection();
    private ArrayList<LoteriasModel> concursos = new ArrayList<>();
    private ArrayList<Dezenas> numerosMaisSorteados = new ArrayList<>();

    private String conquestType = Constants.LOTOFACIL;
    private int conquestCarateresQTD = Constants.LOTOFACILQTD;

    public Lotofacil(ArrayList<LoteriasModel> concursos) {
        System.out.println("Create Lotofacil BET");
        this.concursos = concursos;
    }

    public void print() {
        System.out.println(concursos);
    }

    public void getHistoricMostAwarded() {
        System.out.println("get most getHistoricMostAwarded");

        numerosMaisSorteados.clear();

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
            dex.setLastConquest(checkIfIsOutIsLastConquest(String.format("%02d", i + numberOfStart)));

            numerosMaisSorteados.add(dex);
        }

        Collections.sort(numerosMaisSorteados, new Comparator<Dezenas>() {
            public int compare(Dezenas s1, Dezenas s2) {
                return Integer.valueOf(s2.getQuantidade()).compareTo(s1.getQuantidade());
            }
        });

        System.out.println("end get most getHistoricMostAwarded");

    }

    public void getNumberMostAwardedInLastFiveCoquest() {
        System.out.println("get most getNumberMostAwardedInLastFiveCoquest");

        numerosMaisSorteados.clear();

        int numberOfStart = 0;
        for (int i = 0; i < conquestCarateresQTD; i++) {
            int valueOfRepeat = 0;
            String number = "";
            for (LoteriasModel listData : concursos.subList(0, 5)) {
                if (listData.getDezenas().contains(String.format("%02d", i + numberOfStart))) {
                    valueOfRepeat = valueOfRepeat + 1;
                }
                number = String.format("%02d", i + numberOfStart);
            }
            Dezenas dex = new Dezenas();

            dex.setDezena(number);
            dex.setQuantidade(valueOfRepeat);
            dex.setLastConquest(checkIfIsOutIsLastConquest(String.format("%02d", i + numberOfStart)));

            numerosMaisSorteados.add(dex);
        }

        Collections.sort(numerosMaisSorteados, new Comparator<Dezenas>() {
            public int compare(Dezenas s1, Dezenas s2) {
                return Integer.valueOf(s2.getQuantidade()).compareTo(s1.getQuantidade());
            }
        });

        System.out.println("end get most getNumberMostAwardedInLastFiveCoquest");

    }

    public void getNumberMostAwardedInLastTenCoquest() {
        System.out.println("get most getNumberMostAwardedInLastTenCoquest");

        numerosMaisSorteados.clear();

        int numberOfStart = 0;
        for (int i = 0; i < conquestCarateresQTD; i++) {
            int valueOfRepeat = 0;
            String number = "";
            for (LoteriasModel listData : concursos.subList(0, 10)) {
                if (listData.getDezenas().contains(String.format("%02d", i + numberOfStart))) {
                    valueOfRepeat = valueOfRepeat + 1;
                }
                number = String.format("%02d", i + numberOfStart);
            }
            Dezenas dex = new Dezenas();

            dex.setDezena(number);
            dex.setQuantidade(valueOfRepeat);
            dex.setLastConquest(checkIfIsOutIsLastConquest(String.format("%02d", i + numberOfStart)));

            numerosMaisSorteados.add(dex);
        }

        Collections.sort(numerosMaisSorteados, new Comparator<Dezenas>() {
            public int compare(Dezenas s1, Dezenas s2) {
                return Integer.valueOf(s2.getQuantidade()).compareTo(s1.getQuantidade());
            }
        });

        System.out.println("end get most getNumberMostAwardedInLastTenCoquest");

    }

    public void getNumberMostAwardedInLastTwentyCoquest() {
        System.out.println("get most getNumberMostAwardedInLastTwentyCoquest");
        numerosMaisSorteados.clear();

        int numberOfStart = 1;
        for (int i = 0; i < conquestCarateresQTD; i++) {
            int valueOfRepeat = 0;
            String number = "";
            for (LoteriasModel listData : concursos.subList(0, 20)) {
                if (listData.getDezenas().contains(String.format("%02d", i + numberOfStart))) {
                    valueOfRepeat = valueOfRepeat + 1;
                }
                number = String.format("%02d", i + numberOfStart);
            }
            Dezenas dex = new Dezenas();

            dex.setDezena(number);
            dex.setQuantidade(valueOfRepeat);
            dex.setLastConquest(checkIfIsOutIsLastConquest(String.format("%02d", i + numberOfStart)));

            numerosMaisSorteados.add(dex);
        }

        Collections.sort(numerosMaisSorteados, new Comparator<Dezenas>() {
            public int compare(Dezenas s1, Dezenas s2) {
                return Integer.valueOf(s2.getQuantidade()).compareTo(s1.getQuantidade());
            }
        });
        System.out.println("end get most getNumberMostAwardedInLastTwentyCoquest");
    }

    public void getNumberMostAwardedInLastThirdyCoquest() {
        System.out.println("get most getNumberMostAwardedInLastThirdyCoquest");
        numerosMaisSorteados.clear();

        int numberOfStart = 1;
        for (int i = 0; i < conquestCarateresQTD; i++) {
            int valueOfRepeat = 0;
            String number = "";
            for (LoteriasModel listData : concursos.subList(0, 30)) {
                if (listData.getDezenas().contains(String.format("%02d", i + numberOfStart))) {
                    valueOfRepeat = valueOfRepeat + 1;
                }
                number = String.format("%02d", i + numberOfStart);
            }
            Dezenas dex = new Dezenas();

            dex.setDezena(number);
            dex.setQuantidade(valueOfRepeat);
            dex.setLastConquest(checkIfIsOutIsLastConquest(String.format("%02d", i + numberOfStart)));

            numerosMaisSorteados.add(dex);
        }

        Collections.sort(numerosMaisSorteados, new Comparator<Dezenas>() {
            public int compare(Dezenas s1, Dezenas s2) {
                return Integer.valueOf(s2.getQuantidade()).compareTo(s1.getQuantidade());
            }
        });
        System.out.println("end get most getNumberMostAwardedInLastThirdyCoquest");
    }

    public void getMostAwardedInSpecificInterval(int intervalInit, int intervalEnd) {
        System.out.println("get most getMostAwardedInSpecificInterval");
        numerosMaisSorteados.clear();

        int numberOfStart = 1;
        for (int i = 0; i < conquestCarateresQTD; i++) {
            int valueOfRepeat = 0;
            String number = "";
            for (LoteriasModel listData : concursos.subList(intervalInit, intervalEnd)) {
                if (listData.getDezenas().contains(String.format("%02d", i + numberOfStart))) {
                    valueOfRepeat = valueOfRepeat + 1;
                }
                number = String.format("%02d", i + numberOfStart);
            }
            Dezenas dex = new Dezenas();

            dex.setDezena(number);
            dex.setQuantidade(valueOfRepeat);
            dex.setLastConquest(checkIfIsOutIsLastConquest(String.format("%02d", i + numberOfStart)));

            numerosMaisSorteados.add(dex);
        }

        Collections.sort(numerosMaisSorteados, new Comparator<Dezenas>() {
            public int compare(Dezenas s1, Dezenas s2) {
                return Integer.valueOf(s2.getQuantidade()).compareTo(s1.getQuantidade());
            }
        });

        System.out.println("end get most getMostAwardedInSpecificInterval");
    }

    public void printNumerosMaisSorteados() {
        for (Dezenas data : numerosMaisSorteados) {
            System.out.println(data.getDezena() + " quantidade de vezes " + data.getQuantidade());
        }
    }

    public boolean checkIfIsOutIsLastConquest(String value) {
        if (concursos.get(0).getDezenas().contains(value)) {
            return true;
        }
        return false;
    }

}
