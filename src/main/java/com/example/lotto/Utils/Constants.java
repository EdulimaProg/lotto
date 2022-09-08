package com.example.lotto.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    int[] tenNumbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

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