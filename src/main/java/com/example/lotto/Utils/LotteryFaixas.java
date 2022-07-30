package com.example.lotto.Utils;

import java.util.*;

import com.example.lotto.Model.LotoFaixa;
import com.example.lotto.Model.LotoType;

public class LotteryFaixas {

    public LotoFaixa lotofacilFaixas() {
        // int lotoNumberLenght = 60;
        LotoFaixa data = new LotoFaixa();
        int lotoLineLenght = 5;
        int lotoNumberPerLine = 5;
        int count = 0;
        ArrayList<String> lotoNumbers = new ArrayList<>();

        ArrayList<List<String>> lotoBet = new ArrayList<>();

        data.setLottoName("Lotofacil");
        data.setLottoFaixaQtd(lotoLineLenght);

        for (int i = 0; i < lotoLineLenght; i++) {
            ArrayList<String> lotoLine = new ArrayList<>();
            for (int j = 0; j < lotoNumberPerLine; j++) {
                lotoLine.add(ST((j + 1) + count));
            }
            count = count + 5;
            lotoBet.add(lotoLine);
        }

        // System.out.println(lotoBet);
        data.setLottoInFaixa(lotoBet);

        return data;
    }

    public LotoFaixa lotomaniaFaixas() {
        int faixaLength = 10;
        int[] intList = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<List<String>> dataList = new ArrayList<>();
        List<String> faixa;
        LotoFaixa data = new LotoFaixa();
        int valueOfStart = 0;

        data.setLottoName("Lotomania");
        data.setLottoFaixaQtd(faixaLength);

        while (dataList.size() != faixaLength) {
            if (dataList.size() >= 9) {
                faixa = Arrays.asList(ST(intList[0] + valueOfStart), ST(intList[1] + valueOfStart),
                        ST(intList[2] + valueOfStart), ST(intList[3] + valueOfStart), ST(intList[4] + valueOfStart),
                        ST(intList[5] + valueOfStart), ST(intList[6] + valueOfStart), ST(intList[7] + valueOfStart),
                        ST(intList[8] + valueOfStart), ST(0));
            } else {
                faixa = Arrays.asList(ST(intList[0] + valueOfStart), ST(intList[1] + valueOfStart),
                        ST(intList[2] + valueOfStart), ST(intList[3] + valueOfStart), ST(intList[4] + valueOfStart),
                        ST(intList[5] + valueOfStart), ST(intList[6] + valueOfStart), ST(intList[7] + valueOfStart),
                        ST(intList[8] + valueOfStart), ST(intList[9] + valueOfStart));
            }
            System.out.println(faixa);
            dataList.add(faixa);
            valueOfStart = valueOfStart + 10;
        }

        data.setLottoInFaixa(dataList);

        return data;
    }

    public LotoFaixa megasenaFaixas() {
        // int lotoNumberLenght = 60;
        LotoFaixa data = new LotoFaixa();
        int lotoLineLenght = 6;
        int lotoNumberPerLine = 10;
        int count = 0;
        ArrayList<String> lotoNumbers = new ArrayList<>();

        ArrayList<List<String>> lotoBet = new ArrayList<>();

        data.setLottoName("Megasena");
        data.setLottoFaixaQtd(lotoLineLenght);

        for (int i = 0; i < lotoLineLenght; i++) {
            ArrayList<String> lotoLine = new ArrayList<>();
            for (int j = 0; j < lotoNumberPerLine; j++) {
                lotoLine.add(ST((j + 1) + count));
            }
            count = count + 10;
            lotoBet.add(lotoLine);
        }
        data.setLottoInFaixa(lotoBet);

        return data;
    }

    public LotoFaixa createFaixas(LotoType type) {
        // int lotoNumberLenght = 60;
        LotoFaixa data = new LotoFaixa();

        int count = 0;
        ArrayList<String> lotoNumbers = new ArrayList<>();

        ArrayList<List<String>> lotoBet = new ArrayList<>();

        data.setLottoName("Megasena");
        data.setLottoFaixaQtd(type.getLotoLineSize());

        for (int i = 0; i < type.getLotoLineSize(); i++) {
            ArrayList<String> lotoLine = new ArrayList<>();
            if (i == 9 && type.getLotoLineSize() == 10) {
                for (int j = 0; j < type.getLotoNumberSizePerLine() - 1; j++) {
                    lotoLine.add(ST((j + 1) + count));
                }
                lotoLine.add(ST(0));
            } else {
                for (int j = 0; j < type.getLotoNumberSizePerLine(); j++) {
                    lotoLine.add(ST((j + 1) + count));
                }
            }
            count = count + type.getLotoNumberSizePerLine();

            lotoBet.add(lotoLine);
        }
        data.setLottoInFaixa(lotoBet);

        return data;
    }

    public String ST(int val) {
        return String.format("%02d", val);
    }
}
