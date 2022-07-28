package com.example.lotto.LottoRepo.Interface;

public abstract class Lotto {
    public abstract void initConquest();

    public abstract void print();

    public abstract void printAllArray();

    public abstract void changePeriodOfConquest(int init, int end);

    public abstract void createBet(int numberOfPairs, int numberOfOdd, int numberOfPrimes);
}
