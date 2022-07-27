package com.example.lotto.Model;

import java.util.ArrayList;

public class Conferencia {
    ArrayList<String> myBet;
    ArrayList<String> betAwarded;
    int hitsNumbers;
    int pairNumbers;
    int oddNumbers;
    int primeNumbers;
    int isRescurring;

    public ArrayList<String> getMyBet() {
        return myBet;
    }

    public void setMyBet(ArrayList<String> myBet) {
        this.myBet = myBet;
    }

    public int getHitsNumbers() {
        return hitsNumbers;
    }

    public void setHitsNumbers(int hitsNumbers) {
        this.hitsNumbers = hitsNumbers;
    }

    public int getPairNumbers() {
        return pairNumbers;
    }

    public void setPairNumbers(int pairNumbers) {
        this.pairNumbers = pairNumbers;
    }

    public int getOddNumbers() {
        return oddNumbers;
    }

    public void setOddNumbers(int oddNumbers) {
        this.oddNumbers = oddNumbers;
    }

    public int getPrimeNumbers() {
        return primeNumbers;
    }

    public void setPrimeNumbers(int primeNumbers) {
        this.primeNumbers = primeNumbers;
    }

    public int getIsRescurring() {
        return isRescurring;
    }

    public void setIsRescurring(int isRescurring) {
        this.isRescurring = isRescurring;
    }

    public ArrayList<String> getBetAwarded() {
        return betAwarded;
    }

    public void setBetAwarded(ArrayList<String> betAwarded) {
        this.betAwarded = betAwarded;
    }
}
