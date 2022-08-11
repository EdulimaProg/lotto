package com.example.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.example.lotto.LottoRepo.LotoFacil.Lotofacil;
import com.example.lotto.LottoRepo.Megasena.Megasena;

public class App {

    public static void main(String[] args) {
        Lotofacil loto = new Lotofacil();
        // Megasena loto = new Megasena();

        // lotofacil.witchRange("24");

        // Lotomania loto = new Lotomania();
        // LotteryFaixas faixas = new LotteryFaixas();
        // LotoType megasena = new LotoType("Megasena", 6, 10);
        // LotoType lotofacil = new LotoType("Lotofacil", 5, 5);
        // LotoType lotomania = new LotoType("Lotofacil", 10, 10);

        // LotoFaixa faixa = faixas.createFaixas(megasena);

        // System.out.println(faixa.getLottoInFaixa());

        // faixas.megasenaFaixas();

        // lotofacil.initConquest();

        // lotofacil.printAllArray();

        // loto.changePeriodOfConquest(0, 10);

        // loto.initConquest();

        // loto.changePeriodOfConquest(0, 10);

        // // loto.initConquest();
        // ArrayList<String> eclNumbers = new ArrayList<>();

        // loto.changePeriodOfConquest(0, 10);
        // loto.initConquest();

        // System.out.println("---------------------------------------------");
        // System.out.println("Loto 1");
        // Lotofacil loto1 = new Lotofacil();
        // loto1.setExcludeNumbers(Arrays.asList("24", "03", "18", "17"));
        // loto1.setNumberOfStart(1);
        // loto1.setMostAwardedQtd(12);
        // loto1.setNotMostAwardeQtd(3);
        // loto1.createBets(2, 10);
        // System.out.println("---------------------------------------------");
        // System.out.println("Loto 2");
        // Lotofacil loto2 = new Lotofacil();
        // loto2.setExcludeNumbers(Arrays.asList("04", "07", "21", "08"));
        // loto2.setMostAwardedQtd(12);
        // loto2.setNotMostAwardeQtd(3);
        // loto2.createBets(2, 20);
        // System.out.println("---------------------------------------------");
        // System.out.println("Loto 3");
        // Lotofacil loto3 = new Lotofacil();
        // loto3.setExcludeNumbers(Arrays.asList("04", "18", "17", "08"));
        // loto3.setMostAwardedQtd(8);
        // loto3.setNotMostAwardeQtd(7);
        // loto3.createBets(2, 40);
        // System.out.println("---------------------------------------------");
        // System.out.println("Loto 4");
        // Lotofacil loto4 = new Lotofacil();
        // loto4.setExcludeNumbers(Arrays.asList("01", "18", "17", "02", "25"));
        // loto4.setMostAwardedQtd(8);
        // loto4.setNotMostAwardeQtd(7);
        // loto4.createBets(2, 60);
        // System.out.println("---------------------------------------------");
        // System.out.println("Loto 5");
        // Lotofacil loto5 = new Lotofacil();
        // loto5.setMostAwardedQtd(9);
        // loto5.setNotMostAwardeQtd(6);
        // loto5.createBets(2, 70);
        // System.out.println("---------------------------------------------");
        // System.out.println("Loto 6");
        // Lotofacil loto6 = new Lotofacil();
        // loto6.setMostAwardedQtd(2);
        // loto6.setNotMostAwardeQtd(13);
        // loto6.createBets(2, 20);
        // System.out.println("---------------------------------------------");

        // loto.printAllArray();

        ArrayList<String> listbets = new ArrayList();

        System.out.println("---------------------------------------------");
        System.out.println("Loto 1");
        Lotofacil loto1 = new Lotofacil();
        loto1.setFavoriteNumbers(Arrays.asList("01", "02", "05"));
        loto1.setExcludeNumbers(Arrays.asList("03", "06", "04", "21", "18"));
        loto1.setNumberOfStart(1);
        loto1.setMostAwardedQtd(4);
        loto1.setNotMostAwardeQtd(11);
        loto1.createBets(1, 10);
        listbets.addAll(loto1.getListString());
        System.out.println("---------------------------------------------");
        System.out.println(listbets.size());
        System.out.println("---------------------------------------------");
        System.out.println("Loto 2");
        Lotofacil loto2 = new Lotofacil();
        loto2.setFavoriteNumbers(Arrays.asList("04", "05", "07"));
        loto2.setExcludeNumbers(Arrays.asList("06", "09", "12", "17", "23"));
        loto2.setNumberOfStart(1);
        loto2.setMostAwardedQtd(11);
        loto2.setNotMostAwardeQtd(4);
        loto2.createBets(1, 10);
        listbets.addAll(loto2.getListString());
        System.out.println("---------------------------------------------");
        System.out.println(listbets.size());
        System.out.println("---------------------------------------------");
        System.out.println("Loto 3");
        Lotofacil loto3 = new Lotofacil();
        loto2.setFavoriteNumbers(Arrays.asList("02", "04", "06"));
        loto2.setExcludeNumbers(Arrays.asList("05", "01", "03", "11", "20"));
        loto3.setNumberOfStart(1);
        loto3.setMostAwardedQtd(10);
        loto3.setNotMostAwardeQtd(5);
        loto3.createBets(1, 10);
        listbets.addAll(loto3.getListString());
        System.out.println("---------------------------------------------");
        System.out.println(listbets.size());
        System.out.println("---------------------------------------------");
        System.out.println("Loto 4");
        Lotofacil loto4 = new Lotofacil();
        loto4.setExcludeNumbers(Arrays.asList("08", "09", "03", "11"));
        loto4.setNumberOfStart(1);
        loto4.setMostAwardedQtd(7);
        loto4.setNotMostAwardeQtd(8);
        loto4.createBets(1, 10);
        listbets.addAll(loto4.getListString());
        System.out.println("---------------------------------------------");
        System.out.println(listbets.size());
        System.out.println("---------------------------------------------");
        System.out.println("Loto 5");
        Lotofacil loto5 = new Lotofacil();
        loto5.setFavoriteNumbers(Arrays.asList("03", "05"));
        loto5.setExcludeNumbers(Arrays.asList("01", "02", "16", "21"));
        loto5.setNumberOfStart(1);
        loto5.setMostAwardedQtd(6);
        loto5.setNotMostAwardeQtd(9);
        loto5.createBets(1, 10);
        listbets.addAll(loto5.getListString());
        System.out.println("---------------------------------------------");
        System.out.println(listbets.size());
        System.out.println("---------------------------------------------");
        System.out.println("Loto 6");
        Lotofacil loto6 = new Lotofacil();
        loto6.setFavoriteNumbers(Arrays.asList("02", "06", "04"));
        loto6.setExcludeNumbers(Arrays.asList("01", "24", "25", "19"));
        loto6.setNumberOfStart(1);
        loto6.setMostAwardedQtd(5);
        loto6.setNotMostAwardeQtd(10);
        loto6.createBets(1, 10);
        listbets.addAll(loto6.getListString());
        System.out.println("---------------------------------------------");
        System.out.println(listbets.size());
        System.out.println("---------------------------------------------");
        System.out.println("Loto 7");
        Lotofacil loto7 = new Lotofacil();
        // loto7.setExcludeNumbers(Arrays.asList("21", "07", "19"));
        loto7.setNumberOfStart(1);
        loto7.setMostAwardedQtd(4);
        loto7.setNotMostAwardeQtd(11);
        loto7.createBets(1, 10);
        listbets.addAll(loto7.getListString());
        System.out.println("---------------------------------------------");
        System.out.println(listbets.size());
        System.out.println("---------------------------------------------");
        System.out.println("Loto 8");
        Lotofacil loto8 = new Lotofacil();
        loto8.setFavoriteNumbers(Arrays.asList("01", "02", "03", "05"));
        loto8.setExcludeNumbers(Arrays.asList("09", "14", "07", "11", "22"));
        loto8.setNumberOfStart(1);
        loto8.setMostAwardedQtd(10);
        loto8.setNotMostAwardeQtd(5);
        loto8.createBets(1, 10);
        listbets.addAll(loto8.getListString());
        System.out.println("---------------------------------------------");
        System.out.println(listbets.size());
        System.out.println("---------------------------------------------");
        System.out.println("Loto 9");
        Lotofacil loto9 = new Lotofacil();
        // loto9.setExcludeNumbers(Arrays.asList("03", "05", "11", "13"));
        loto9.setNumberOfStart(1);
        loto9.setMostAwardedQtd(6);
        loto9.setNotMostAwardeQtd(9);
        loto9.createBets(1, 10);
        listbets.addAll(loto9.getListString());
        System.out.println("---------------------------------------------");
        System.out.println(listbets.size());
        System.out.println("---------------------------------------------");
        System.out.println("Loto 10");
        Lotofacil loto10 = new Lotofacil();
        loto10.setFavoriteNumbers(Arrays.asList("21", "22", "19", "20"));
        loto10.setExcludeNumbers(Arrays.asList("24", "13", "14", "08"));
        loto10.setNumberOfStart(1);
        loto10.setMostAwardedQtd(8);
        loto10.setNotMostAwardeQtd(7);
        loto10.createBets(1, 10);
        listbets.addAll(loto10.getListString());
        System.out.println("---------------------------------------------");
        System.out.println(listbets.size());
        System.out.println("---------------------------------------------");
        System.out.println("Loto 10");
        Lotofacil loto11 = new Lotofacil();
        // loto6.setExcludeNumbers(Arrays.asList("01", "02", "11", "13"));
        loto11.setNumberOfStart(1);
        loto11.setMostAwardedQtd(8);
        loto11.setNotMostAwardeQtd(7);
        loto11.createBets(1, 10);
        listbets.addAll(loto11.getListString());
        System.out.println("---------------------------------------------");
        System.out.println(listbets.size());
        System.out.println("---------------------------------------------");
        System.out.println("Loto 10");
        Lotofacil loto12 = new Lotofacil();
        // loto6.setExcludeNumbers(Arrays.asList("01", "02", "11", "13"));
        loto12.setNumberOfStart(1);
        loto12.setMostAwardedQtd(8);
        loto12.setNotMostAwardeQtd(7);
        loto12.createBets(1, 10);
        listbets.addAll(loto12.getListString());
        System.out.println("---------------------------------------------");
        System.out.println(listbets.size());

        for (int i = 0; i < listbets.size(); i++) {
            System.out.println(listbets.get(i));
        }
        // lotofacil.print();
        // loto.inLastCoquest();
        // loto.inLastCoquest();
        // lotomania.print();

        // String[] lotos = {
        // "03 07 08 10 17 18 20 23 24 25 26 28 31 34 36 37 38 40 41 45 46 47 49 50 51
        // 53 55 56 58 59 61 64 68 72 74 75 76 77 81 83 84 86 87 88 89 92 93 97 98 99",
        // "02 03 05 07 09 10 13 17 18 20 21 23 24 27 28 32 33 34 37 38 40 41 45 48 51
        // 52 53 58 59 61 64 67 68 70 72 73 74 75 76 77 81 84 86 89 91 92 97 98 99 00",
        // "05 07 08 09 11 15 17 18 21 22 24 25 28 29 31 32 34 37 39 40 44 46 48 49 50
        // 51 52 53 56 58 59 61 62 64 69 70 76 78 80 81 82 84 87 88 91 94 96 97 99 00",
        // "01 02 03 05 06 07 10 12 13 14 15 17 18 21 22 23 24 26 28 29 30 35 36 38 39
        // 40 41 42 44 47 48 50 51 55 57 60 61 62 64 69 71 74 79 80 81 82 91 92 97 98",
        // "01 02 04 06 07 10 12 13 14 15 16 17 18 21 22 23 24 28 30 31 33 36 38 39 42
        // 43 44 45 48 50 51 54 57 60 61 63 69 72 74 76 81 83 86 91 93 94 95 97 99 00",
        // "01 02 03 04 05 06 07 12 13 17 18 21 22 25 30 38 39 40 41 43 44 45 48 51 57
        // 58 59 61 62 66 69 71 73 74 79 80 81 86 87 88 89 90 91 92 93 95 96 97 98 00",
        // "01 02 04 08 09 11 13 19 20 22 25 27 31 34 37 39 46 52 53 55 56 58 59 60 62
        // 64 65 66 67 68 70 72 73 75 76 78 80 82 84 85 87 88 89 90 93 95 96 97 99 00",
        // "01 05 08 11 12 16 17 19 23 25 26 32 34 35 37 40 43 44 46 49 52 53 55 56 57
        // 58 60 63 64 65 66 67 68 71 72 73 74 75 77 78 79 82 84 86 95 96 97 98 99 00",
        // "01 08 09 11 12 18 19 20 25 27 32 34 35 39 44 46 49 51 52 53 54 55 56 57 58
        // 59 62 64 65 66 68 71 73 75 77 78 80 82 84 85 87 88 89 90 93 96 97 98 99 00",
        // "02 03 04 06 07 10 13 14 15 17 21 22 24 26 28 30 31 33 36 37 38 40 42 44 45
        // 47 48 50 51 52 54 57 59 60 61 63 67 69 70 72 74 76 79 81 83 86 91 92 94 95",
        // "02 03 04 06 07 10 13 14 15 16 17 21 22 24 28 30 33 36 37 38 40 42 45 47 48
        // 50 51 52 59 60 61 63 64 67 69 70 72 73 76 77 79 81 83 84 86 91 94 95 97 99",
        // "01 03 04 06 07 10 14 15 16 17 18 20 21 22 24 28 29 30 31 32 33 36 38 40 41
        // 42 44 47 48 50 51 52 54 59 60 61 63 65 69 70 72 74 76 77 81 91 92 93 94 95",
        // };

        List<Integer> data = Arrays.asList(10, 6, 8, 17, 21, 9, 22, 13, 1, 12, 15, 20, 05, 24, 23);

        Collections.sort(data, new Comparator<Integer>() {
            public int compare(Integer s1, Integer s2) {
                return s1.compareTo(s2);
            }
        });

        System.out.println(data);
        String[] bets = {

        };

        // 24 quantidade de vezes 10 saiu no ultimo true porcentagem de acertos 100%
        // Faixa 5
        // 04 quantidade de vezes 8 saiu no ultimo true porcentagem de acertos 80% Faixa
        // 1
        // 07 quantidade de vezes 8 saiu no ultimo true porcentagem de acertos 80% Faixa
        // 2
        // 08 quantidade de vezes 8 saiu no ultimo false porcentagem de acertos 80%
        // Faixa 2
        // 15 quantidade de vezes 8 saiu no ultimo false porcentagem de acertos 80%
        // Faixa 3
        // 21 quantidade de vezes 8 saiu no ultimo true porcentagem de acertos 80% Faixa
        // 5
        // 03 quantidade de vezes 7 saiu no ultimo true porcentagem de acertos 70% Faixa
        // 1
        // 05 quantidade de vezes 7 saiu no ultimo true porcentagem de acertos 70% Faixa
        // 1
        // 10 quantidade de vezes 7 saiu no ultimo false porcentagem de acertos 70%
        // Faixa 2
        // 18 quantidade de vezes 7 saiu no ultimo false porcentagem de acertos 70%
        // Faixa 4
        // 01 quantidade de vezes 6 saiu no ultimo true porcentagem de acertos 60% Faixa
        // 1
        // 13 quantidade de vezes 6 saiu no ultimo false porcentagem de acertos 60%
        // Faixa 3
        // 16 quantidade de vezes 6 saiu no ultimo false porcentagem de acertos 60%
        // Faixa 4
        // 22 quantidade de vezes 6 saiu no ultimo false porcentagem de acertos 60%
        // Faixa 5
        // 23 quantidade de vezes 6 saiu no ultimo true porcentagem de acertos 60% Faixa
        // 5
        // 09 quantidade de vezes 5 saiu no ultimo true porcentagem de acertos 50% Faixa
        // 2
        // 11 quantidade de vezes 5 saiu no ultimo true porcentagem de acertos 50% Faixa
        // 3
        // 12 quantidade de vezes 5 saiu no ultimo true porcentagem de acertos 50% Faixa
        // 3
        // 14 quantidade de vezes 5 saiu no ultimo true porcentagem de acertos 50% Faixa
        // 3
        // 20 quantidade de vezes 5 saiu no ultimo true porcentagem de acertos 50% Faixa
        // 4
        // 02 quantidade de vezes 4 saiu no ultimo true porcentagem de acertos 40% Faixa
        // 1
        // 19 quantidade de vezes 4 saiu no ultimo false porcentagem de acertos 40%
        // Faixa 4
        // 25 quantidade de vezes 4 saiu no ultimo false porcentagem de acertos 40%
        // Faixa 5
        // 17 quantidade de vezes 3 saiu no ultimo true porcentagem de acertos 30% Faixa
        // 4
        // 06 quantidade de vezes 2 saiu no ultimo false porcentagem de acertos 20%
        // Faixa 2
        // faixa
        // 01,03,04,05,07,08,10,11,12,13,15,16,18,20
        // 01,02,03,04,05,11,12,14,15,16,17,18,20,21
        // 01,02,05,06,07,08,09,10,12,16,18,20,21,22
        // 01,03,04,05,07,08,10,11,12,13,15,16,18,20
        // 01,02,03,04,05,11,12,14,15,16,17,18,20,21
        // 01,02,05,06,07,08,09,10,12,16,18,20,21,22

        //
        // 01,03,04,05,07,08,10,11,12,13,15,16,18,21,22
        // 01,02,03,04,05,07,09,10,12,14,15,16,20,21,23
        // 01,02,06,11,12,14,15,16,17,18,20,21,22,23,24
        // 01,02,03,04,05,06,07,09,10,11,12,17,18,21,22
        // 02,03,05,07,08,09,11,12,16,18,19,20,21,22,24
        // 01,02,04,05,06,07,08,12,14,16,17,18,22,23,24
        // 01,02,05,06,11,12,13,14,16,18,20,21,22,23,24
        // 01,02,03,04,05,06,07,08,09,11,12,14,15,16,21
        // 01,02,03,04,05,07,09,10,11,13,14,19,20,22,23
        // 02,03,04,05,06,08,09,11,12,14,17,18,19,20,22
        // 01,02,05,06,08,10,11,12,13,14,16,20,21,23,24
        // 1

        // for (String string : lotos) {
        // System.out.println(string.replace(" ", ","));
        // }

    }

