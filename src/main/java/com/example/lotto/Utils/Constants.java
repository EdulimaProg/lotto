package com.example.lotto.Utils;

import com.example.lotto.Model.LotoType;

public interface Constants {
    String BASE_URL = "https://loteriascaixa-api.herokuapp.com/api/";

    String MEGASENA = "mega-sena";
    String LOTOFACIL = "lotofacil";
    String QUINA = "quina";
    String LOTOMANIA = "lotomania";
    String TIMEMANIA = "timemania";
    String DUPLASENA = "dupla-sena";
    String FEDERAL = "loteria-federal";
    String DIADESORTE = "dia-de-sorte";
    String SUPERSETE = "super-sete";

    int LOTOFACILQTD = 25;
    int LOTOMANIAQTD = 100;
    int MEGASENAQTD = 60;
    int QUINAQTD = 80;
    int DIADESORTEQTD = 31;
    int DUPLASENAQTD = 50;

    String[] allMonths = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
            "Outubro", "Novembro", "Dezembro" };

    int[] tenNumbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    static LotoType diaSorte = new LotoType(DIADESORTE, 4, 10, 10, DIADESORTE, DIADESORTEQTD, 1);
    static LotoType duplasena = new LotoType(DUPLASENA, 5, 10, 10, DUPLASENA, DUPLASENAQTD, 1);
    static LotoType lotofacil = new LotoType(LOTOFACIL, 5, 5, 5, LOTOFACIL, LOTOFACILQTD, 1);
    static LotoType lotomania = new LotoType(LOTOMANIA, 10, 10, 10, LOTOMANIA, LOTOMANIAQTD, 0);
    static LotoType megasena = new LotoType(MEGASENA, 6, 10, 10, MEGASENA, MEGASENAQTD, 1);
    static LotoType quina = new LotoType(QUINA, 8, 10, 10, QUINA, QUINAQTD, 1);
    // "mega-sena",
    // "lotofacil",
    // "quina",
    // "lotomania",
    // "timemania",
    // "dupla-sena",
    // "loteria-federal",
    // "dia-de-sorte",
    // "super-sete"
}