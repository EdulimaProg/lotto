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
        Lotofacil lotofacil = new Lotofacil();

        lotofacil.initConquest();

        lotofacil.printAllArray();

        lotofacil.changePeriodOfConquest(0, 10);

        lotofacil.initConquest();

        lotofacil.printAllArray();

        // lotofacil.print();
    }
}