    // -- MySQL Script generated by MySQL Workbench
    // -- Tue Aug 9 07:51:31 2022
    // -- Model: New Model Version: 1.0
    // -- MySQL Workbench Forward Engineering

    // SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
    // SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
    // SET @OLD_SQL_MODE=@@SQL_MODE,
    // SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

    // -- -----------------------------------------------------
    // -- Schema lotto
    // -- -----------------------------------------------------

    // -- -----------------------------------------------------
    // -- Schema lotto
    // -- -----------------------------------------------------
    // CREATE SCHEMA IF NOT EXISTS `lotto` DEFAULT CHARACTER SET utf8 ;
    // USE `lotto` ;

    // -- -----------------------------------------------------
    // -- Table `lotto`.`table1`
    // -- -----------------------------------------------------
    // CREATE TABLE IF NOT EXISTS `lotto`.`table1` (
    // )
    // ENGINE = InnoDB;

    // -- -----------------------------------------------------
    // -- Table `lotto`.`user_table`
    // -- -----------------------------------------------------
    // CREATE TABLE IF NOT EXISTS `lotto`.`user_table` (
    // `user_id` INT NOT NULL AUTO_INCREMENT,
    // `user_email` VARCHAR(45) NOT NULL,
    // `user_password` VARCHAR(45) NOT NULL,
    // PRIMARY KEY (`user_id`))
    // ENGINE = InnoDB;

    // -- -----------------------------------------------------
    // -- Table `lotto`.`bets`
    // -- -----------------------------------------------------
    // CREATE TABLE IF NOT EXISTS `lotto`.`bets` (
    // `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    // `conquest` INT NOT NULL,
    // `date` DATETIME NOT NULL,
    // `numbers_awarded` VARCHAR(50) NULL,
    // `lotery` VARCHAR(45) NOT NULL,
    // `user_table_user_id` INT NOT NULL,
    // PRIMARY KEY (`id`),
    // INDEX `fk_bets_user_table1_idx` (`user_table_user_id` ASC) VISIBLE,
    // CONSTRAINT `fk_bets_user_table1`
    // FOREIGN KEY (`user_table_user_id`)
    // REFERENCES `lotto`.`user_table` (`user_id`)
    // ON DELETE NO ACTION
    // ON UPDATE NO ACTION)
    // ENGINE = InnoDB;

    // -- -----------------------------------------------------
    // -- Table `lotto`.`lotto_stats`
    // -- -----------------------------------------------------
    // CREATE TABLE IF NOT EXISTS `lotto`.`lotto_stats` (
    // `id` INT NOT NULL AUTO_INCREMENT,
    // `number_awarded` VARCHAR(45) NULL,
    // `prime_numbers` VARCHAR(45) NULL,
    // `pair_numbers` VARCHAR(45) NULL,
    // PRIMARY KEY (`id`))
    // ENGINE = InnoDB;

    // -- -----------------------------------------------------
    // -- Table `lotto`.`lottobet`
    // -- -----------------------------------------------------
    // CREATE TABLE IF NOT EXISTS `lotto`.`lottobet` (
    // `id` INT NOT NULL AUTO_INCREMENT,
    // `numbers` VARCHAR(45) NOT NULL,
    // `bets_id` INT UNSIGNED NOT NULL,
    // `quantity` INT NOT NULL,
    // `mes_sorte` VARCHAR(45) NULL,
    // `time_sorte` VARCHAR(45) NULL,
    // `lotto_stats_id` INT NOT NULL,
    // PRIMARY KEY (`id`, `bets_id`),
    // INDEX `fk_lottobet_bets_idx` (`bets_id` ASC) VISIBLE,
    // INDEX `fk_lottobet_lotto_stats1_idx` (`lotto_stats_id` ASC) VISIBLE,
    // CONSTRAINT `fk_lottobet_bets`
    // FOREIGN KEY (`bets_id`)
    // REFERENCES `lotto`.`bets` (`id`)
    // ON DELETE NO ACTION
    // ON UPDATE NO ACTION,
    // CONSTRAINT `fk_lottobet_lotto_stats1`
    // FOREIGN KEY (`lotto_stats_id`)
    // REFERENCES `lotto`.`lotto_stats` (`id`)
    // ON DELETE NO ACTION
    // ON UPDATE NO ACTION)
    // ENGINE = InnoDB;

    // -- -----------------------------------------------------
    // -- Table `lotto`.`number_most_awarded`
    // -- -----------------------------------------------------
    // CREATE TABLE IF NOT EXISTS `lotto`.`number_most_awarded` (
    // `id` INT NOT NULL AUTO_INCREMENT,
    // `number_most_awardedcol` VARCHAR(45) NULL,
    // `month` VARCHAR(45) NULL,
    // PRIMARY KEY (`id`))
    // ENGINE = InnoDB;

    // -- -----------------------------------------------------
    // -- Table `lotto`.`lottery_total`
    // -- -----------------------------------------------------
    // CREATE TABLE IF NOT EXISTS `lotto`.`lottery_total` (
    // `id` INT NOT NULL AUTO_INCREMENT,
    // `number_of_coquest_participate` INT NULL,
    // `number_of_conquest_winning` INT NULL,
    // `total_value_spend` DOUBLE NULL,
    // `total_spend_per_win` DOUBLE NULL,
    // `total_value_winning` DOUBLE NULL,
    // `user_table_user_id` INT NOT NULL,
    // PRIMARY KEY (`id`),
    // INDEX `fk_lottery_total_user_table1_idx` (`user_table_user_id` ASC) VISIBLE,
    // CONSTRAINT `fk_lottery_total_user_table1`
    // FOREIGN KEY (`user_table_user_id`)
    // REFERENCES `lotto`.`user_table` (`user_id`)
    // ON DELETE NO ACTION
    // ON UPDATE NO ACTION)
    // ENGINE = InnoDB;

    // -- -----------------------------------------------------
    // -- Table `lotto`.`lotterys`
    // -- -----------------------------------------------------
    // CREATE TABLE IF NOT EXISTS `lotto`.`lotterys` (
    // `id` INT NOT NULL AUTO_INCREMENT,
    // `lotto_name` VARCHAR(45) NOT NULL,
    // `lotto_quantity_played` INT NOT NULL,
    // `last_data_played` DATETIME NOT NULL,
    // `total_value_spend` DOUBLE NOT NULL,
    // `total_value_winning` DOUBLE NOT NULL,
    // `user_table_user_id` INT NOT NULL,
    // `max_number_awarded` INT NULL,
    // PRIMARY KEY (`id`),
    // INDEX `fk_lotterys_user_table1_idx` (`user_table_user_id` ASC) VISIBLE,
    // CONSTRAINT `fk_lotterys_user_table1`
    // FOREIGN KEY (`user_table_user_id`)
    // REFERENCES `lotto`.`lottery_total` (`id`)
    // ON DELETE NO ACTION
    // ON UPDATE NO ACTION)
    // ENGINE = InnoDB;

    // -- -----------------------------------------------------
    // -- Table `lotto`.`numbers`
    // -- -----------------------------------------------------
    // CREATE TABLE IF NOT EXISTS `lotto`.`numbers` (
    // `numbers_id` INT NOT NULL AUTO_INCREMENT,
    // `number` VARCHAR(2) NULL,
    // `number_quantity_played` INT NULL,
    // `lotterys_id` INT NOT NULL,
    // `numbers_award_quantity` VARCHAR(45) NULL,
    // PRIMARY KEY (`numbers_id`),
    // INDEX `fk_numbers_lotterys1_idx` (`lotterys_id` ASC) VISIBLE,
    // CONSTRAINT `fk_numbers_lotterys1`
    // FOREIGN KEY (`lotterys_id`)
    // REFERENCES `lotto`.`lotterys` (`id`)
    // ON DELETE NO ACTION
    // ON UPDATE NO ACTION)
    // ENGINE = InnoDB;

    // SET SQL_MODE=@OLD_SQL_MODE;
    // SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
    // SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

}
